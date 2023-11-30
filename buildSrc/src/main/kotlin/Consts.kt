const val kaleyraLibraryGroup = "com.kaleyra"
const val publishPath = "releases"

const val dryRun = false
val releaseArtifactVersion = "2023.11.02"
val kaleyraVideoSdkVersion = "4.0.0-rc02"
val mavenAccessKey = runCatching { getLocalProperty("maven.accessKey") }.getOrNull() ?: ""
val mavenSecretKey = runCatching { getLocalProperty("maven.secretKey") }.getOrNull() ?: ""
val mavenDistributionId = runCatching { getLocalProperty("maven.distributionId") }.getOrNull() ?: ""
