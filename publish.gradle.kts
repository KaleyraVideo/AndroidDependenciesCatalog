val newBomVersion: String by project
val newCatalogVersion: String by project
val kaleyraLibName: String by project
val kaleyraLibVersion: String by project
val dryRun: String by project

val kaleyraLibsVersionCatalogPackages = mapOf<String, String>(
    "com.kaleyra.kaleyra-libs-version-catalog" to catalogVersion,
    "com.kaleyra.video-sdk-version-catalog" to catalogVersion,
    "com.kaleyra.video-app-version-catalog" to catalogVersion,
    "com.kaleyra.video-sdk-bom" to bomVersion
)

tasks.register<Exec>("invalidateCache") {
    val invalidatePackage =
        kaleyraLibsVersionCatalogPackages.entries.first { it.key.contains(project.name) }
    workingDir = File("$rootDir/scripts")
    println("invalidating maven cache: ${invalidatePackage.key} ${invalidatePackage.value}")
    commandLine(
        "python3",
        "./invalidate_s3_cache.py",
        mavenAccessKey,
        mavenSecretKey,
        mavenDistributionId,
        publishPath,
        invalidatePackage.key,
        invalidatePackage.value
    )
}

tasks.register<Exec>("updateBom") {
    workingDir = File("$rootDir/scripts")
    commandLine("python3", "./bump_bom.py", "-cv", bomVersion, "-nv", newBomVersion)
}

tasks.register<Exec>("updateCatalog") {
    workingDir = File("$rootDir/scripts")
    commandLine("python3", "./bump_catalog.py", "-cv", catalogVersion, "-nv", newCatalogVersion)
}

tasks.register<Exec>("updateKaleyraLibVersion") {
    workingDir = File("$rootDir/scripts")
    commandLine(
        "python3",
        "./update_kaleyra_lib_version.py",
        "-n",
        kaleyraLibName,
        "-v",
        kaleyraLibVersion
    )
}

tasks.register("publishUploadBom") {
    if (project.name != "video-sdk-bom") return@register
    val publishTask = if (dryRun.toBoolean()) "publishToMavenLocal" else "publish"
    println("publishing ${project.name} to ${if (dryRun.toBoolean()) "local" else "remote"} maven repository ...")
    dependsOn(publishTask)
    dependsOn("invalidateCache")
    tasks.findByName("invalidateCache")?.mustRunAfter(publishTask)
}

tasks.register("publishUploadCatalog") {
    if (!project.name.contains("catalog")) return@register
    val publishTask = if (dryRun.toBoolean()) "publishToMavenLocal" else "publish"
    println("publishing ${project.name} to ${if (dryRun.toBoolean()) "local" else "remote"} maven repository ...")
    dependsOn(publishTask)
    dependsOn("invalidateCache")
    tasks.findByName("invalidateCache")?.mustRunAfter(publishTask)
}
