package io.javabrains.courseapidata.course;


import io.javabrains.courseapidata.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/topics/{topicId}/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(@PathVariable("topicId") String topicId){
        return courseService.getAllCourses(topicId);
    }

    @GetMapping(path = "{id}")
    public Optional<Course> getCourse(@PathVariable("id") String id){
        return courseService.getCourse(id);
    }

    @PostMapping
    public void addCourse(@RequestBody Course course,
                          @PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@RequestBody Course course,
                             @PathVariable("topicId") String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}