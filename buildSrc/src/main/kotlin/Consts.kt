import getLocalProperty

const val bandyerLibraryGroup = "com.bandyer"
const val kaleyraLibraryGroup = "com.kaleyra"

const val dryRun = true
val releaseArtifactVersion = "2023.09.03"
val bomV3ArtifactVersion = "3.7.3"
val bomV4ArtifactVersion = "1.0.0-alpha10"
val mavenAccessKey = runCatching { getLocalProperty("maven.accessKey") }.getOrNull() ?: ""
val mavenSecretKey = runCatching { getLocalProperty("maven.secretKey") }.getOrNull() ?: ""
val mavenDistributionId = runCatching { getLocalProperty("maven.distributionId") }.getOrNull() ?: ""
