fun lab1() {
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

    students.forEach { println("У данного студента гит ${if (it.checkGit()) "при" else "от"}сутствует!") }
    students.forEach { println("У данного студента контакты ${if (it.checkContact()) "при" else "от"}сутствуют!") }

    students[1].setContacts(mapOf("telegram" to null, "email" to "test123@example.com"))
    students[1].show()
}

fun lab2() {
    val students = mutableListOf(
        Student("1|Эзри|Артём|Александрович||||"),
        Student("2|Тестов|Тест|Тестович|+79876543210|@test123|test@example.com|https://github.com/test123"),
        Student("3|Иванов|Василий|Петрович||@vasya228||https://github.com/vasyacodes"),
        Student("4|Who|Are|You||||https://gitlab.com/unknown"),
        Student("5|I|Like|Kotlin|||kotlinisthebest@meow.com|")
    )

    students.forEach { it.show() }
}

fun main() {
    lab2()
}
