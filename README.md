## Kaleyra Android Catalogs


This project builds and releases the following catalogs:

- com.kaleyra.kaleyra-libs-version-catalog
- com.kaleyra.video-app-version-catalog
- com.kaleyra.video-sdk-version-catalog

In addition the following boms are built and released as well:

- com.bandyer.bandyer-android-sdk-bom
- com.kaleyra.video-sdk-bom


To update a catalog/bom version update its variable name constant in the buildSrc/src/main/kotlin/Consts.kt file.

### Build

Please use `Embedded JDK - Jetbrains Runtime Version 17.0.6` as Gradle JDK in the project structure >> JDK picker.

### Add a dependency to a catalog

To add a dependency to a catalog, select first the catalog in which will be added by opening one of the following kotlin file:

- buildSrc/src/main/kotlin/dependencies/CommonDependencies.kt (for dependencies used by sample apps or by sdks and internal kaleyra/bandyer libs)

- buildSrc/src/main/kotlin/dependencies/InternalDependencies.kt (for dependencies used only by sdks and internal kaleyra/bandyer libs)

- buildSrc/src/main/kotlin/dependencies/KaleyraDependencies.kt (for kaleyra/bandyer libs only)

- buildSrc/src/main/kotlin/dependencies/SampleAppDependencies.kt (for sample app only dependencies)

Then add its version by instantiating a version declaration as follows in the versions section:

```kotlin 
val androidxStartupRuntimeVersion = Version("androidxStartupRuntimeversion", "1.1.1").apply { add(this) }
```

Then add the dependency into the libraries/plugins section as follows:

```kotlin
// this will add a library dependency linking the previous declared version androidxStartupRuntimeVersion
add(Library("androidxStartupRuntime", "androidx.startup", "startup-runtime", androidxStartupRuntimeVersion))

// this will add a plugin dependency linking previous declared version jetbrainsKotlinVersion
add(Plugin("dokka", "org.jetbrains.dokka", jetbrainsKotlinVersion))

```

### Add a dependency to a bom

To add a dependency to a catalog, select first the bom in which will be added by opening one of the following kotlin file:

- buildSrc/src/main/kotlin/bom/BandyerBom.kt (for the libs used by sdk v3 integration)

- buildSrc/src/main/kotlin/bom/CommonBomDependencies.kt (for common kaleyra/bandyer libs used by collaboration suite and sdk v3.x such as extension usb camera and virtual background libs)

- buildSrc/src/main/kotlin/bom/KaleyraBom.kt (for collaboration suite integrations)

Then add the library dependency as per section catalog, keeping in mind that version this time are declared in the Consts.kt file.

### Deploy

Choose whether to release locally or on remote Kaleyra maven by using the `dryRun` varialble located in buildSrc/src/main/kotlin/Const.kt file.

To release catalogs and boms run the command:

```
./gradlew publishUpload 
```

All the catalogs and boms will be released locally or on kaleyra maven repo.
In addition the maven cache will be invalidated for all the released packages.
