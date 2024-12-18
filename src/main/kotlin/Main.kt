import javafx.application.Application

fun main() {
    System.setProperty("prism.order", "sw")
    System.setProperty("prism.text", "grayscale")
    Application.launch(StudentsApp::class.java)
}
