public class MVC_Test {
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("John Doe", "12345", "A");
        // Create a StudentView object
        StudentView view = new StudentView();
        // Create a StudentController object
        StudentController controller = new StudentController(student, view);
        // Display initial details
        controller.updateView();
        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("A+");
        // Display updated details
        controller.updateView();
    }
}