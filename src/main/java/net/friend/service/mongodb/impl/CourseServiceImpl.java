package net.friend.service.mongodb.impl;

import net.friend.domain.mongodb.Course;
import net.friend.repository.mongodb.jackfruit.CourseRepository;
import net.friend.service.mongodb.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Override
  public Course findById(String id) {
    return courseRepository.findById(id).orElse(new Course());
  }
}
