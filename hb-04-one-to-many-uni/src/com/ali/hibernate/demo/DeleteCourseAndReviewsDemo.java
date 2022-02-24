package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.Course;
import com.ali.hibernate.demo.entity.Instructor;
import com.ali.hibernate.demo.entity.InstructorDetail;
import com.ali.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // Create a session

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();


            //1-get the course
            //2-print the course
            //3-print the reviews
            //4-delete the course


            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());


            session.delete(tempCourse);

            session.getTransaction().commit();
            System.out.println("The job is successfully  done");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //handle connection leak issue
            session.close();
            factory.close();
        }
    }
}
