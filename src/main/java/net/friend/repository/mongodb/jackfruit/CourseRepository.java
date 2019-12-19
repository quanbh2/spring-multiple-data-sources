package net.friend.repository.mongodb.jackfruit;

import net.friend.domain.mongodb.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

}
