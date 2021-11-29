package com.example.Courses.Controller;

import com.example.Courses.Courses.Courses;

import com.example.Courses.Services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private CourseServices services;

    @GetMapping("courses")
    public List<Courses> getAllCourses(@PathVariable int id) {
        return (List<Courses>) services.getCourseById(id);
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<Courses> getUserById(@PathVariable int id) {
        return (ResponseEntity<Courses>) ResponseEntity.ok().body(this.services.getCourseById(id));
    }

    @PostMapping("addC")
    public ResponseEntity<Courses> addUser(@RequestBody Courses course) {
        return ResponseEntity.ok(this.services.createCourse(course));
    }

    @PostMapping("addCourses")
    public ResponseEntity<List<Courses>> addUsers(@RequestBody List<Courses> list) {
        return ResponseEntity.ok(this.services.createCourseList(list));
    }

    @PutMapping("updateCourses/")
    public ResponseEntity updateUser(@RequestBody Courses course) {
        return ResponseEntity.ok().body(this.services.updateCourseById(course));
    }

    @DeleteMapping("deleteCourses/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        this.services.deleteCourseById(id);
        return HttpStatus.OK;
    }
}
