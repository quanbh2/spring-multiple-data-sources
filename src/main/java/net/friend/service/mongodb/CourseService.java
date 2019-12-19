package net.friend.service.mongodb;

import net.friend.domain.mongodb.Course;

public interface CourseService {

  Course findById(String id);

}
