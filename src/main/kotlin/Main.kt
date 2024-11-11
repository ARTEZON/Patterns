//fun lab1() {
//    val students = mutableListOf(
//        Student(mapOf(
//            "id" to 1,
//            "surname" to "Эзри",
//            "name" to "Артём",
//            "patronym" to "Александрович"
//        )),
//        Student(mapOf(
//            "id" to 2,
//            "surname" to "Тестов",
//            "name" to "Тест",
//            "patronym" to "Тестович",
//            "phone" to "+79876543210",
//            "telegram" to "@test123",
//            "email" to "test@example.com",
//            "git" to "https://github.com/test123"
//        )),
//        Student(mapOf(
//            "id" to 3,
//            "surname" to "Иванов",
//            "name" to "Василий",
//            "patronym" to "Петрович",
//            "telegram" to "@vasya228",
//            "git" to "https://github.com/vasyacodes"
//        )),
//        Student(mapOf(
//            "id" to 4,
//            "surname" to "Who",
//            "name" to "Are",
//            "patronym" to "You",
//            "git" to "https://gitlab.com/unknown"
//        )),
//        Student(mapOf(
//            "id" to 5,
//            "surname" to "I",
//            "name" to "Like",
//            "patronym" to "Kotlin",
//            "email" to "kotlinisthebest@meow.com"
//        )),
//        //Student(mapOf(
//        //    "id" to 6,
//        //    "surname" to "Чел",
//        //    "name" to "Снеправильным",
//        //    "patronym" to "Номером",
//        //    "phone" to "iPhone 15 Pro Max"
//        //)),
//        //Student(mapOf(
//        //    "id" to 6,
//        //    "surname" to "Фамилия",
//        //    "name" to "Имя",
//        //    "patronym" to ""
//        //)),
//        //Student(mapOf(
//        //    "id" to 6,
//        //    "surname" to "123",
//        //    "name" to "Имя",
//        //    "patronym" to ""
//        //)),
//        //Student(mapOf(
//        //    "id" to 6,
//        //    "surname" to "Фамилия",
//        //    "name" to "Имя ",
//        //    "patronym" to ""
//        //)),
//        //Student(mapOf(
//        //    "id" to 6,
//        //    "surname" to "Фамилия",
//        //    "name" to "Имя",
//        //    "patronym" to "Отчество",
//        //    "telegram" to "telega",
//        //    "email" to "example.com",
//        //    "git" to "https://github.com/1/2/3"
//        //)),
//    )
//
//    students.forEach { it.show() }
//
//    students.forEach { println("У данного студента гит ${if (it.checkGit()) "при" else "от"}сутствует!") }
//    students.forEach { println("У данного студента контакты ${if (it.checkContact()) "при" else "от"}сутствуют!") }
//
//    students[1].setContacts(mapOf("telegram" to null, "email" to "test123@example.com"))
//    students[1].show()
//}

//fun lab2() {
//    val students = mutableListOf(
//        Student("1|Эзри|Артём|Александрович||||"),
//        Student("2|Тестов|Тест|Тестович|+79876543210|@test123|test@example.com|https://github.com/test123"),
//        Student("3|Иванов|Василий|Петрович||@vasya228||https://github.com/vasyacodes"),
//        Student("4|Who|Are|You||||https://gitlab.com/unknown"),
//        Student("5|I-Like|Kotlin||||kotlinisthebest@meow.com|"),
//
//        // Test parsing exceptions
//        // Student("|||||||"),
//        // Student("6|||||||"),
//        // Student("6|Ф|И|О|abc|||"),
//        // Student("123"),
//        // Student(""),
//        // Student("6|Ф|И|О"),
//        // Student("6|Ф|И|О|abc||||"),
//        // Student("6|Ф|И|О||@test\n123||"),
//    )
//
//    students.forEach { it.show() }
//
//    students.forEach { println(it.getInfo()) }
//
//    val shortStudents = mutableListOf(
//        StudentShort(students[0]),
//        StudentShort(students[1]),
//        StudentShort(students[2]),
//        StudentShort(students[3]),
//        StudentShort(students[4]),
//        StudentShort(6, "Студент Аноним М., git не указан, контакты не указаны"),
//        StudentShort(7, "Студент Студе Н. Т., git: https://github.com/student, связаться можно по номеру телефона: +12345678900")
//    )
//
//    shortStudents.forEach { it.show() }
//}

//fun lab2FileTest() {
//    val studList = Student.readFromTxt("lab2_input.txt")
//    studList.forEach { println(it.getInfo()) }
//
//    Student.writeToTxt("lab2_output.txt", studList)
//
//    val studList2 = Student.readFromTxt("lab2_output.txt")
//    println()
//    studList2.forEach { println(it.getInfo()) }
//    require(studList2.toString() == studList.toString())
//}

