package com.masai.Dao;


import org.hibernate.tool.schema.spi.SqlScriptException;

import com.masai.Dto.Book;
import com.masai.Dto.Librarian;
import com.masai.Dto.Student;
import com.masai.Exception.NoRecordFound;
import com.masai.Exception.SomethingWentWrong;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class DaoImpel implements DaoInterface{

	@Override
	public void add(Librarian l) throws SomethingWentWrong {
		EntityManager em=Conection.getConnection();
		EntityTransaction et=em.getTransaction();
		
		try {
		et.begin();
		em.persist(l);
		et.commit();
		}catch(SqlScriptException k) {
			 throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
	}

	@Override
	public void addStu(Student s) throws SomethingWentWrong {
		EntityManager em = Conection.getConnection();
		EntityTransaction et = em.getTransaction();
		try {
		et.begin();
		em.persist(s);
		et.commit();
		}catch(SqlScriptException k) {
			 throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
	}

	@Override
	public int loginStu(String email, String pass) throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		int id = 0;
		try {
			em=Conection.getConnection();
			String Q="select e from Student e where email =:email and pass=:pass";
			Query query = em.createQuery(Q);
			query.setParameter("email", email);
			query.setParameter("pass", pass);
			
			Student s=(Student) query.getSingleResult();
			if(s!=null) {
				id=s.getStudentId();
			}else {
				throw new SomethingWentWrong("No Record Found");
			}
		}catch(SomethingWentWrong | NoResultException k) {
			System.out.println(k);
			 throw new NoRecordFound("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return id;
	}

	@Override
	public int loginLibrarian(String email, String pass) throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		int id = 0;
		try {
			em=Conection.getConnection();
			String Q="select e from Librarian e where email =:email and pass=:pass";
			Query query = em.createQuery(Q);
			query.setParameter("email", email);
			query.setParameter("pass", pass);
			
			Librarian s=(Librarian) query.getSingleResult();
			if(s!=null) {
				id=s.getLibrarianId();
			}
		}catch(SqlScriptException k) {
			 throw new NoRecordFound("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return id;
	}

	@Override
	public void addBook(Book bo) throws SomethingWentWrong {
		EntityManager em=null;
		int id = 0;
		try {
			em=Conection.getConnection();
            EntityTransaction et=em.getTransaction();
            et.begin();
            em.persist(bo);
            et.commit();
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		
	}
}
