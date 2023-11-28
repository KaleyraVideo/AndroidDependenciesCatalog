import bom.BandyerBom
import bom.KaleyraBom
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
            create<MavenPublication>("bandyer-bom") {
                val bomPublicationConfig = BomPublicationConfig(
                    artifactId = "bandyer-android-sdk-bom",
                    artifactVersion = bomV3ArtifactVersion,
                    mavenPublication = this,
                    libraryGroup = bandyerLibraryGroup,
                    libraries = BandyerBom.libraries)

                configureMavenPublication(bomPublicationConfig)
            }

            create<MavenPublication>("kaleyra-bom") {
                val bomPublicationConfig = BomPublicationConfig(
                    artifactId = "video-sdk-bom",
                    artifactVersion = bomV4ArtifactVersion,
                    mavenPublication = this,
                    libraryGroup = kaleyraLibraryGroup,
                    libraries = KaleyraBom.libraries)

                configureMavenPublication(bomPublicationConfig)
            }
        }
    }
}
