package model

import DataListStudentShort
import Student
import filter.SearchParam

interface ModelInterface {
    fun notify(listStudentShort: DataListStudentShort)
    fun refreshData(k: Int, n: Int, searchParam: SearchParam?)
    fun addStudent(surname: String, name: String, patronym: String, git: String?, email: String?, phone: String?, telegram: String?)
    fun editStudent(idToEdit: Int, surname: String, name: String, patronym: String, git: String?, email: String?, phone: String?, telegram: String?)
    fun delStudent(id: Int)
    fun getIdsOfCurrentPageRows(): List<Int>
    fun getStudentById(id: Int): Student?
}
