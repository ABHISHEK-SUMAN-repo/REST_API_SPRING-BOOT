package com.example.Courses.Services;

import com.example.Courses.Courses.Courses;
import com.example.Courses.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {


    @Autowired
    private CourseRepository courseRepository;

    public Courses createCourse(Courses course)
    {
        return  courseRepository.save(course);
    }

    public List<Courses> createCourseList(List<Courses> list)
    {
        return courseRepository.saveAll(list);
    }

    public List<Courses>  getCourseList(){
        return  courseRepository.findAll();
    }
    public  Courses getCourseById(int id){
        return courseRepository.findById(id).orElse(null);
    }
    public  Courses updateCourseById(Courses course)
    {
     Optional<Courses> courseFound= courseRepository.findById(course.getId());

     if(courseFound.isPresent()){
         Courses courseUpdate = courseFound.get();
         courseUpdate.setCourseName(course.getCourseName());
         courseUpdate.setDescription(course.getDescription());
          return  courseRepository.save(course);
     }
     else{
         return  null;
     }

    }

    public  String  deleteCourseById(int id)
    {
        courseRepository.deleteById(id);
        return "Courses"+id+"deleted";
    }
}