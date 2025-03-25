package dependencies

import model.Dependencies
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
            val kaleyraVideoCoreAvVersion = Version("kaleyraVideoCoreAvVersion", "2.2.2").apply { add(this) }
            val bandyerFirecrasherVersion = Version("bandyerFirecrasherVersion", "1.1.1").apply { add(this) }
            val kaleyraCommunicationCenterVersion = Version("kaleyraCommunicationCenterVersion", "15.0.0").apply { add(this) }
            val kaleyraAudioSessionVersion = Version("kaleyraAudioSessionVersion", "5.0.1").apply { add(this) }

            // kaleyra
            val kaleyraChatSdkVersion = Version("kaleyraChatSdkVersion", "1.0.0-alpha15").apply { add(this) }
            val kaleyraVideoVersion = Version("kaleyraVideoVersion", "1.3.2").apply { add(this) }
            val kaleyraVideoUtilsVersion = Version("kaleyraVideoUtilsVersion", "2.0.1").apply { add(this) }
            val kaleyraVideoNetworkingVersion = Version("kaleyraVideoNetworkingVersion", "4.1.0").apply { add(this) }
            val kaleyraSocketIoVersion = Version("kaleyraSocketIoVersion", "2.0.1").apply { add(this) }
            val kaleyraMaterialColorUtilitiesVersion = Version("kaleyraMaterialColorUtilitiesVersion", "2024.08.01").apply { add(this) }

            libraries.apply {
                println("Setting kaleyra dependency libraries...")

                // kaleyra libraries
                add(Library("kaleyraVideo", "com.kaleyra", "video", kaleyraVideoVersion))
                add(Library("kaleyraVideoExtensionAudio", "com.kaleyra", "video-extension-audio", kaleyraVideoVersion))
                add(Library("kaleyraVideoUtils", "com.kaleyra", "video-utils", kaleyraVideoUtilsVersion))
                add(Library("kaleyraVideoNetworking", "com.kaleyra", "video-networking", kaleyraVideoNetworkingVersion))
                add(Library("kaleyraVideoCoreAv", "com.kaleyra", "video-core-av", kaleyraVideoCoreAvVersion))
                add(Library("kaleyraSocketIo", "com.kaleyra", "socket.io-client", kaleyraSocketIoVersion))
                add(Library("kaleyraFirecrasher", "com.bandyer", "firecrasher", bandyerFirecrasherVersion))
                add(Library("kaleyraCommunicationCenter", "com.bandyer", "communication_center", kaleyraCommunicationCenterVersion))
                add(Library("kaleyraCommunicationCenterExtensionLivePointer", "com.bandyer", "extension_live_pointer", kaleyraCommunicationCenterVersion))
                add(Library("kaleyraCommunicationCenterExtensionFileShare", "com.bandyer", "extension_file_share", kaleyraCommunicationCenterVersion))
                add(Library("kaleyraChatSdk", "com.bandyer", "bandyer-android-chat", kaleyraChatSdkVersion))
                add(Library("kaleyraAudioSession", "com.bandyer", "bandyer-android-audiosession", kaleyraAudioSessionVersion))
                add(Library("kaleyraVideoCoreAvExtensionExternalCamera", "com.kaleyra", "video-extension-external-camera", kaleyraVideoCoreAvVersion))
                add(Library("kaleyraVideoCoreAvExtensionVirtualBackground", "com.kaleyra", "video-extension-virtual-background", kaleyraVideoCoreAvVersion))
                add(Library("kaleyraMaterialColorUtilities", "com.kaleyra", "material-color-utilities", kaleyraMaterialColorUtilitiesVersion))
            }
        }
        println("Version catalog for internal kaleyra dependencies is ready...")
    }
}
