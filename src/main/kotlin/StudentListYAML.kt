import java.io.File
import java.io.FileNotFoundException
import kotlinx.serialization.encodeToString
import kotlinx.serialization.builtins.ListSerializer
import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration

class StudentListYAML : StudentList() {
    fun load(filepath: String) {
        val file = File(filepath)
        if (!file.exists()) throw FileNotFoundException("Файл '$filepath' не найден")
        students = Yaml.default.decodeFromString(ListSerializer(StudentSerializable.serializer()), file.readText()).map {
            Student(it.id, it.surname, it.name, it.patronym, it.phone, it.telegram, it.email, it.git)
        }.associateBy({ it.id }, { it }).toMutableMap()
        autoIncrementNextId = (students.keys.maxOrNull() ?: 0) + 1
    }

    fun save(filepath: String) {
        val file = File(filepath)
        val config = YamlConfiguration(encodeDefaults = false)
        val yamlString = Yaml(configuration = config).encodeToString(students.values.map { StudentSerializable(it) })
        file.writeText(yamlString)
    }
}
