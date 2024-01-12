package bom

import bomVersion
import dependencies.KaleyraDependencies
import model.Bom
import model.Library
import model.Version

object KaleyraBom: Bom {

    val kaleyraVideoExtensionsVersion = KaleyraDependencies.versions.first { it.alias == "kaleyraVideoCoreAvVersion" }.version

    override val libraries: MutableList<Library> = mutableListOf()

    init {

        libraries.apply {
            add(Library("kaleyraVideoCommonUi", "com.kaleyra", "video-common-ui", Version("kaleyraVideoCommonUiVersion", bomVersion)))
            add(Library("kaleyraVideoSdk", "com.kaleyra", "video-sdk", Version("kaleyraVideoSdkVersion", bomVersion)))
            add(Library("kaleyraVideoGlassesSdk", "com.kaleyra", "video-glasses-sdk", Version("kaleyraVideoGlassesSdkVersion", bomVersion)))

            add(Library("kaleyraVideoExtensionExternalCamera", "com.kaleyra", "video-extension-external-camera", Version("kaleyraVideoExtensionExternalCamera", kaleyraVideoExtensionsVersion)))
            add(Library("KaleyraVideoExtensionVirtualBackground", "com.kaleyra", "video-extension-virtual-background", Version("KaleyraVideoExtensionVirtualBackground", kaleyraVideoExtensionsVersion)))
        }
    }
}