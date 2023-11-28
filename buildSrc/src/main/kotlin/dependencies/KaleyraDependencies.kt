package dependencies

import model.Library
import model.Plugin
import model.Version

object KaleyraDependencies : Dependencies {

    override val libraries: MutableList<Library> = mutableListOf()
    override val versions: MutableList<Version> = mutableListOf()
    override val plugins: MutableList<Plugin> = mutableListOf()

    init {
        println("Setting kaleyra dependency catalog...")

        versions.apply {

            println("Setting kaleyra dependency versions...")

            // bandyer
            val bandyerCoreAvVersion = Version("bandyerCoreAvVersion", "13.0.3").apply { add(this) }
            val bandyerFirecrasherVersion = Version("bandyerFirecrasherVersion", "1.1.1").apply { add(this) }
            val bandyerCommunicationCenterVersion = Version("bandyerCommunicationCenterVersion", "11.1.0").apply { add(this) }
            val bandyerChatSdkVersion = Version("bandyerChatSdkVersion", "0.0.64").apply { add(this) }
            val bandyerAudioSessionVersion = Version("bandyerAudioSessionVersion", "3.1.3").apply { add(this) }

            // kaleyra
            val kaleyraChatSdkVersion = Version("kaleyraChatSdkVersion", "1.0.0-alpha9").apply { add(this) }
            val kaleyraCollaborationSuiteVersion = Version("kaleyraCollaborationSuiteVersion", "1.0.0-alpha10").apply { add(this) }
            val kaleyraCollaborationSuiteUtilsVersion = Version("kaleyraCollaborationSuiteUtilsVersion", "3.0.6").apply { add(this) }
            val kaleyraCollaborationSuiteNetworkingVersion = Version("kaleyraCollaborationSuiteNetworkingVersion", "5.0.3").apply { add(this) }
            val kaleyraVideoNetworkingVersion = Version("kaleyraVideoNetworkingVersion", "1.0.0").apply { add(this) }
            val kaleyraSocketIoVersion = Version("kaleyraSocketIoVersion", "2.0.1").apply { add(this) }
            val kaleyraVideoUiVersion = Version("kaleyraVideoUiVersion", "4.0.2").apply { add(this) }

            libraries.apply {
                println("Setting kaleyra dependency libraries...")

                // kaleyra libraries
                add(Library("kaleyraCollaborationSuite", "com.kaleyra", "collaboration-suite", kaleyraCollaborationSuiteVersion))
                add(Library("kaleyraCollaborationSuiteUtils", "com.kaleyra", "collaboration-suite-utils", kaleyraCollaborationSuiteUtilsVersion))
                add(Library("kaleyraCollaborationSuiteExtensionAudio", "com.kaleyra", "collaboration-suite-extension-audio", kaleyraCollaborationSuiteVersion))
                add(Library("kaleyraCollaborationSuiteNetworking", "com.kaleyra", "collaboration-suite-networking", kaleyraCollaborationSuiteNetworkingVersion))
                add(Library("kaleyraVideoNetworking", "com.kaleyra", "video-networking", kaleyraVideoNetworkingVersion))
                add(Library("kaleyraCoreAv", "com.bandyer", "bandyer-android-coreav", bandyerCoreAvVersion))
                add(Library("kaleyraSocketIo", "com.kaleyra", "socket.io-client", kaleyraSocketIoVersion))
                add(Library("kaleyraFirecrasher", "com.bandyer", "firecrasher", bandyerFirecrasherVersion))
                add(Library("kaleyraCommunicationCenter", "com.bandyer", "communication_center", bandyerCommunicationCenterVersion))
                add(Library("kaleyraCommunicationCenterExtensionLivePointer", "com.bandyer", "extension_live_pointer", bandyerCommunicationCenterVersion))
                add(Library("kaleyraCommunicationCenterExtensionFileShare", "com.bandyer", "extension_file_share", bandyerCommunicationCenterVersion))
                add(Library("bandyerChatSdk", "com.bandyer", "bandyer-android-chat", bandyerChatSdkVersion))
                add(Library("kaleyraChatSdk", "com.bandyer", "bandyer-android-chat", kaleyraChatSdkVersion))
                add(Library("kaleyraAudioSession", "com.bandyer", "bandyer-android-audiosession", bandyerAudioSessionVersion))
                add(Library("kaleyraCollaborationSuiteCoreUI", "com.kaleyra", "collaboration-suite-core-ui", kaleyraVideoUiVersion))
                add(Library("kaleyraCollaborationSuitePhoneUI", "com.kaleyra", "collaboration-suite-phone-ui", kaleyraVideoUiVersion))
                add(Library("kaleyraCollaborationSuiteGlassUI", "com.kaleyra", "collaboration-suite-glass-ui", kaleyraVideoUiVersion))
                add(Library("kaleyraCoreAvExtensionUsbCamera", "com.bandyer", "extension_usb_camera", bandyerCoreAvVersion))
                add(Library("kaleyraCoreAvExtensionVirtualBackground", "com.bandyer", "extension_virtual_background", bandyerCoreAvVersion))
            }
        }
        println("Version catalog for internal kaleyra dependencies is ready...")
    }
}
