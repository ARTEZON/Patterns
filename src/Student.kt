class Student(
    val id: Int,
    surname: String,
    name: String,
    patronym: String,
    phone: String? = null,
    telegram: String? = null,
    email: String? = null,
    git: String? = null
) {
    companion object {
        private val phoneRegex = Regex("""^\+?[0-9]{10,15}$""")

        fun isValidPhoneNumber(value: String?) = value == null || phoneRegex.matches(value)
    }

    var surname = surname
        get() = field
        set(value) { field = value }
    var name = name
        get() = field
        set(value) { field = value }
    var patronym = patronym
        get() = field
        set(value) { field = value }
    var phone = phone
        get() = field
        set(value) {
            if (isValidPhoneNumber(value)) field = value
            else throw IllegalArgumentException("Такого номера телефона не существует")
        }
    var telegram = telegram
        get() = field
        set(value) { field = value }
    var email = email
        get() = field
        set(value) { field = value }
    var git = git
        get() = field
        set(value) { field = value }

    init {
        this.surname = surname
        this.name = name
        this.patronym = patronym
        this.phone = phone
        this.telegram = telegram
        this.email = email
        this.git = git
    }

    constructor(id: Int,
                surname: String,
                name: String,
                patronym: String,
                phone: String) : this(id, surname, name, patronym) {
        this.phone = phone
    }

    constructor(id: Int,
                surname: String,
                name: String,
                patronym: String,
                email: String,
                git: String) : this(id, surname, name, patronym) {
        this.email = email
        this.git = git
    }

    constructor(hashMap: Map<String, Any>) : this(
        hashMap["id"]       as  Int,
        hashMap["surname"]  as  String,
        hashMap["name"]     as  String,
        hashMap["patronym"] as  String,
        hashMap["phone"]    as? String,
        hashMap["telegram"] as? String,
        hashMap["email"]    as? String,
        hashMap["git"]      as? String,
    )

    override fun toString(): String {
        var str = "[ID $id] $surname $name $patronym"
        if (phone != null) str += "\nНомер телефона: $phone"
        if (telegram != null) str += "\nTelegram: $telegram"
        if (email != null) str += "\nEmail: $email"
        if (git != null) str += "\nGit: $git"
        return "$str\n"
    }

    fun show() = println(this.toString())
}
