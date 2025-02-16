package dependencies

import model.*

object InternalDependencies : Dependencies {

    override val libraries: MutableList<Library> = mutableListOf()
    override val versions: MutableList<Version> = mutableListOf()
    override val plugins: MutableList<Plugin> = mutableListOf()

    init {
        println("Setting internal libraries...")

        versions.apply {
            println("Setting internal versions...")

            addAll(CommonDependencies.versions)

            // androidx versions
            val androidXActivityComposeVersion = Version("androidXActivityComposeVersion", "1.5.1").apply { add(this) }
            val androidxComposeConstraintLayoutVersion = Version("androidxComposeConstraintLayoutVersion", "1.0.1").apply { add(this) }
            val androidxDatabindingCommonVersion = Version("androidxDatabindingCommonVersion", "8.1.1").apply { add(this) }
            val androidxVectorDrawableVersion = Version("androidxVectorDrawableVersion", "1.1.0").apply { add(this) }
            val androidxRoomVersion = Version("androidxRoomVersion", "2.5.2").apply { add(this) }
            val androidxLifecycleVersion = Version("androidxLifecycleVersion", "2.6.2").apply { add(this) }
            val androidxArchCoreTestingVersion = Version("androidxArchCoreTestingVersion", "2.2.0").apply { add(this) }

            // jetbrains versions
            val jetbrainsDokkaVersion = Version("jetbrainsDokkaVersion", "1.9.0").apply { add(this) }
            val jetbrainsKotlinxDateTimeVersion = Version("jetbrainsKotlinxDateTimeVersion", "0.4.1").apply { add(this) }

            // google
            val googleSegmentationSelfieVersion = Version("googleSegmentationSelfieVersion", "16.0.0-beta6").apply { add(this) }
            val googleFlexboxVersion = Version("googleFlexboxVersion", "3.0.0").apply { add(this) }
            val googleAccompanistVersion = Version("googleAccompanistVersion", "0.27.0").apply { add(this) }

            // json
            val jsonVersion = Version("jsonVersion", "20230618").apply { add(this) }

            // apache
            val apacheCommonsIoVersion = Version("apacheCommonsIoVersion", "2.13.0").apply { add(this) }

            // other
            val detektFormattingVersion = Version("detektFormattingVersion", "1.23.1").apply { add(this) }
            val silicompressorVersion = Version("silicompressorVersion", "2.2.4").apply { add(this) }
            val coilComposeVersion = Version("coilComposeVersion", "2.3.0").apply { add(this) }

            // testing
            val testFlowObserverVersion = Version("testFlowObserverVersion", "1.6.2").apply { add(this) }
            val androidxTestCoreVersion = Version("androidxTestCoreVersion", "1.5.0").apply { add(this) }
            val okhttpMockWebServerVersion = Version("okhttpMockWebServerVersion", "4.9.3").apply { add(this) }
            val robolectricVersion = Version("robolectricVersion", "4.13").apply { add(this) }
            val androidxTestRulesVersion = Version("androidxTestRulesVersion", "1.5.0").apply { add(this) }
            val androidxTestEspressoIntentsVersion = Version("androidxTestEspressoIntentsVersion", "3.4.0").apply { add(this) }
            val androidxTestUiAutomatorVersion = Version("androidxTestUiAutomatorVersion", "2.2.0").apply { add(this) }
            val androidxBenchmarkMacroJunit4Version = Version("androidxBenchmarkMacroJunit4Version", "1.1.0").apply { add(this) }

            // common
            val sdkVersion = Version("sdkVersion", "34").apply { add(this) }
            val minSdkVersion = Version("minSdkVersion", "21").apply { add(this) }
            val toolsVersion = Version("toolsVersion", "34.0.0").apply { add(this) }
            val proguardVersion = Version("proguardVersion", "7.3.1").apply { add(this) }
            val ktlintVersion = Version("ktlintVersion", "0.50.0").apply { add(this) }
            val kotlinCompilerExtensionVersion = Version("kotlinCompilerExtensionVersion", "1.5.2").apply { add(this) }

            // plugins
            val licenseReportVersion = Version("licenseReportVersion", "2.5").apply { add(this) }
            val spotlessVersion = Version("spotlessVersion", "6.21.0").apply { add(this) }
            val detektVersion = Version("detektVersion", "1.23.1").apply { add(this) }
            val jacocoVersion = Version("jacocoVersion", "0.2.1").apply { add(this) }
            val sonarqubeVersion = Version("sonarqubeVersion", "3.5.0.2730").apply { add(this) }
            val gradleDownloadTaskVersion = Version("gradleDownloadTaskVersion", "5.5.0").apply { add(this) }
            val googleDevToolsKspVersion = Version("googleDevToolsKspVersion", "1.9.0-1.0.13").apply { add(this) }

            libraries.apply {
                println("Setting internal libraries...")

                addAll(CommonDependencies.libraries)

                // new-compose
                add(Library("androidXActivityCompose", "androidx.activity", "activity-compose", androidXActivityComposeVersion))
                add(Library("androidxLifecycleProcess", "androidx.lifecycle", "lifecycle-process", androidxLifecycleVersion))
                add(Library("androidxTestEspressoIntents", "androidx.test.espresso", "espresso-intents", androidxTestEspressoIntentsVersion))
                add(Library("androidxComposeConstraintLayout", "androidx.constraintlayout", "constraintlayout-compose", androidxComposeConstraintLayoutVersion))

                // androidx
                add(Library("androidxLifecycleExtensions", "androidx.lifecycle", "lifecycle-livedata-ktx", androidxLifecycleVersion))
                add(Library("androidxDataBindingCommon", "androidx.databinding", "databinding-common", androidxDatabindingCommonVersion))
                add(Library("androidxVectorDrawable", "androidx.vectordrawable", "vectordrawable", androidxVectorDrawableVersion))
                add(Library("androidxVectorDrawableAnimated", "androidx.vectordrawable", "vectordrawable-animated", androidxVectorDrawableVersion))
                add(Library("androidxRoomRuntime", "androidx.room", "room-runtime", androidxRoomVersion))
                add(Library("androidxRoomCompiler", "androidx.room", "room-compiler", androidxRoomVersion))
                add(Library("androidxRoomKtx", "androidx.room", "room-ktx", androidxRoomVersion))

                // jetbrains
                add(Library("dokka", "org.jetbrains.dokka", "android-documentation-plugin", jetbrainsDokkaVersion))
                add(Library("dokkaKotlinAsJava", "org.jetbrains.dokka", "kotlin-as-java-plugin", jetbrainsDokkaVersion))
                add(Library("kotlinxDateTime", "org.jetbrains.kotlinx", "kotlinx-datetime", jetbrainsKotlinxDateTimeVersion))

                // google
                add(Library("mlKitSegmentationSelfie", "com.google.mlkit", "segmentation-selfie", googleSegmentationSelfieVersion))
                add(Library("flexbox", "com.google.android.flexbox", "flexbox", googleFlexboxVersion))
                add(Library("googleAccompanistSystemUiController", "com.google.accompanist", "accompanist-systemuicontroller", googleAccompanistVersion))
                add(Library("googleAccompanistPermission", "com.google.accompanist", "accompanist-permissions", googleAccompanistVersion))

                // apache
                add(Library("apacheCommonsIo", "commons-io", "commons-io", apacheCommonsIoVersion))

                // json
                add(Library("json", "org.json", "json", jsonVersion))

                // other
                add(Library("detektFormatting", "io.gitlab.arturbosch.detekt", "detekt-formatting", detektFormattingVersion))
                add(Library("silicompressor", "com.iceteck.silicompressorr", "silicompressor", silicompressorVersion))
                add(Library("coilCompose", "io.coil-kt", "coil-compose", coilComposeVersion))

                // testing-libraries
                add(Library("flowTestObserver", "com.github.ologe", "flow-test-observer", testFlowObserverVersion))
                add(Library("androidxTestCore", "androidx.test", "core", androidxTestCoreVersion))
                add(Library("androidxTestCoreKtx", "androidx.test", "core-ktx", androidxTestCoreVersion))
                add(Library("androidxArchCoreTesting", "androidx.arch.core", "core-testing", androidxArchCoreTestingVersion))
                add(Library("okhttpMockWebServer", "com.squareup.okhttp3", "mockwebserver", okhttpMockWebServerVersion))
                add(Library("robolectric", "org.robolectric", "robolectric", robolectricVersion))
                add(Library("androidxTestRules", "androidx.test", "rules", androidxTestRulesVersion))
                add(Library("androidxTestUiAutomator", "androidx.test.uiautomator", "uiautomator", androidxTestUiAutomatorVersion))
                add(Library("androidxBenchmarkMacroJunit4", "androidx.benchmark", "benchmark-macro-junit4", androidxBenchmarkMacroJunit4Version))
            }


            plugins.apply {
                println("Setting internal plugins...")

                addAll(CommonDependencies.plugins)

                add(Plugin("licenseReport", "com.github.jk1.dependency-license-report", licenseReportVersion))
                add(Plugin("dokka", "org.jetbrains.dokka", jetbrainsDokkaVersion))
                add(Plugin("spotless", "com.diffplug.spotless", spotlessVersion))
                add(Plugin("detekt", "io.gitlab.arturbosch.detekt", detektVersion))
                add(Plugin("jacoco", "com.mxalbert.gradle:jacoco-android", jacocoVersion))
                add(Plugin("sonarqube", "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin", sonarqubeVersion))
                add(Plugin("gradleDownloadTask", "de.undercouch.download", gradleDownloadTaskVersion))
                add(Plugin("googleDevToolsKsp", "com.google.devtools.ksp", googleDevToolsKspVersion))
            }

            println("Version catalog for internal dependencies is ready...")
        }
    }
}