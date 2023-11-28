package model

data class Library(override val alias: String, val groupId: String, val artifactId: String, override val version: Version) : Dependency
