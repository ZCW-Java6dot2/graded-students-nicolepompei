package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];

    }

    public Classroom(Student[] students){
    this.students = students;
    }

    public Classroom(){
        this(30);

    }

    public Student[] getStudents(){
        return students;
    }

    public double getAverageExamScore(){
    double sumOfAllExamScoreAverages = 0;

    for(Student student: students){
        if(student != null){
        sumOfAllExamScoreAverages+= student.getAverageExamScore();
         }
        }
        return Math.round(sumOfAllExamScoreAverages/students.length);
    }

    public Boolean addStudent(Student newStudent){
        for(int i = 0; i < this.students.length; i++){
            if(this.students[i] == null){
                this.students[i]= newStudent;
                return true;
            }
        }
         return false;
    }

        //uses first name and last name parameter to remove a student
    //null values located in end of array
    //re-ordered after the removal of
    //array ==> arraylist
    //loop through array to find if student exists
    //if you find student, assign them to currentStudent
    //convert to array list and remove currentstudent
    //convert back to array

    public Boolean removeStudent(String firstName, String lastName){

        Student studentToBeRemoved = null;

        for(Student currentStudent: this.students){
         if(currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
             studentToBeRemoved = currentStudent;
             break;
         }
        }

        if(studentToBeRemoved == null){
            return false;
        }

        //convert students to arraylist and remove studentToBeRemoved
        ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(students));
        studentsList.remove(studentToBeRemoved);

        //convert studentsList back to an array

        this.students = studentsList.toArray(this.students);
        return true;

    }

    //return an array of student objects sorted in descending order by score
    //if two students have same class average sort lexigraphically
    public Student[] getStudentsByScore(){
        ArrayList<Student> studentsList = new ArrayList<>(Arrays.asList(students));

        Collections.sort(studentsList, Collections.reverseOrder());

        return studentsList.toArray(this.students);

        


    }


}
