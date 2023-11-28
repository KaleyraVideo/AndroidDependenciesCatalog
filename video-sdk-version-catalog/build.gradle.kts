import dependencies.InternalDependencies
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
        InternalDependencies.versions.forEach { version -> version(version.alias, version.version) }
        // plugins
        InternalDependencies.plugins.forEach { plugin -> plugin(plugin.alias, plugin.id).versionRef(plugin.version.alias) }
        // libraries
        InternalDependencies.libraries.forEach { library -> library(library.alias, library.groupId, library.artifactId).versionRef(library.version.alias) }
    }
}

afterEvaluate {
    publishing {
        repositories {
            maven { configureMavenRepository(this) }
        }
        publications {
            create<MavenPublication>("video-sdk-version-catalog") {
                val versionCatalogPublicationConfig = VersionCatalogPublicationConfig(
                    artifactId = name,
                    artifactVersion = releaseArtifactVersion,
                    catalogComponent = components["versionCatalog"],
                    mavenPublication = this,
                    libraryGroup = kaleyraLibraryGroup,
                    libraries = InternalDependencies.libraries)

                configureMavenPublication(versionCatalogPublicationConfig)
            }
        }
    }
}
