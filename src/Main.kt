fun main() {
    val students = mutableListOf(
        Student(1, "Эзри", "Артём", "Александрович"),
        Student(2, "Тестов", "Тест", "Тестович", "+79876543210", "@test123", "test@example.com", "https://github.com/test123"),
        Student(3, "Иванов", "Василий", "Петрович", telegram="@vasya228", git="https://github.com/vasyacodes"),
        Student(4, "Who", "Are", "You", git="https://gitlab.com/unknown"),
        Student(5, "I", "Like", "Kotlin", email="kotlinisthebest@meow.com")
    )

    students.forEach { it.show() }
}
