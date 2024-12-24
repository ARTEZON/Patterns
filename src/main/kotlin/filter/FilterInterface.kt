package filter

import Student

interface FilterInterface {
    fun filter(students: List<Student>, searchParam: SearchParam): List<Student>
}