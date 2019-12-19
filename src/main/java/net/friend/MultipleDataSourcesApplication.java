package net.friend;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.friend.domain.mongodb.Course;
import net.friend.domain.mongodb.Libraries;
import net.friend.domain.mysql.bifrost.Buyer;
import net.friend.domain.mysql.epayment.EdmContact;
import net.friend.service.mongodb.CourseService;
import net.friend.service.mongodb.LibrariesService;
import net.friend.service.mysql.BifrostService;
import net.friend.service.mysql.EpaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MultipleDataSourcesApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(MultipleDataSourcesApplication.class, args);
  }

  @Autowired
  EpaymentService epaymentService;

  @Autowired
  BifrostService bifrostService;

  @Autowired
  CourseService courseService;

  @Autowired
  LibrariesService librariesService;

  @Override
  public void run(String... args) throws Exception {
    log.info("... Starting ...");

    // test connect to Epayment DB ( Mysql )
    EdmContact edmContact = epaymentService.findContactById(1);
    log.info("contact: {}", edmContact);

    // test connect to Bifrost DB ( Mysql )
    Buyer buyer = bifrostService.findBuyerById(4);
    log.info(" buyer by ID : {}", buyer);

    List<Buyer> buyers = bifrostService.getListRandomBuyer(3);
    log.info(" list random buyers: {}", buyers);

    // test connect to Jacfruit DB ( MongoDB )
    Course course = courseService.findById("5732a71f5cdb873e0d70a8f6");
    log.info(" course by ID : {}", course);

    // test connect to Kelly DB ( MongoDB )
    Libraries libraries = librariesService.findByKey("library-kelley-10-09-2016-jackie.panom.01_10-9/vl23.mp4");
    log.info(" libraries by key : {}", libraries);


  }
}
