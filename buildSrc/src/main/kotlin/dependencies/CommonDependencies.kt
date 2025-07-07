package dependencies
import model.*

object CommonDependencies: Dependencies {

    override val libraries: MutableList<Library> = mutableListOf()
    override val versions: MutableList<Version> = mutableListOf()
    override val plugins: MutableList<Plugin> = mutableListOf()

    init {

        versions.apply {
            println("Setting common versions...")
            //androidx versions
            val androidxAppcompatVersion = Version("androidxAppcompatVersion", "1.6.1").apply { add(this) }
            val androidxCoreKtxVersion = Version("androidxCoreKtxVersion", "1.10.1").apply { add(this) }
            val androidxMultidexVersion = Version("androidxMultidexVersion", "2.0.1").apply { add(this) }
            val androidxRecyclerViewVersion = Version("androidxRecyclerviewVersion", "1.3.1").apply { add(this) }
            val androidxLifecycleVersion = Version("androidxLifecycleVersion", "2.6.2").apply { add(this) }
            val androidxFragmentVersion = Version("androidxFragmentVersion", "1.5.7").apply { add(this) }
            val androidxActivityVersion = Version("androidxActivityVersion", "1.7.2").apply { add(this) }
            val androidxConstraintLayoutVersion = Version("androidxConstraintLayoutVersion", "2.1.4").apply { add(this) }
            val androidxNavigationKtxVersion = Version("androidxNavigationKtxVersion", "2.6.0").apply { add(this) }
            val androidxStartupRuntimeVersion = Version("androidxStartupRuntimeversion", "1.1.1").apply { add(this) }
            val androidxComposeBomVersion = Version("androidxComposeBomVersion", "2024.09.03").apply { add(this) }

            // jetbrains versions
            val jetbrainsKotlinVersion = Version("jetbrainsKotlinVersion", "1.9.0").apply { add(this) }
            val jetbrainsCoroutinesVersion = Version("jetbrainsCoroutinesVersion", "1.8.0").apply { add(this) }
            val jetbrainsKotlinxSerializationJsonVersion = Version("jetbrainsKotlinxSerializationJsonVersion", "1.6.0").apply { add(this) }

            // google
            val googleMaterialVersion = Version("googleMaterialVersion", "1.7.0").apply { add(this) }
            val googleGsonVersion = Version("googleGsonVersion", "2.9.0").apply { add(this) }
            val googleDesugarVersion = Version("googleDesugarVersion", "1.1.5").apply { add(this) }

            // squareup
            val squareOkhttpVersion = Version("squareupOkhttpVersion", "4.10.0").apply { add(this) }
            val squareupPicassoVersion = Version("squareupPicassoversion", "2.8").apply { add(this) }

            // fastadapter
            val fastadapterVersion = Version("fastadapterVersion", "5.7.0").apply { add(this) }

            // permission dispatcher
            val permissionDispatcherVersion = Version("permissionDispatcherVersion", "4.9.2").apply { add(this) }

            // other
            val zoomyVersion = Version("zoomyVersion", "1.0.0").apply { add(this) }

            // testing
            val junitVersion = Version("junitVersion", "4.13.2").apply { add(this) }
            val junitTestExtVersion = Version("junitTestExtVersion", "1.1.5").apply { add(this) }
            val mockkVersion = Version("mockkVersion", "1.13.1").apply { add(this) }
            val coroutinesTestVersion = Version("coroutinesTestVersion", "1.8.0").apply { add(this) }
            val androidxTestEspressoCoreVersion = Version("androidxTestEspressoCoreVersion", "3.5.1").apply { add(this) }
            val javaassistVersion = Version("javaassistVersion", "3.29.2-GA").apply { add(this) }
            val androidxTestRunnerVersion = Version("androidxTestRunnerVersion", "1.5.2").apply { add(this) }
            val awaitilityKotlinVersion = Version("awaitilityKotlinVersion", "3.1.6").apply { add(this) }

            // common
            val gradleVersion = Version("gradleVersion", "8.6.1").apply { add(this) }

            // plugins
            val kotlinxSerializationVersion = Version("kotlinxSerializationVersion", "1.9.0").apply { add(this) }
            val androidxNavigationSafeArgsVersion = Version("androidxNavigationSafeArgsVersion", "2.5.0").apply { add(this) }


            libraries.apply {
                println("Setting common libraries...")

                // androidx
                add(Library("appcompat", "androidx.appcompat", "appcompat", androidxAppcompatVersion))
                add(Library("androidxCoreKtx", "androidx.core", "core-ktx", androidxCoreKtxVersion))
                add(Library("androidxMultidex", "androidx.multidex", "multidex", androidxMultidexVersion))
                add(Library("androidxRecyclerview", "androidx.recyclerview", "recyclerview", androidxRecyclerViewVersion))
                add(Library("androidxLifecycleRuntime", "androidx.lifecycle", "lifecycle-runtime-ktx", androidxLifecycleVersion))
                add(Library("androidxLifecycleViewModel", "androidx.lifecycle", "lifecycle-viewmodel-ktx", androidxLifecycleVersion))
                add(Library("androidxLifecycleCommonJava8", "androidx.lifecycle", "lifecycle-common-java8", androidxLifecycleVersion))
                add(Library("androidxFragment", "androidx.fragment", "fragment-ktx", androidxFragmentVersion))
                add(Library("androidxActivity", "androidx.activity", "activity-ktx", androidxActivityVersion))
                add(Library("androidxNavigationFragmentKtx", "androidx.navigation", "navigation-fragment-ktx", androidxNavigationKtxVersion))
                add(Library("androidxNavigationUiKtx", "androidx.navigation", "navigation-ui-ktx", androidxNavigationKtxVersion))
                add(Library("androidxConstraintLayout", "androidx.constraintlayout", "constraintlayout", androidxConstraintLayoutVersion))
                add(Library("androidxStartupRuntime", "androidx.startup", "startup-runtime", androidxStartupRuntimeVersion))
                add(Library("androidxComposeBom", "androidx.compose", "compose-bom", androidxComposeBomVersion))

                // jetbrains
                add(Library("coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core", jetbrainsCoroutinesVersion))
                add(Library("coroutinesAndroid", "org.jetbrains.kotlinx", "kotlinx-coroutines-android", jetbrainsCoroutinesVersion))
                add(Library("kotlinSerializationJson", "org.jetbrains.kotlinx", "kotlinx-serialization-json", jetbrainsKotlinxSerializationJsonVersion))
                add(Library("kotlinStdLibJdk8", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8", jetbrainsKotlinVersion))
                add(Library("kotlinStdLibJdk7", "org.jetbrains.kotlin", "kotlin-stdlib-jdk7", jetbrainsKotlinVersion))
                add(Library("kotlinStdLib", "org.jetbrains.kotlin", "kotlin-stdlib", jetbrainsKotlinVersion))
                add(Library("kotlinReflect", "org.jetbrains.kotlin", "kotlin-reflect", jetbrainsKotlinVersion))

                // google
                add(Library("material", "com.google.android.material", "material", googleMaterialVersion))
                add(Library("googleGson", "com.google.code.gson", "gson", googleGsonVersion))
                add(Library("desugar", "com.android.tools", "desugar_jdk_libs", googleDesugarVersion))

                // squareup
                add(Library("okhttp", "com.squareup.okhttp3", "okhttp", squareOkhttpVersion))
                add(Library("okhttpLoggingInterceptor", "com.squareup.okhttp3", "logging-interceptor", squareOkhttpVersion))
                add(Library("squareupPicasso", "com.squareup.picasso", "picasso", squareupPicassoVersion))

                // permission dispatcher
                add(Library("permissionDispatcher", "com.github.permissions-dispatcher", "permissionsdispatcher", permissionDispatcherVersion))
                add(Library("permissionDispatcherProcessor", "com.github.permissions-dispatcher", "permissionsdispatcher-processor", permissionDispatcherVersion))

                // fastadapter
                add(Library("fastadapter", "com.mikepenz", "fastadapter", fastadapterVersion))
                add(Library("fastadapterExtensionsDiff", "com.mikepenz", "fastadapter-extensions-diff", fastadapterVersion))

                // other
                add(Library("zoomy", "io.github.imablanco", "zoomy", zoomyVersion))

                // testing-libraries
                add(Library("junit", "junit", "junit", junitVersion))
                add(Library("mockk", "io.mockk", "mockk", mockkVersion))
                add(Library("mockkAndroid", "io.mockk", "mockk-android", mockkVersion))
                add(Library("coroutinesTest", "org.jetbrains.kotlinx", "kotlinx-coroutines-test", coroutinesTestVersion))
                add(Library("junitTestExt", "androidx.test.ext", "junit", junitTestExtVersion))
                add(Library("androidxTestRunner", "androidx.test", "runner", androidxTestRunnerVersion))
                add(Library("androidxTestEspressoCore", "androidx.test.espresso", "espresso-core", androidxTestEspressoCoreVersion))
                add(Library("javaAssist", "org.javassist", "javassist", javaassistVersion))
                add(Library("awaitilityKotlin", "org.awaitility", "awaitility", awaitilityKotlinVersion))
            }

            plugins.apply {
                println("Setting common plugins...")

                add(Plugin("kotlinxSerialization", "org.jetbrains.kotlin.plugin.serialization", kotlinxSerializationVersion))
                add(Plugin("androidxNavigationSafeArgs", "androidx.navigation:navigation-safe-args-gradle-plugin", androidxNavigationSafeArgsVersion))
            }
        }
    }
}