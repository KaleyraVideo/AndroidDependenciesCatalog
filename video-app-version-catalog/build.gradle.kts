import dependencies.SampleAppDependencies
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
        SampleAppDependencies.versions.forEach { version -> version(version.alias, version.version) }
        // plugins
        SampleAppDependencies.plugins.forEach { plugin -> plugin(plugin.alias, plugin.id).versionRef(plugin.version.alias) }
        // libraries
        SampleAppDependencies.libraries.forEach { library -> library(library.alias, library.groupId, library.artifactId).versionRef(library.version.alias) }
    }
}

afterEvaluate {
    publishing {
        repositories {
            maven { configureMavenRepository(this) }
        }

        publications {
            create<MavenPublication>("video-app-version-catalog") {
                val versionCatalogPublicationConfig = VersionCatalogPublicationConfig(
                    artifactId = name,
                    artifactVersion = catalogVersion,
                    catalogComponent = components["versionCatalog"],
                    mavenPublication = this,
                    libraryGroup = kaleyraLibraryGroup,
                    libraries = SampleAppDependencies.libraries.toList())

                configureMavenPublication(versionCatalogPublicationConfig)
            }
        }
    }
}
