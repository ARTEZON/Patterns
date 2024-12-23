class Student(
    override val id: Int,
    surname: String,
    name: String,
    patronym: String,
    phone: String? = null,
    telegram: String? = null,
    email: String? = null,
    git: String? = null
) : StudentBase() {

    var surname = surname
        get() = field
        set(value) {
            if (isValidName(value)) field = value
            else throw IllegalArgumentException("Фамилия имеет недопустимое значение")
        }
    var name = name
        get() = field
        set(value) {
            if (isValidName(value)) field = value
            else throw IllegalArgumentException("Имя имеет недопустимое значение")
        }
    var patronym = patronym
        get() = field
        set(value) {
            if (isValidPatronym(value)) field = value
            else throw IllegalArgumentException("Отчество имеет недопустимое значение")
        }
    var phone = phone
        get() = field
        set(value) {
            if (isValidPhoneNumber(value)) field = value
            else throw IllegalArgumentException("Номер телефона имеет недопустимое значение")
        }
    var telegram = telegram
        get() = field
        set(value) {
            if (isValidTelegram(value)) field = value
            else throw IllegalArgumentException("Имя пользователя Telegram имеет недопустимое значение")
        }
    var email = email
        get() = field
        set(value) {
            if (isValidEmail(value)) field = value
            else throw IllegalArgumentException("Адрес электронной почты имеет недопустимое значение")
        }
    override var git = git
        get() = field
        set(value) {
            if (isValidGit(value)) field = value
            else throw IllegalArgumentException("Ссылка на Git имеет недопустимое значение")
        }

    init {
        this.surname = surname
        this.name = name
        this.patronym = patronym
        this.phone = phone
        this.telegram = telegram
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

    constructor(row: String) : this(row.split('|').also {
        if (it.size != 8 || it.any { "\n" in it })
            throw IllegalArgumentException("Ошибка парсинга: строка имеет неверный формат")
    })

    private constructor(row: List<String>) : this(
        row[0].toIntOrNull().let { it ?: throw IllegalArgumentException("ID должен быть целым числом") },
        row[1],
        row[2],
        row[3],
        row[4].ifEmpty { null },
        row[5].ifEmpty { null },
        row[6].ifEmpty { null },
        row[7].ifEmpty { null }
    )

    fun getInfo() : String {
        val contactText = mapOf(
            "phone" to "по номеру телефона",
            "telegram" to "через Telegram",
            "email" to "по электронной почте"
        )
        val git = "git${if (this.git != null) ": ${this.git}" else " не указан"}"
        val contact = getContact().let {
            if (it != null) "связаться можно ${contactText[it.first]}: ${it.second}" else "контакты не указаны"
        }
        return "Студент ${getInitials()}, $git, $contact"
    }

    private fun getInitials() = "$surname ${name[0]}.${if (patronym.isNotEmpty()) " ${patronym[0]}." else ""}"

    private fun getContact() =
        if      (phone != null) Pair("phone", phone)
        else if (telegram != null) Pair("telegram", telegram)
        else if (email != null) Pair("email", email)
        else null

    override fun equals(other: Any?) =
        other is Student && surname == other.surname && name == other.name && patronym == other.patronym
        && phone == other.phone && telegram == other.telegram && email == other.email && git == other.git

    override fun hashCode() =
        surname.hashCode() + name.hashCode() + patronym.hashCode() +
        phone.hashCode() + telegram.hashCode() + email.hashCode() + git.hashCode()

    override fun toString(): String {
        var str = "[ID $id] $surname $name $patronym"
        if (phone != null) str += "\nНомер телефона: $phone"
        if (telegram != null) str += "\nTelegram: $telegram"
        if (email != null) str += "\nEmail: $email"
        if (git != null) str += "\nGit: $git"
        return "$str\n"
    }

    fun toStringRow() = listOf(
        id.toString(), surname, name, patronym, phone ?: "", telegram ?: "", email ?: "", git ?: ""
    ).joinToString("|")

    fun checkGit() = git != null

    fun checkContact() = phone != null || telegram != null || email != null

    fun setContacts(hashMap: Map<String, String?>) {
        if (hashMap.containsKey("phone")) phone = hashMap["phone"]
        if (hashMap.containsKey("telegram")) telegram = hashMap["telegram"]
        if (hashMap.containsKey("email")) email = hashMap["email"]
    }

    fun copyWithChangedId(newId: Int) = Student(newId, surname, name, patronym, phone, telegram, email, git)
}
