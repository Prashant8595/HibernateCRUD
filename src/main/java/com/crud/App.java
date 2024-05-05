package com.crud;

import java.util.Iterator;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.crud.dao.Employeedao;
import com.crud.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Employeedao employeed=new Employeedao(session);
        
        Employee employee=new Employee(1, 24, "Nishant Kumar", "prashant@gmail.com", "SoftwareDeveloper");
       // employeed.save(employee);
//        
       // employeed.delete(4);
       // employeed.update(5, employee);
        
        List<Employee> employees=employeed.getAllStudents();
        for(Employee e: employees) {
            System.out.println(e);
        }
        
        
    }
}
