package filter

import Student

class nameFilter(newFilter: FilterInterface) : FilterDecorator(newFilter) {
    override fun filter(students: List<Student>, searchParam: SearchParam): List<Student> {
        val filteredStudents = ArrayList<Student>()
        students.forEach {
            if (it.surname.contains(searchParam.surnameFilter, ignoreCase = true) &&
                it.name.contains(searchParam.nameFilter, ignoreCase = true) &&
                it.patronym.contains(searchParam.patronymFilter, ignoreCase = true))
            {
                filteredStudents.add(it)
            }
        }
        return tempFilter.filter(filteredStudents, searchParam)
    }
}
