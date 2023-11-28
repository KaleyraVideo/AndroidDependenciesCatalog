rootProject.name = "android-catalog"

include(":kaleyra-libs-version-catalog")
include(":video-sdk-version-catalog")
include(":video-app-version-catalog")
include(":video-sdk-bom")
include(":bandyer-android-sdk-bom")
include(":version-catalog-updater")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {

        if (File("video-sdk-version-catalog/build/version-catalog/libs.versions.toml").exists()) {
            create("videoSdkVersionCatalog") {
                from(files("video-sdk-version-catalog/build/version-catalog/libs.versions.toml"))
            }
        }

        if (File("video-app-version-catalog/build/version-catalog/libs.versions.toml").exists()) {
            create("videoAppVersionCatalog") {
                from(files("video-app-version-catalog/build/version-catalog/libs.versions.toml"))
            }
        }

        if (File("kaleyra-libs-version-catalog/build/version-catalog/libs.versions.toml").exists()) {
            create("kaleyraLibsVersionCatalog") {
                from(files("kaleyra-libs-version-catalog/build/version-catalog/libs.versions.toml"))
            }
        }
    }
}
