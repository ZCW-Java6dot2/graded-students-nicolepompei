package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class ClassroomTest {
@Test
    public void testConstructorPresetMaxNumStudents(){
    Classroom testClassroom = new Classroom();
    int expected = 30;
    //actual

    int actual = testClassroom.getStudents().length;

    Assert.assertEquals(expected, actual);
}

@Test
    public void testConstructorSetMaxNumStudents(){
    Classroom testClassroom = new Classroom(20);
    int expected = 20;

    int actual = testClassroom.getStudents().length;

    Assert.assertEquals(expected, actual);

}

@Test
    public void testConstructorStudentObjects(){
    //empty classroom returns nothing
    Student [] students = new Student[0];
    Classroom testClassroom = new Classroom(students);
    Student[] expectedStudents = {};

    //actual
    Student[] actualStudents = testClassroom.getStudents();

    Assert.assertEquals(expectedStudents, actualStudents);
}

@Test
    public void testAvgExamScore(){
    Double[] jerryScores = {100.0, 95.0, 97.0};
    Double[] zivaScores = {98.0, 100.0, 95.0};
    Student jerryStudent = new Student("JerryLee", "Lewis", jerryScores);
    Student zivaStudent = new Student("Ziva", "Pompei", zivaScores);
    Student[] students = new Student[]{jerryStudent, zivaStudent};
    Classroom testClassroom = new Classroom(students);
    Double expectedAvgExamScore = 98.0;

    //actual
    Double actualAvgExamScore = testClassroom.getAverageExamScore();

    Assert.assertEquals(expectedAvgExamScore, actualAvgExamScore);

}

@Test
    public void testAddStudent(){
    Double[] zivaScores = {100.0, 95.00};
    Student zivaStudent = new Student("Ziva", "Pompei", zivaScores);
    Classroom testClassroom = new Classroom(1);
    Student[] expected = {zivaStudent};

    //actual
    testClassroom.addStudent(zivaStudent);
    Student[] actual = testClassroom.getStudents();

    Assert.assertEquals(expected, actual);

}

@Test
    public void testRemoveStudent(){
    Double[] zivaScores = {100.0, 95.00};
    Double[] jerryScores = {100.0, 95.0, 97.0};
    Student zivaStudent = new Student("Ziva", "Pompei", zivaScores);
    Student jerryStudent = new Student("JerryLee", "Lewis", jerryScores);
    Student[] newStudents = {zivaStudent, jerryStudent};
    Classroom testClassroom = new Classroom(newStudents);
    Boolean expected = false;

    //actual
    testClassroom.removeStudent("Ziva", "Pompei");
   Boolean actual = testClassroom.toString().equals(zivaStudent);

    Assert.assertEquals(expected, actual);

}
@Test
    public void testRemoveStudentNoStudent(){
    Double[] zivaScores = {100.0, 95.00};
    Double[] jerryScores = {100.0, 95.0, 97.0};
    Student zivaStudent = new Student("Ziva", "Pompei", zivaScores);
    Student jerryStudent = new Student("JerryLee", "Lewis", jerryScores);
    Student[] newStudents = {zivaStudent, jerryStudent};
    Classroom testClassroom = new Classroom(newStudents);
    Boolean expected = false;

    //actual
    Boolean actual = testClassroom.removeStudent("Cindy", "Lou");

    Assert.assertFalse(actual);

}

@Test
    public void testGetStudentByScoreSameScore(){
    Double[] student1Scores = {65.0, 75.0};
    Double[] student2Scores = {70.0, 80.0};
    Double[] student3Scores = {70.0, 80.0};
    Student student1 =  new Student("Sarah", "Appleby", student1Scores);
    Student student2 = new Student("Tammy", "Ant", student2Scores);
    Student student3 = new Student("Tyler", "Mann", student3Scores);
    Student[] students = {student1, student2, student3};
    Classroom testClassroom = new Classroom(students);

    Student[] expectedStudents = {student2, student3, student1};
    //actual
    Student[] actualStudents = testClassroom.getStudentsByScore();

    Assert.assertEquals(expectedStudents, actualStudents);



}

@Test
    public void testGetStudentByScoreSameName(){
    Double[] student1Scores = {65.0, 75.0};
    Double[] student2Scores = {70.0, 80.0};
    Double[] student3Scores = {90.0, 100.0};
    Student student1 =  new Student("Sarah", "Appleby", student1Scores);
    Student student2 = new Student("Tammy", "Ant", student2Scores);
    Student student3 = new Student("Tyler", "ant", student3Scores);
    Student[] students = {student3, student2, student1};
    Classroom testClassroom = new Classroom(students);
    Student[] expected = {student3, student2, student1};
    Student[] actual = testClassroom.getStudentsByScore();

    Assert.assertEquals(expected, actual);

}

@Test
    public void getGradeBookTest() {
    // Given
    Double[] zivaScores = {80.0, 82.0};
    Double[] jonScores = {51.0, 52.0};
    Double[] jessieScores = {21.0, 25.0};
    Student ziva = new Student("Ziva", "Pompei", zivaScores);
    Student jon = new Student("Jon", "Snow", jonScores);
    Student jessie = new Student("Jessie", "Pinkman", jessieScores);
    Classroom testClassroom = new Classroom(3);
    // When
    testClassroom.addStudent(ziva);
    testClassroom.addStudent(jon);
    testClassroom.addStudent(jessie);
    HashMap<Student, String> expected = new HashMap<>();
    expected.put(jon, "A");
    expected.put(ziva, "A");
    expected.put(jessie, "D");
    // Then
    HashMap<Student, String> actual = (HashMap<Student, String>) testClassroom.getGradeBook();
    Assert.assertEquals(expected, actual);
}
}
