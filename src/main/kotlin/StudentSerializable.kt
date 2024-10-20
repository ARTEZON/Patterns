import kotlinx.serialization.Serializable

@Serializable
data class StudentSerializable(val id: Int,
                               val surname: String,
                               val name: String,
                               val patronym: String,
                               val phone: String? = null,
                               val telegram: String? = null,
                               val email: String? = null,
                               val git: String? = null) {
    constructor(student: Student) : this(student.id,
        student.surname,
        student.name,
        student.patronym,
        student.phone,
        student.telegram,
        student.email,
        student.git)
}
