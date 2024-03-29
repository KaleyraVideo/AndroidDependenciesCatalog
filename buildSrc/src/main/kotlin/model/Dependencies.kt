package model

import model.*

interface Dependencies: Bom {
    val versions: List<Version>
    val plugins: List<Plugin>
}