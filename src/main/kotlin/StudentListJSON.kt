import java.io.File
import java.io.FileNotFoundException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class StudentListJSON : StudentList() {
    fun load(filepath: String) {
        val file = File(filepath)
        if (!file.exists()) throw FileNotFoundException("Файл '$filepath' не найден")
        students = Json.decodeFromString<Array<StudentSerializable>>(file.readText()).map {
            Student(it.id, it.surname, it.name, it.patronym, it.phone, it.telegram, it.email, it.git)
        }.associateBy({ it.id }, { it }).toMutableMap()
        autoIncrementNextId = (students.keys.maxOrNull() ?: 0) + 1
    }

    fun save(filepath: String) {
        val file = File(filepath)
        val jsonString = Json.encodeToString(students.values.map { StudentSerializable(it) })
        file.writeText(jsonString)
    }
}
