class StudentListDB {
    fun getStudentById(id: Int) : Student? {
        val resultSet = Database.executeQuery("SELECT * FROM Student WHERE \"id\" = $id")
        return if (resultSet.next()) Student(mapOf(
            "id" to resultSet.getInt("id"),
            "surname" to resultSet.getString("surname"),
            "name" to resultSet.getString("name"),
            "patronym" to resultSet.getString("patronym"),
            "phone" to resultSet.getString("phone"),
            "telegram" to resultSet.getString("telegram"),
            "email" to resultSet.getString("email"),
            "git" to resultSet.getString("git")
        )) else null
    }

    fun getStudentShortList(k: Int, n: Int) : DataListStudentShort {
        if (k < 1) throw IllegalArgumentException("Значение k должно быть больше или равно 1")
        if (n < 0) throw IllegalArgumentException("Значение n не должно быть отрицательным")
        val firstElem = (k - 1) * n
        val resultSet = Database.executeQuery("SELECT * FROM Student LIMIT $firstElem, $n")
        val studentsSlice = buildList {
            while (resultSet.next()) {
                add(StudentShort(Student(mapOf(
                    "id" to resultSet.getInt("id"),
                    "surname" to resultSet.getString("surname"),
                    "name" to resultSet.getString("name"),
                    "patronym" to resultSet.getString("patronym"),
                    "phone" to resultSet.getString("phone"),
                    "telegram" to resultSet.getString("telegram"),
                    "email" to resultSet.getString("email"),
                    "git" to resultSet.getString("git")
                ))))
            }
        }
        return DataListStudentShort(studentsSlice)
    }

    fun add(student: Student) : Boolean {
        val sql = "INSERT INTO Student" +
                  "(\"surname\", \"name\", \"patronym\", \"phone\", \"telegram\", \"email\", \"git\")" +
                  "VALUES (?, ?, ?, ?, ?, ?, ?)"
        return Database.executeUpdate(sql) {
            it.setString(1, student.surname)
            it.setString(2, student.name)
            it.setString(3, student.patronym)
            it.setString(4, student.phone)
            it.setString(5, student.telegram)
            it.setString(6, student.email)
            it.setString(7, student.git)
        } > 0
    }

    fun replace(id: Int, newStudent: Student) : Boolean {
        val sql = "UPDATE Student SET \"surname\" = ?, \"name\" = ?, \"patronym\" = ?," +
                  "\"phone\" = ?, \"telegram\" = ?, \"email\" = ?, \"git\" = ?" +
                  "WHERE id = ?"
        return Database.executeUpdate(sql) {
            it.setString(1, newStudent.surname)
            it.setString(2, newStudent.name)
            it.setString(3, newStudent.patronym)
            it.setString(4, newStudent.phone)
            it.setString(5, newStudent.telegram)
            it.setString(6, newStudent.email)
            it.setString(7, newStudent.git)
            it.setInt(8, id)
        } > 0
    }

    fun remove(id: Int) : Boolean {
        val sql = "DELETE FROM Student WHERE \"id\" = ?"
        return Database.executeUpdate(sql) { it.setInt(1, id) } > 0
    }

    fun getStudentShortCount() : Int {
        val resultSet = Database.executeQuery("SELECT count(*) AS cnt FROM Student")
        resultSet.next()
        return resultSet.getInt(1)
    }
}
