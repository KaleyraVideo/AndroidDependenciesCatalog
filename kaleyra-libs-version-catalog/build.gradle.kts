import dependencies.KaleyraDependencies
import model.*

plugins {
    `maven-publish`
    `version-catalog`
}

apply {
    from("../publish.gradle.kts")
}

catalog {
    versionCatalog {
        // versions
        KaleyraDependencies.versions.forEach { version -> version(version.alias, version.version) }
        // plugins
        KaleyraDependencies.plugins.forEach { plugin -> plugin(plugin.alias, plugin.id).versionRef(plugin.version.alias) }
        // libraries
        KaleyraDependencies.libraries.forEach { library -> library(library.alias, library.groupId, library.artifactId).versionRef(library.version.alias) }
    }
}

afterEvaluate {
    publishing {
        repositories {
            maven { configureMavenRepository(this) }
        }

        publications {
            create<MavenPublication>("kaleyra-libs-version-catalog") {
                val versionCatalogPublicationConfig = VersionCatalogPublicationConfig(
                    artifactId = name,
                    artifactVersion = releaseArtifactVersion,
                    catalogComponent = components["versionCatalog"],
                    mavenPublication = this,
                    libraryGroup = kaleyraLibraryGroup,
                    libraries = KaleyraDependencies.libraries)

                configureMavenPublication(versionCatalogPublicationConfig)
            }
        }
    }
}
