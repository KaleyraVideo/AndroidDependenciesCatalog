package bom

import kaleyraVideoSdkVersion
import dependencies.KaleyraDependencies
import model.Bom
import model.Library
import model.Version

object KaleyraBom: Bom {

    val kaleyraVideoExtensionsVersion = KaleyraDependencies.versions.first { it.alias == "kaleyraVideoCoreAvVersion" }.version

    override val libraries: MutableList<Library> = mutableListOf()

    init {

        libraries.apply {
            add(Library("kaleyraVideoCommonUi", "com.kaleyra", "video-common-ui", Version("kaleyraVideoCommonUiVersion", kaleyraVideoSdkVersion)))
            add(Library("kaleyraVideoSdk", "com.kaleyra", "video-sdk", Version("kaleyraVideoSdkVersion", kaleyraVideoSdkVersion)))
            add(Library("kaleyraVideoGlassesSdk", "com.kaleyra", "video-glasses-sdk", Version("kaleyraVideoGlassesSdkVersion", kaleyraVideoSdkVersion)))

            add(Library("kaleyraVideoExtensionExternalCamera", "com.kaleyra", "video-extension-external-camera", Version("kaleyraVideoExtensionExternalCamera", kaleyraVideoExtensionsVersion)))
            add(Library("KaleyraVideoExtensionVirtualBackground", "com.kaleyra", "video-extension-virtual-background", Version("KaleyraVideoExtensionVirtualBackground", kaleyraVideoExtensionsVersion)))
        }
    }
}