class Student(
    val id: Int,
    name: String, surname: String, patronym: String,
    phone: String? = null, telegram: String? = null,
    email: String? = null, git: String? = null
) {
    var name = name
        get() = field
        set(value) { field = value }
    var surname = surname
        get() = field
        set(value) { field = value }
    var patronym = patronym
        get() = field
        set(value) { field = value }
    var phone = phone
        get() = field
        set(value) { field = value }
    var telegram = telegram
        get() = field
        set(value) { field = value }
    var email = email
        get() = field
        set(value) { field = value }
    var git = git
        get() = field
        set(value) { field = value }
}