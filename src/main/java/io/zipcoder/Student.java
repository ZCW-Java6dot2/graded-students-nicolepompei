package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }


    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getTestScores() {
        return examScores;
    }

    public String getExamScores() {
        StringBuilder listScores = new StringBuilder();
        Formatter formattedOutput = new Formatter(listScores);

        for (Double studentScore : this.examScores) {
            formattedOutput.format("Exam %d: %.2f%n", (this.examScores.indexOf(studentScore)) + 1, studentScore);
        }
        //returns scores and trims off white space
        return listScores.toString().trim();

    }

    public int getNumberOfExamsTaken() {
        return examScores.size();

    }

    public void addExamScore(Double examScore) {
        this.examScores.add(examScore);

    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);

    }

    public double getAverageExamScore() {
        double examScoreTotal = 0.00;

        for (Double element : this.examScores) {
            examScoreTotal += element;
        }
        return Math.round(examScoreTotal / examScores.size());
    }

    @Override
    public String toString() {
        StringBuilder studentRecord = new StringBuilder();
        Formatter formattedOutput = new Formatter(studentRecord);
        formattedOutput.format("Student Name: %s %s%nAverage Score: %s%nExam Scores:%n%s%n", this.getFirstName(), this.getLastName(), this.getAverageExamScore(), this.getExamScores());
        return studentRecord.toString();
    }


    @Override
    public int compareTo(Student s) {
        // -1 means what is on the left is less than what is on the right (our comparing value)
        if (this.getAverageExamScore() > s.getAverageExamScore()) {
            return -1;
            // 1 means what is on the left is greater than what is on the right (our comparing value)
        } else if (this.getAverageExamScore() < s.getAverageExamScore()) {
            return 1;
        } else { // means that the exam scores are equal, so do a string comparison of last name
            return this.getLastName().compareTo(s.getLastName());
        }
    }
}