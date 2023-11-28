package model

interface Dependency {
    val alias: String
    val version: Version
}