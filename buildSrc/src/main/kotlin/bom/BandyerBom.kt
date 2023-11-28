package bom

import model.Bom
import model.Library
import model.Version
import bomV3ArtifactVersion

object BandyerBom : Bom {

    override val libraries: MutableList<Library> = mutableListOf()

    init {
        libraries.apply {
            addAll(CommonBomDependencies.libraries)

            add(Library("bandyerAndroidSdk", "com.bandyer", "bandyer-android-sdk", Version("kaleyraVideoSdk", bomV3ArtifactVersion)))
        }
    }
}
