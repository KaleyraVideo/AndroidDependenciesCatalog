const val kaleyraLibraryGroup = "com.kaleyra"
const val publishPath = "releases"

val catalogVersion = "2024.07.02"
val bomVersion = "4.0.0-rc16"
val mavenAccessKey = runCatching { getLocalProperty("maven.accessKey") }.getOrNull() ?: ""
val mavenSecretKey = runCatching { getLocalProperty("maven.secretKey") }.getOrNull() ?: ""
val mavenDistributionId = runCatching { getLocalProperty("maven.distributionId") }.getOrNull() ?: ""
