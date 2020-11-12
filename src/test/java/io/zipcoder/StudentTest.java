package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    private Student zipCoder;

    @Before
    public void setup(){
        Double[] defaultExamScores = {85.00, 72.00, 94.00};
        this.zipCoder = new Student("defaultFn", "defaultLn", defaultExamScores);
    }

    @Test
    public void defaultStudentConstructor_noReturn(){
        //Given
        String expectedFirstName = "";
        String expectedLastName = "";
        Double[] examScores = {};
        Student zipCoder = new Student(expectedFirstName, expectedLastName, examScores);
        //When
        String actualFn = zipCoder.getFirstName();
        String actualLn = zipCoder.getLastName();
        //Then

        Assert.assertEquals(expectedFirstName, actualFn);
        Assert.assertEquals(expectedLastName, actualLn);
    }

    @Test
    public void testConstructor_returnsFirstName(){
        //Arrange
        Double[] examScores = {85.00, 72.00, 94.00};
        Student zipCoder = new Student("Pompy", "Pompei", examScores);
        String expectedFirstName = "Pompy";
        //actual
        String actualFirstName = zipCoder.getFirstName();

        Assert.assertEquals(expectedFirstName, actualFirstName);

    }

    @Test
    public void testConstructor_returnsLastName(){
        //Arrange
        Double[] examScores = {85.00, 72.00, 94.00};
        Student zipCoder = new Student("Pompy", "Pompei", examScores);
        String expectedLastName = "Pompei";
        //actual

        String actualLastName = zipCoder.getLastName();

        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testConstructor_returnsExamScores(){
        //Arrange
        Double[] examScores = {85.00, 72.00, 94.00};
        //convert array to arraylist
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        Student zipCoder =  new Student("Pompy", "Pompei", examScores);
        //actual
        ArrayList<Double> actualExamScores = zipCoder.getTestScores();

        Assert.assertEquals(expectedExamScores, actualExamScores);

    }

    @Test
    public void testConstructor_returnsFnLnExamScores(){
        //Arrange
        Double[] examScores = {85.00, 72.00, 94.00};
        ArrayList<Double> expectedExamScores = new ArrayList<>(Arrays.asList(examScores));
        Student zipCoder = new Student("Pompy", "Pompei", examScores);
        String expectedFn = "Pompy";
        String expectedLn = "Pompei";
        //actual
        String actualFn = zipCoder.getFirstName();
        String actualLn = zipCoder.getLastName();
        ArrayList<Double> actualExamScores = zipCoder.getTestScores();

        Assert.assertEquals(expectedFn, actualFn);
        Assert.assertEquals(expectedLn, actualLn);
        Assert.assertEquals(expectedExamScores, actualExamScores);

    }

    @Test
    public void testSetFirstName(){
        String expectedFn = "Jessie";
        //Actual
        zipCoder.setFirstName(expectedFn);
        String actualFn = zipCoder.getFirstName();

        Assert.assertEquals(expectedFn, actualFn);
    }

    @Test
    public void testSetLastName(){
        String expectedLn = "Pinkman";

        //Actual
        zipCoder.setLastName(expectedLn);
        String actualLn = zipCoder.getLastName();

        Assert.assertEquals(expectedLn, actualLn);
    }

    @Test
    public void testGetNumberOfExamsTaken(){
        int expectedNumOfExams = 3;
        //Actual
        int actualNumOfExams = zipCoder.getNumberOfExamsTaken();

        Assert.assertEquals(expectedNumOfExams, actualNumOfExams);

    }

    @Test
    public void testGetExamScores(){
        String firstName = "Jon";
        String lastName = "Snow";
        Double[] examScores = {95.00, 84.00, 100.00, 80.00};
        String expectedExamScores = "Exam 1: 95.00\nExam 2: 84.00\nExam 3: 100.00\nExam 4: 80.00";

        Student newStudent = new Student(firstName, lastName, examScores);

        //actual
        String actualExamScores = newStudent.getExamScores();

        Assert.assertEquals(expectedExamScores, actualExamScores);

    }


    @Test
    public void testAddExamScore(){
        String firstName = "Jon";
        String lastName = "Snow";
        Double[] examScores = {};
        String expectedExamScore = "Exam 1: 100.00";
        Student newStudent = new Student(firstName, lastName, examScores);
        //actual
        newStudent.addExamScore(100.00);
        String actualExamScore = newStudent.getExamScores();

        Assert.assertEquals(expectedExamScore, actualExamScore);
    }

    @Test
    public void testSetExamScore(){
        String firstName = "JerryLee";
        String lastName = "Lewis";
        Double [] examScores = {100.00};
        Student newStudent = new Student(firstName, lastName, examScores);
        String expectedExamScore = "Exam 1: 95.00";

        //actual
        newStudent.setExamScore(1, 95.00);
        String actualExamScore = newStudent.getExamScores();

        Assert.assertEquals(expectedExamScore, actualExamScore);
    }

    @Test
    public void testGetAverageExamScore(){
        String firstName = "Simba";
        String lastName = "Cat";
        Double[] examScores = {100.00, 95.00, 85.00, 100.00};
        Double expectedAverageScore = 95.00;
        Student newStudent = new Student(firstName, lastName, examScores);

        //actual
        Double actualAvgScore = newStudent.getAverageExamScore();

        Assert.assertEquals(expectedAverageScore, actualAvgScore);

    }

    @Test
    public void testToString(){
        Double[] examScores = {100.00, 95.00, 85.00, 96.00};
        //Double expectedAverageScore = 95.00;
        Student newStudent = new Student("Simba", "Cat", examScores);

        String expectedString = "Student Name: Simba Cat\n"+
                "Average Score: 94.0\n"+
                "Exam Scores:\n"+
                "Exam 1: 100.00\n"+
                "Exam 2: 95.00\n"+
                "Exam 3: 85.00\n"+
                "Exam 4: 96.00\n";

        String actualString = newStudent.toString();

        Assert.assertEquals(expectedString, actualString);

    }

}