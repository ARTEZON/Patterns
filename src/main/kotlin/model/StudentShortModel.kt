package model

import DataListStudentShort
import Database
import Student
import StudentList
import StudentListDB
import filter.SearchParam
import view.ViewInterface

class StudentShortModel(private val views: List<ViewInterface>) : ModelInterface {
    private val studentList: StudentList = StudentList(StudentListDB())
    private var page = 1
    private var pageSize = 15
    private var searchParam: SearchParam? = null

    init {
        Database.connect()
    }

    override fun notify(listStudentShort: DataListStudentShort) {
        for (subscriber in views) {
            subscriber.setTableParams(listStudentShort.getNames(), studentList.getStudentShortCount(), page, pageSize)
            subscriber.setTableData(listStudentShort.getData())
        }
    }

    override fun refreshData(k: Int, n: Int, searchParam: SearchParam?) {
        page = k
        pageSize = n
        val listStudentShort = studentList.getStudentShortListFiltered(k, n, searchParam)
        this.notify(listStudentShort)
    }

    override fun addStudent(surname: String, name: String, patronym: String, git: String?, email: String?, phone: String?, telegram: String?) {
        studentList.add(Student(0, surname, name, patronym, phone, telegram, email, git))
        this.refreshData(page, pageSize, searchParam)
    }

    override fun editStudent(idToEdit: Int, surname: String, name: String, patronym: String, git: String?, email: String?, phone: String?, telegram: String?) {
        studentList.replace(idToEdit, Student(0, surname, name, patronym, phone, telegram, email, git))
        this.refreshData(page, pageSize, searchParam)
    }

    override fun delStudent(id: Int) {
        studentList.remove(id)
        this.refreshData(page, pageSize, searchParam)
    }

    override fun getIdsOfCurrentPageRows() = studentList.getStudentShortList(page, pageSize).getIds()

    override fun getStudentById(id: Int) = studentList.getStudentById(id)
}
