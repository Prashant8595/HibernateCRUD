package com.crud.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import com.crud.model.Employee;





public class Employeedao {
	
	private Session session;

	public Employeedao(Session session) {
		
		this.session = session;
	}
	
	public void save(Employee employee) {
		Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
	public Employee findById(int id) {
        return session.get(Employee.class, id);
    }
	
	@SuppressWarnings("deprecation")
	public void update(int id, Employee employee) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee2=session.get(Employee.class, id);
            employee2.setAge(employee.getAge());
            employee2.setDegignation(employee.getDegignation());
            employee2.setEmail(employee.getEmail());
            employee2.setName(employee.getName());
            session.update(employee2);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	public void delete(int id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
           Employee employee= session.get(Employee.class,id);
            session.delete(employee);
            System.out.println("Delete Success fully");
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	
	@SuppressWarnings({ "unchecked", "deprecation" })
    public List < Employee > getAllStudents() {
        Transaction transaction = null;
        List < Employee > students = null;
        try  {
            // start the transaction
            transaction = session.beginTransaction();

            // get students
            students = session.createQuery("from Employee").list();
            //student = session.load(Student.class, id);
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return students;
    }



}
