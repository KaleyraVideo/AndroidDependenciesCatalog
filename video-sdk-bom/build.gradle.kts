import model.*

plugins {
    `maven-publish`
}

apply {
    from("../publish.gradle.kts")
}

afterEvaluate {
    publishing {
        repositories {
            maven { configureMavenRepository(this) }
        }

        publications {
            create<MavenPublication>("kaleyra-bom") {
                val bomPublicationConfig = BomPublicationConfig(
                    artifactId = "video-sdk-bom",
                    artifactVersion = kaleyraVideoSdkVersion,
                    mavenPublication = this,
                    libraryGroup = kaleyraLibraryGroup,
                    libraries = bom.KaleyraBom.libraries)

                configureMavenPublication(bomPublicationConfig)
            }
        }
    }
}
