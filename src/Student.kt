class Student(
    val id: Int,
    surname: String, name: String, patronym: String,
    phone: String? = null, telegram: String? = null,
    email: String? = null, git: String? = null
) {
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
