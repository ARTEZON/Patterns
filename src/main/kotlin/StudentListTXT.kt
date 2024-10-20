import java.io.File
import java.io.FileNotFoundException

class StudentListTXT : StudentList() {
    fun load(filepath: String) {
        val file = File(filepath)
        if (!file.exists()) throw FileNotFoundException("Файл '$filepath' не найден")
        var currentLine = 1
        for (line in file.readLines()) {
            if (line.isNotEmpty()) {
                try {
                    val student = Student(line)
                    students[student.id] = student
                } catch (e: Exception) {
                    throw Exception("Ошибка при чтении файла '$filepath', строка $currentLine: ${e.message}")
                }
            }
            currentLine++
        }
        autoIncrementNextId = (students.keys.maxOrNull() ?: 0) + 1
    }

    fun save(filepath: String) {
        val file = File(filepath)
        file.printWriter().use {
            for (student in students.values) {
                it.println(student.toStringRow())
            }
        }
    }
}
