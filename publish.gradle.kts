val publishPath = "releases"

val kaleyraLibsVersionCatalogPackages = mapOf<String, String>(
    "com.kaleyra.kaleyra-libs-version-catalog" to releaseArtifactVersion,
    "com.kaleyra.video-sdk-version-catalog" to releaseArtifactVersion,
    "com.kaleyra.video-app-version-catalog" to releaseArtifactVersion,
    "com.bandyer.bandyer-android-sdk-bom" to bomV3ArtifactVersion,
    "com.kaleyra.video-sdk-bom" to bomV4ArtifactVersion
)

tasks.register<Exec>("invalidateCache") {
    val invalidatePackage = kaleyraLibsVersionCatalogPackages.entries.first { it.key.contains(project.name) }
    workingDir = File("$rootDir/scripts")
    println("invalidating maven cache: ${invalidatePackage.key} ${invalidatePackage.value}")
    commandLine("python3", "./invalidate_s3_cache.py", mavenAccessKey, mavenSecretKey, mavenDistributionId, publishPath, invalidatePackage.key, invalidatePackage.value)
}

tasks.register("publishUpload") {
    val publishTask = if (dryRun) "publishToMavenLocal" else "publish"
    println("publishing ${project.name} to ${if (dryRun) "local" else "remote"} maven repository ...")
    dependsOn(publishTask)
    dependsOn("invalidateCache")
    tasks.findByName("invalidateCache")?.mustRunAfter(publishTask)
}
