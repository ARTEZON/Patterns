fun main() {
    val students = mutableListOf(
        Student(mapOf(
            "id" to 1,
            "surname" to "Эзри",
            "name" to "Артём",
            "patronym" to "Александрович"
        )),
        Student(mapOf(
            "id" to 2,
            "surname" to "Тестов",
            "name" to "Тест",
            "patronym" to "Тестович",
            "phone" to "+79876543210",
            "telegram" to "@test123",
            "email" to "test@example.com",
            "git" to "https://github.com/test123"
        )),
        Student(mapOf(
            "id" to 3,
            "surname" to "Иванов",
            "name" to "Василий",
            "patronym" to "Петрович",
            "telegram" to "@vasya228",
            "git" to "https://github.com/vasyacodes"
        )),
        Student(mapOf(
            "id" to 4,
            "surname" to "Who",
            "name" to "Are",
            "patronym" to "You",
            "git" to "https://gitlab.com/unknown"
        )),
        Student(mapOf(
            "id" to 5,
            "surname" to "I",
            "name" to "Like",
            "patronym" to "Kotlin",
            "email" to "kotlinisthebest@meow.com"
        )),
        //Student(mapOf(
        //    "id" to 6,
        //    "surname" to "Чел",
        //    "name" to "Снеправильным",
        //    "patronym" to "Номером",
        //    "phone" to "iPhone 15 Pro Max"
        //)),
        //Student(mapOf(
        //    "id" to 6,
        //    "surname" to "Фамилия",
        //    "name" to "Имя",
        //    "patronym" to ""
        //)),
        //Student(mapOf(
        //    "id" to 6,
        //    "surname" to "123",
        //    "name" to "Имя",
        //    "patronym" to ""
        //)),
        //Student(mapOf(
        //    "id" to 6,
        //    "surname" to "Фамилия",
        //    "name" to "Имя ",
        //    "patronym" to ""
        //)),
        //Student(mapOf(
        //    "id" to 6,
        //    "surname" to "Фамилия",
        //    "name" to "Имя",
        //    "patronym" to "Отчество",
        //    "telegram" to "telega",
        //    "email" to "example.com",
        //    "git" to "https://github.com/1/2/3"
        //)),
    )

    students.forEach { it.show() }
}
