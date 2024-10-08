abstract class DataList(protected val array: List<Any?>) {
    private val selectedIndices: MutableList<Int> = mutableListOf()

    fun getSelected() = selectedIndices.toList()

    abstract fun getNames() : List<String>

    abstract fun getData() : DataTable
}