//fun lab2part2() {
//    val studList = Student.readFromTxt("lab2_input.txt").map { StudentShort(it) }
//    studList.forEach { it.show() }
//    val dataList = DataListStudentShort(studList)
//    val names = dataList.getNames()
//    dataList.select(0)
//    dataList.select(2)
//    println(dataList.getSelected())
//    println(names)
//    val dataTable = dataList.getData()
//    for (i in 0..<dataTable.getRowCount()) {
//        for (j in 0..<dataTable.getColCount()) {
//            print("${dataTable[i, j]} ")
//        }
//        println()
//    }
//}

fun printDataTable(dataTable: DataTable) {
    for (i in 0..<dataTable.getRowCount()) {
        for (j in 0..<dataTable.getColCount()) {
            print("${dataTable[i, j]} ")
        }
        println()
    }
}

//fun lab3Test() {
//    // TXT
//
//    val students = StudentList(TXTFormatStrategy())
//    students.load("lab2_input.txt")
//    println(students.getStudentShortCount())
//    for (id in -1..6) {
//        try {
//            println(students.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//    println()
//
//    printDataTable(students.getStudentShortList(1, 3).getData())
//    println("=========================")
//    printDataTable(students.getStudentShortList(1, 0).getData())
//    println("=========================")
//    // printDataTable(students.getStudentShortList(0, 3).getData())
//    // println("=========================")
//    // printDataTable(students.getStudentShortList(1, -1).getData())
//    // println("=========================")
//    printDataTable(students.getStudentShortList(1, 100).getData())
//    println("=========================")
//    printDataTable(students.getStudentShortList(2, 100).getData())
//    println("=========================")
//    printDataTable(students.getStudentShortList(3, 1).getData())
//    println("=========================")
//    printDataTable(students.getStudentShortList(2, 3).getData())
//    println("=========================")
//    printDataTable(students.getStudentShortList(1, 5).getData())
//    println("=========================")
//    printDataTable(students.getStudentShortList(1, 6).getData())
//    println()
//
//    students.sortByStudentName()
//    printDataTable(students.getStudentShortList(1, 5).getData())
//    println()
//
//    students.add(Student(0, "Новый", "Студент", "Хе-хе"))
//    printDataTable(students.getStudentShortList(1, 100).getData())
//    println(students.getStudentById(6).toStringRow())
//    students.replace(6, Student(0, "Изменённый", "Студент", "Хе-хе"))
//    println(students.getStudentById(6).toStringRow())
//    println()
//    students.remove(5)
//    for (id in 1..7) {
//        try {
//            println(students.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//    println()
//    students.add(Student(0, "Вернувшийся", "Студент", "Хе-хе"))
//    students.remove(7)
//    students.add(Student(0, "Студент", "Номер", "Восемь"))
//    for (id in 1..9) {
//        try {
//            println(students.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//    println(students.getStudentShortCount())
//    students.save("lab3_output.txt")
//
//    // JSON
//
//    students.formatStrategy = JSONFormatStrategy()
//    students.save("lab3_output.json")
//
//    val students2 = StudentList(JSONFormatStrategy())
//    students2.load("lab3_output.json")
//    println(students.getStudentShortCount())
//    for (id in -1..7) {
//        try {
//            println(students.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//
//    // YAML
//
//    students.formatStrategy = YAMLFormatStrategy()
//    students.save("lab3_output.yaml")
//
//    students2.formatStrategy = YAMLFormatStrategy()
//    students2.load("lab3_output.yaml")
//    println(students.getStudentShortCount())
//    for (id in -1..7) {
//        try {
//            println(students.getStudentById(id).toStringRow())
//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
//    }
//}

fun testStudentListDB() {
    val students = StudentListDB()
    Database.connect()
    println(students.getStudentById(1)?.toStringRow())
    println(students.getStudentById(0))
    println()
    printDataTable(students.getStudentShortList(3, 2).getData())
    println()
    printDataTable(students.getStudentShortList(2, 4).getData())
    println()
    println(students.getStudentShortCount())
    students.add(Student(0, "Новый", "Студент", "Хе-хе"))
    println(students.getStudentShortCount())
    println(students.getStudentById(8)?.toStringRow())
    println(students.getStudentById(9)?.toStringRow())
    students.remove(7)
    println(students.remove(5))
    students.add(Student(0, "Ещё", "Студент", "", email = "123@456.789"))
    students.replace(8, Student(0, "Изменённый", "Студент", "", telegram = "@skullemoji"))
    println(students.remove(0))
    println(students.remove(100))
}

fun main() {
    testStudentListDB()
}
