package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.Course;
import com.ali.hibernate.demo.entity.Instructor;
import com.ali.hibernate.demo.entity.InstructorDetail;
import com.ali.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

        // Create a session

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            //1-create a course
            //2- add some reviews
            //3- save the course ... and leverage the cascade class


            Course tempCourse = new Course("Pacman how to score one million point");
            tempCourse.addReview(new Review("Great course love it"));
            tempCourse.addReview(new Review("Good luck man it is pretty nice"));
            tempCourse.addReview(new Review("Fuck your shirt man"));
            tempCourse.addReview(new Review("It is a nice course"));

            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);


            session.getTransaction().commit();
            System.out.println("The job is successfully  done");

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
