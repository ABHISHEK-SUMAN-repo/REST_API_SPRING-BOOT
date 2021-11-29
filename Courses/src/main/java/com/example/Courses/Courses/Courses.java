package com.example.Courses.Courses;


import javax.persistence.*;

@Entity
@Table(name = "courses")//you can only write "@Table" and JPA will create the table with the class name
public class Courses {

    @Id
    @GeneratedValue//This is for generate the id automatically by jpa
    private int id;

    @Column(name = "CourseName")//adding this above every attribute will rename the column name
    private String CourseName;
    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", CourseName='" + CourseName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}