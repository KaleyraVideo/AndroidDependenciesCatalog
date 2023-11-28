package model

data class Plugin(override val alias: String, val id: String, override val version: Version) : Dependency
