package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeletePacManCourseDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create a session

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            //1 -get the pacman course from db
            //2- delete the coourse
            //3- save th courses


            int courseId = 10;
            Course tempCourse = session.get(Course.class,courseId);

            //2- deleet the course
            System.out.println("Deleting the course "+ tempCourse);
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
