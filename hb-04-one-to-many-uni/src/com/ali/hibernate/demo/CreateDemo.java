package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.Course;
import com.ali.hibernate.demo.entity.Instructor;
import com.ali.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // Create a session

        Session session = factory.getCurrentSession();

        try {


            //1- create  the object
            Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@udemy.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/325644", "Football");

            //Assosiate the object
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // create a transaction
            session.beginTransaction();

            // save the instructor
            /**
             * this will also save the detail object
             * because of cascadetype.all
             */
            System.out.println("Saving instructor"+ tempInstructor);
            session.save(tempInstructor);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("The job is successfully  done");

        } finally {

            session.close();
            factory.close();
        }
    }
}
