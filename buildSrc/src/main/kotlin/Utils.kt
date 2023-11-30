import model.PublicationConfig
import model.VersionCatalogPublicationConfig
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.credentials.AwsCredentials
import org.gradle.kotlin.dsl.credentials
import java.io.File
import java.io.FileInputStream
import java.net.URI

fun getLocalProperty(key: String, file: String = "local.properties"): String {
    val properties = java.util.Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        java.io.InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    } else error("File from not found")
    return properties.getProperty(key)!!
}

fun configureMavenRepository(mavenrepositoryArtifact: MavenArtifactRepository) {
    mavenrepositoryArtifact.url = URI.create("s3://maven-bandyer/$publishPath/")
    mavenrepositoryArtifact.credentials(AwsCredentials::class) {
        accessKey = mavenAccessKey
        secretKey = mavenSecretKey
    }
}

fun configureMavenPublication(publicationConfig: PublicationConfig) {
    val publication = publicationConfig.mavenPublication
    publication.groupId = publicationConfig.libraryGroup
    publication.version = publicationConfig.artifactVersion
    publication.artifactId = publicationConfig.artifactId
    publication.pom {
        packaging = "pom"
        name.set("Kaleyra Android Catalog")
        description.set("Catalog for commonly used android dependencies.")
        url.set("https://www.kaleyra.com")
        (publicationConfig as? VersionCatalogPublicationConfig)?.catalogComponent?.let { publication.from(it) }

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("Kaleyra Spa")
                name.set("")
            }
        }
//                scm {
//                    // version control meta data
//                    connection.set("scm:git@github.com:**user**/**lib**.git")
//                    developerConnection.set("scm:git@github.com:**user**/**lib**.git")
//                    url.set("http://github.com/**user**/**lib**")
//                }

        withXml {
            val root = asNode()
            val dependencyManagement = root.appendNode("dependencyManagement")
            val dependencies = dependencyManagement.appendNode("dependencies")

            publicationConfig.libraries.forEach { library ->
                val dependency = dependencies.appendNode("dependency")
                dependency.appendNode("groupId", library.groupId)
                dependency.appendNode("artifactId", library.artifactId)
                dependency.appendNode("version", library.version.version)
            }
        }
    }
}
