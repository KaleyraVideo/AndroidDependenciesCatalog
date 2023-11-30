package dependencies

import model.Dependencies
import model.Library
import model.Plugin
import model.Version

object SampleAppDependencies : Dependencies {

    override val libraries: MutableList<Library> = mutableListOf()
    override val versions: MutableList<Version> = mutableListOf()
    override val plugins: MutableList<Plugin> = mutableListOf()


    init {
        versions.apply {

            println("Setting sample app versions...")

            addAll(CommonDependencies.versions)

            // androidversions
            val androidxGridLayoutVersion = Version("androidxGridLayoutVersion", "1.1.0-beta01").apply { add(this) }
            val androidxRecyclerViewSelectionVersion = Version("androidxRecyclerViewSelectionVersion", "1.1.0").apply { add(this) }
            val androidxCoordinatorLayoutVersion = Version("androidxCoordinatorLayoutVersion", "1.2.0").apply { add(this) }
            val androidxSwipeRefreshLayoutVersion = Version("androidxSwipeRefreshLayoutVersion", "1.2.0-alpha01").apply { add(this) }
            val androidxBiometricKtxVersion = Version("androidxBiometrixKtxVersion", "1.2.0-alpha05").apply { add(this) }
            val androidxWorkRuntimeVersion = Version("androidxWorkRuntimeVersion", "2.8.1").apply { add(this) }

            // firebase
            val firebaseCrashlyticsNdkVersion = Version("firebaseCrashLyticsNdkversion", "18.4.1").apply { add(this) }
            val firebaseMessagingVersion = Version("firebaseMessagingVersion", "23.2.1").apply { add(this) }
            val firebaseIidVersion = Version("firebaseIidVersion", "21.1.0").apply { add(this) }

            // squareup
            val squareupRetrofitVersion = Version("squareupRetrofitVersion", "2.9.0").apply { add(this) }
            val squareupLeakCanaryVersion = Version("squareupLeakCanaryVersion", "2.8.1").apply { add(this) }

            // ktor
            val ktorVersion = Version("ktorVersion", "2.3.4").apply { add(this) }

            // facebook
            val facebookFlipperVersion = Version("facebookFlipperVersion", "0.137.0").apply { add(this) }
            val facebookSoloaderVersion = Version("facebookSoloaderVersion", "0.10.5").apply { add(this) }
            val facebookStethoVersion = Version("facebookStethoVersion", "1.6.0").apply { add(this) }

            // pushy
            val pushyVersion = Version("pushyVersion", "1.0.96").apply { add(this) }

            // huawei
            val huaweiPushVersion = Version("huaweiPushVersion", "6.9.0.300").apply { add(this) }

            // bandyer
            val bandyerFlipperSocketIoVersion = Version("bandyerFlipperSocketIoPluginVersion", "1.1.0").apply { add(this) }

            // other
            val stickySwitchVersion = Version("stickySwitchVersion", "0.0.16").apply { add(this) }
            val jsonViewerVersion = Version("jsonViewerVersion", "V1.0.6").apply { add(this) }
            val imageZoomVersion = Version("imageZoomVersion", "2.0.0").apply { add(this) }
            val recyclerAdapterVersion = Version("recyclerAdapterVersion", "4.1.1").apply { add(this) }
            val cameraViewVersion = Version("cameraViewVersion", "2.7.2").apply { add(this) }
            val zxingVersion = Version("zxingVersion", "3.5.2").apply { add(this) }
            val materialExpansionPanel = Version("materialExpansionPanel", "2.1.7").apply { add(this) }
            val processPhoenixVersion = Version("processPhoenixVersion", "2.1.2").apply { add(this) }

            // common
            val sampleAppMinSdkVersion = Version("sampleAppMinSdkVersion", "21").apply { add(this) }
            val sampleAppSdkVersion = Version("sampleAppSdkVersion", "33").apply { add(this) }
            val sampleAppToolsVersion = Version("sampleAppToolsVersion", "33.0.1").apply { add(this) }

            // plugins
            val gmsGoogleVersion = Version("gmsGoogleVersion", "4.3.15").apply { add(this) }
            val crashlyticsPluginVersion = Version("crashlyticsPluginVersion", "2.9.9").apply { add(this) }
            val firebaseAppDistriutionVersion = Version("firebaseAppDistributionVersion", "3.0.3").apply { add(this) }
            val huaweiAgConnectVersion = Version("huaweiAgConnectVersion", "1.6.5.300").apply { add(this) }
            val huaweiPublishVersion = Version("huaweiPublishVersion", "1.4.0").apply { add(this) }
            val tripletPlayPublishVersion = Version("tripletPlayPublishVersion", "3.8.3").apply { add(this) }

            libraries.apply {
                println("Setting sample app libraries...")

                addAll(CommonDependencies.libraries)

                // androidx
                add(Library("androidxRecyclerviewSelection", "androidx.recyclerview", "recyclerview-selection", androidxRecyclerViewSelectionVersion))
                add(Library("androidxGridLayout", "androidx.gridlayout", "gridlayout", androidxGridLayoutVersion))
                add(Library("androidxCoordinatorLayout", "androidx.coordinatorlayout", "coordinatorlayout", androidxCoordinatorLayoutVersion))
                add(Library("androidxSwipeRefreshLayout", "androidx.swiperefreshlayout", "swiperefreshlayout", androidxSwipeRefreshLayoutVersion))
                add(Library("androidxWorkRuntime", "androidx.work", "work-runtime", androidxWorkRuntimeVersion))
                add(Library("androidxWorkRuntimeKtx", "androidx.work", "work-runtime-ktx", androidxWorkRuntimeVersion))
                add(Library("androidxBiometricKtx", "androidx.biometric", "biometric-ktx", androidxBiometricKtxVersion))
                add(Library("androidxBiometric", "androidx.biometric", "biometric", androidxBiometricKtxVersion))

                // firebase
                add(Library("firebaseCrashlyticsNdk", "com.google.firebase", "firebase-crashlytics-ndk", firebaseCrashlyticsNdkVersion))
                add(Library("firebaseMessaging", "com.google.firebase", "firebase-messaging", firebaseMessagingVersion))
                add(Library("firebaseIid", "com.google.firebase", "firebase-iid", firebaseIidVersion))

                // squareup
                add(Library("squareupRetrofit", "com.squareup.retrofit2", "retrofit", squareupRetrofitVersion))
                add(Library("squareupRetrofitConverterJson", "com.squareup.retrofit2", "converter-gson", squareupRetrofitVersion))
                add(Library("squareupLeakCanary", "com.squareup.leakcanary", "leakcanary-android", squareupLeakCanaryVersion))

                // ktor
                add(Library("ktorClientCore", "io.ktor", "ktor-client-core", ktorVersion))
                add(Library("ktorClientCio", "io.ktor", "ktor-client-cio", ktorVersion))
                add(Library("ktorClientContentNegotiation", "io.ktor", "ktor-client-content-negotiation", ktorVersion))
                add(Library("ktorSerializationKotlinxJson", "io.ktor", "ktor-serialization-kotlinx-json", ktorVersion))
                add(Library("ktorClientOkhttp", "io.ktor", "ktor-client-okhttp", ktorVersion))

                // facebook
                add(Library("facebookFlipper", "com.facebook.flipper", "flipper", facebookFlipperVersion))
                add(Library("facebookFlipperNoop", "com.facebook.flipper", "flipper-noop", facebookFlipperVersion))
                add(Library("facebookFlipperLeakCanary", "com.facebook.flipper", "flipper-leakcanary2-plugin", facebookFlipperVersion))
                add(Library("facebookFlipperNetwork", "com.facebook.flipper", "flipper-network-plugin", facebookFlipperVersion))
                add(Library("facebookSoloader", "com.facebook.soloader", "soloader", facebookSoloaderVersion))
                add(Library("facebookStetho", "com.facebook.stetho", "stetho-okhttp3", facebookStethoVersion))

                // pushy
                add(Library("pushy", "me.pushy", "sdk", pushyVersion))

                // huawei
                add(Library("huaweiHmsPush", "com.huawei.hms", "push", huaweiPushVersion))

                // other
                add(Library("stickySwitch", "com.github.GwonHyeok", "StickySwitch", stickySwitchVersion))
                add(Library("jsonViewer", "com.github.smuyyh", "JsonViewer", jsonViewerVersion))
                add(Library("imageZoom", "com.github.okaybroda", "ImageZoom", imageZoomVersion))
                add(Library("gotevRecyclerAdapter", "net.gotev", "recycleradapter", recyclerAdapterVersion))
                add(Library("gotevRecyclerAdapterExtensions", "net.gotev", "recycleradapter-extensions", recyclerAdapterVersion))
                add(Library("cameraView", "com.otaliastudios", "cameraview", cameraViewVersion))
                add(Library("zxing", "com.google.zxing", "core", zxingVersion))
                add(Library("materialExpansionPanel", "com.robertlevonyan.view", "MaterialExpansionPanel", materialExpansionPanel))
                add(Library("processPhoenix", "com.jakewharton", "process-phoenix", processPhoenixVersion))

                // kaleyra libraries
                add(Library("kaleyraFlipperSocketIo", "com.bandyer.flipper", "flipper-socket-io-plugin", bandyerFlipperSocketIoVersion))
            }

            plugins.apply {
                println("Setting sample app plugins...")

                addAll(CommonDependencies.plugins)

                add(Plugin("gmsGoogleServices", "com.google.gms:google-services", gmsGoogleVersion))
                add(Plugin("firebaseCrashlytics", "com.google.firebase:firebase-crashlytics-gradle", crashlyticsPluginVersion))
                add(Plugin("firebaseAppDistribution", "com.google.firebase:firebase-appdistribution-gradle", firebaseAppDistriutionVersion))
                add(Plugin("huaweiAgconnect", "com.huawei.agconnect:agcp", huaweiAgConnectVersion))
                add(Plugin("huaweiPublish", "ru.cian:huawei-publish-gradle-plugin", huaweiPublishVersion))
                add(Plugin("tripletPlay", "com.github.triplet.gradle:play-publisher", tripletPlayPublishVersion))
            }

            println("Version catalog for sample app is ready...")
        }
    }
}