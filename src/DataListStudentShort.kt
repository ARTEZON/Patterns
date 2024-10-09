class DataListStudentShort(studentShortArray: List<StudentShort>) : DataList(studentShortArray) {
    override fun getNames() = listOf("№", "ФИО", "Git", "Контакт для связи")

    override fun getData() = DataTable(buildList {
        var count = 1
        for (obj in array) {
            val studentShort = obj as StudentShort
            add(listOf(count++, studentShort.surnameWithInitials, studentShort.git, studentShort.contact))
        }
    })
}
