<h2 align="center">A repo for my university homework on software design patterns<br><br></h2>

```mermaid
---
title: Диаграмма классов
---
classDiagram
StudentBase <|-- Student
StudentBase <|-- StudentShort
DataListStudentShort <|-- DataList
    class StudentBase{
        <<abstract>>
        +id : Int*
        +git : String?*
        #nameRegex : Regex$
        #phoneRegex : Regex$
        #telegramRegex : Regex$
        #emailRegex : Regex$
        #gitRegex : Regex$
        +toString() String*
        +show()
        #isValidName(value : String) Boolean$
        #isValidPatronym(value : String) Boolean$
        #isValidPhoneNumber(value : String) Boolean$
        #isValidTelegram(value : String) Boolean$
        #isValidEmail(value : String) Boolean$
        #isValidGit(value : String) Boolean$
    }
    class Student{
        +id : Int
        +surname : String
        +name : String
        +patronym : String
        +phone : String?
        +telegram : String?
        +email : String?
        +git : String?
        +Student(id : Int, surname : String, name : String, patronym : String, phone : String? = null, telegram : String? = null, email : String? = null, git : String? = null)
        +constructor(hashMap : Map~String, Any~)
        +constructor(row : String)
        -constructor(row: List~String~)
        +getInfo() String
        -getInitials() String
        -getContact() Pair~String, String?~?
        +toString() String
        +show()
        +checkGit() Boolean
        +checkContact() Boolean
        +setContacts(hashMap : Map~String, String?~)
        +readFromTxt(filepath : String) List~Student~$
        +writeToTxt(filepath : String, students : Iterable~Student~)$
    }
    class StudentShort{
        +id : Int
        +surnameWithInitials : String
        +git : String?
        +contact : String?
        +constructor(id : Int, info : String)
        +constructor(student : Student)
        +toString() String
    }
    class DataTable{
        -array : List~List~Any?~~
        +constructor(array : List~List~Any?~~)
        +get(row : Int, col : Int) Any?
        +getRowCount() Int
        +getColCount() Int
    }
    class DataList{
        <<abstract>>
        #array : List~Any?~
        +constructor(array : List~Any?~)
        +select(number : Int)
        +getSelected() List~Int~
        +getNames() List~String~*
        +getData() DataTable*
    }
    class DataListStudentShort{
        +constructor(studentShortArray : List~StudentShort~)
        +getNames() List~String~
        +getData() DataTable
    }
```
##
<h3><br></h3>
<p align="center"><a href="https://youtu.be/bUh2W3jjapA"><img src="https://github.com/user-attachments/assets/423df8af-babc-4bf4-af76-1e2d7c0ab0e9" height=360 alt="ATARAXIA - Patterns"></img></a></p>
