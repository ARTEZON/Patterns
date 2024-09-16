<h2 align="center">A repo for my university homework on software design patterns<br><br></h2>

```mermaid
---
title: Диаграмма классов
---
classDiagram
    class Student{
        +id : Int
        +surname : String
        +name : String
        +patronym : String
        +phone : String?
        +telegram : String?
        +email : String?
        +git : String?
        -nameRegex : Regex$
        -phoneRegex : Regex$
        -telegramRegex : Regex$
        -emailRegex : Regex$
        -gitRegex : Regex$
        +Student(id : Int, surname : String, name : String, patronym : String, phone : String? = null, telegram : String? = null, email : String? = null, git : String? = null)
        +constructor(id : Int, surname: String, name : String, patronym : String, phone : String)
        +constructor(id : Int, surname: String, name : String, patronym : String, email : String, git : String)
        +constructor(hashMap : Map~String, Any~)
        +toString() String
        +show()
        +checkGit() Boolean
        +checkContact() Boolean
        +setContacts(hashMap : Map~String, String?~)
        +isValidName(value : String) Boolean$
        +isValidPatronym(value : String) Boolean$
        +isValidPhoneNumber(value : String) Boolean$
        +isValidTelegram(value : String) Boolean$
        +isValidEmail(value : String) Boolean$
        +isValidGit(value : String) Boolean$
    }
```
##
<h3><br></h3>
<p align="center"><a href="https://youtu.be/bUh2W3jjapA"><img src="https://github.com/user-attachments/assets/423df8af-babc-4bf4-af76-1e2d7c0ab0e9" height=360 alt="ATARAXIA - Patterns"></img></a></p>
