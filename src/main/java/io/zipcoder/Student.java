package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        //if(testScores != null){
          //  for (Double element: testScores) {
            //    element.setOwner(this);
              //  petsList.add(pet);
            }




    public String getFirstName(){ return firstName;

    }

    public String getLastName(){ return lastName;

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getExamScores(){
    StringBuilder listScores = new StringBuilder();
    Formatter formattedOutput = new Formatter(listScores);

    for(Double studentScore : this.examScores){
        formattedOutput.format("Exam %d: %.2f%n", (this.examScores.indexOf(studentScore)) + 1, studentScore);
    }
    //returns scores and trims off white space
    return listScores.toString().trim();

}

    public int getNumberOfExamsTaken(){
         return examScores.size();

    }

    public void addExamScore(Double examScore){
        this.examScores.add(examScore);

    }

    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber - 1, newScore);

    }

    public double getAverageExamScore(){
        double examScoreTotal = 0;

        for(Double element: this.examScores){
            examScoreTotal += element;
        }
        return Math.round(examScoreTotal/examScores.size());
    }

    @Override
    public String toString(){
        StringBuilder studentRecord = new StringBuilder();
        Formatter formattedOutput = new Formatter(studentRecord);
       formattedOutput.format("Student Name: %s %s%nAverage Score: %s%nExam Scores:%n%s%n", this.getFirstName(), this.getLastName(), this.getAverageExamScore(), this.getAverageExamScore());
       return studentRecord.toString();
    }

}