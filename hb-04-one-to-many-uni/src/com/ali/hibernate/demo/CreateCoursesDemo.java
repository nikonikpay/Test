package com.ali.hibernate.demo;

import com.ali.hibernate.demo.entity.Course;
import com.ali.hibernate.demo.entity.Instructor;
import com.ali.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        // Create a session

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            // 1-get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            //2- create some courses
            Course tempCourse1 = new Course("Air Guitar - The Ultimate guild");
            Course tempCourse2 = new Course("The Pinball Master Class");

            //3- add courses to instructor
            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            //4-save the courses
            session.save(tempCourse1);
            session.save(tempCourse2);


            //commit transaction
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
