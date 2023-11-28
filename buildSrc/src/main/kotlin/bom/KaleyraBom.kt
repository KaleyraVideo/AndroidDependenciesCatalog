package bom

import model.Bom
import model.Library
import model.Version

object KaleyraBom: Bom {
    override val libraries: MutableList<Library> = mutableListOf()

    const val kaleyraVideoSdk = "1.0.0-alpha9"

    init {
        libraries.apply {
            addAll(CommonBomDependencies.libraries)

            add(Library("kaleyraVideoSdk", "com.kaleyra", "collaboration-suite", Version("kaleyraVideoSdk", kaleyraVideoSdk)))
        }
    }
}