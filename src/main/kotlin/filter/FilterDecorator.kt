package filter

import Student

abstract class FilterDecorator(protected val tempFilter: FilterInterface) : FilterInterface {
    override fun filter(students: List<Student>, searchParam: SearchParam) = tempFilter.filter(students, searchParam)
}
