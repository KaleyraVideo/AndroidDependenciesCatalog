package model

import org.gradle.api.component.SoftwareComponent
import org.gradle.api.publish.maven.MavenPublication

class VersionCatalogPublicationConfig(
    override val artifactId: String,
    override val artifactVersion: String,
    val catalogComponent: SoftwareComponent,
    override val mavenPublication: MavenPublication,
    override val libraryGroup: String,
    override val libraries: List<Library>
): PublicationConfig

class BomPublicationConfig(
    override val artifactId: String,
    override val artifactVersion: String,
    override val mavenPublication: MavenPublication,
    override val libraryGroup: String,
    override val libraries: List<Library>
): PublicationConfig

interface PublicationConfig {
    val artifactId: String
    val artifactVersion: String
    val mavenPublication: MavenPublication
    val libraryGroup: String
    val libraries: List<Library>
}
