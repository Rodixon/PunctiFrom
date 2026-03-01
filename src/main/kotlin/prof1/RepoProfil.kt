package prof1

import kotlinx.serialization.json.Json
import java.io.File

object RepoProfil {
    private val file1pfjs = File("profiles.json")

    private  val _profiles = loadProfiles(file1pfjs)
        val profiles
            get() = _profiles.toList()





    fun loadProfiles(file: File): List<Person> {
        return Json.decodeFromString( file.readText().trim())
    }
}