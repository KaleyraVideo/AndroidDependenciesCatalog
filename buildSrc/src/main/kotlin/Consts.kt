const val kaleyraLibraryGroup = "com.kaleyra"
const val publishPath = "releases"

val catalogVersion = "2024.10.01"
val bomVersion = "4.0.3"
val mavenAccessKey = runCatching { getLocalProperty("maven.accessKey") }.getOrNull() ?: ""
val mavenSecretKey = runCatching { getLocalProperty("maven.secretKey") }.getOrNull() ?: ""
val mavenDistributionId = runCatching { getLocalProperty("maven.distributionId") }.getOrNull() ?: ""
