package com.example.Courses.Repository;

import com.example.Courses.Courses.Courses;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Courses, Integer> {
}
