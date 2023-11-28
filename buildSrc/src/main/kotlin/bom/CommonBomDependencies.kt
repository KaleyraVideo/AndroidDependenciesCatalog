package bom

import dependencies.KaleyraDependencies
import model.Bom
import model.Library
import model.Version

object CommonBomDependencies: Bom {

    val coreAvExtensionsVersion = KaleyraDependencies.versions.first { it.alias == "bandyerCoreAvVersion" }.version

    override val libraries: MutableList<Library> = mutableListOf()

    init {
        libraries.apply {
            add(Library("extensionUsbCamera", "com.bandyer", "extension_usb_camera", Version("extensionUsbCamera", coreAvExtensionsVersion)))
            add(Library("extensionVirtualBackground", "com.bandyer", "extension_virtual_background", Version("extensionVirtualBackground", coreAvExtensionsVersion)))
        }
    }
}