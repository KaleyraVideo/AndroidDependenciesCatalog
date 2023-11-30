/*
 * Copyright (C) 2023 Kaleyra S.p.A. All Rights Reserved.
 * See LICENSE.txt for licensing information
 */

plugins {
    id("com.github.ben-manes.versions") version ("0.48.0")
    id("nl.littlerobots.version-catalog-update") version ("0.8.1")
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.android.library") version "7.3.1" apply false
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://maven.bandyer.com/releases") }
        maven { url = uri("https://developer.huawei.com/repo/") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://maven.bandyer.com/releases") }
        maven { url = uri("https://developer.huawei.com/repo/") }
    }
}

versionCatalogUpdate {
    versionCatalogs {
        create("videoSdkVersionCatalog") {
            catalogFile.set(file("video-sdk-version-catalog/build/version-catalog/libs.versions.toml"))
            // not sorted
            sortByKey.set(false)
            keep {
                keepUnusedVersions.set(true)
                keepUnusedPlugins.set(true)
                keepUnusedLibraries.set(true)
            }
        }
        create("kaleyraLibsVersionCatalog") {
            catalogFile.set(file("kaleyra-libs-version-catalog/build/version-catalog/libs.versions.toml"))
            sortByKey.set(false)
            keep {
                keepUnusedVersions.set(true)
                keepUnusedPlugins.set(true)
                keepUnusedLibraries.set(true)
            }
        }
        create("videoAppVersionCatalog") {
            catalogFile.set(file("video-app-version-catalog/build/version-catalog/libs.versions.toml"))
            sortByKey.set(false)
            keep {
                keepUnusedVersions.set(true)
                keepUnusedPlugins.set(true)
                keepUnusedLibraries.set(true)
            }
        }
    }
}
