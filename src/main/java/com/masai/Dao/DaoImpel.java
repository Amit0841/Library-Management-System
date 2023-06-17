package com.masai.Dao;



import java.time.LocalDate;
import java.util.List;

import org.hibernate.tool.schema.spi.SqlScriptException;

import com.masai.Dto.Book;
import com.masai.Dto.Feedback;
import com.masai.Dto.Librarian;
import com.masai.Dto.RentBooks;
import com.masai.Dto.Student;
import com.masai.Exception.NoRecordFound;
import com.masai.Exception.SomethingWentWrong;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

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
			}else {
				 throw new NoRecordFound("No Record Found");
			}
		}catch(SqlScriptException | NoResultException k) {
			 throw new NoRecordFound("No Record Found");
		}
		finally {
			em.close();
		}
		return id;
	}

	@Override
	public void addBook(String bid, String bookOTitle, String author, double price, int id) throws SomethingWentWrong {
		EntityManager em=null;
		
		try {
			em=Conection.getConnection();
			Librarian l=em.find(Librarian.class, id);
			Book bo=new Book(bid,bookOTitle,author,price,true, l);

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

	@Override
	public void upateRent(double price,String Bid) throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		
		try {
			em=Conection.getConnection();
            EntityTransaction et=em.getTransaction();
          Book b= em.find(Book.class,Bid);
           if(b!=null) {
        	  et.begin();
        	  b.setRentPrice(price);
        	  et.commit();
           }else {
        	   throw new NoRecordFound("No Record Found");
           }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public void removeBook(String bid) throws SomethingWentWrong, NoRecordFound {
	EntityManager em=null;
		
		try {
			em=Conection.getConnection();
            EntityTransaction et=em.getTransaction();
          Book b= em.find(Book.class,bid);
          if(b!=null) {
           et.begin();
           em.remove(b);
           et.commit();
           }else {
        	   throw new NoRecordFound("No Record Found");
           }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
	}

	@Override
	public List<Book> viewBook() throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		List<Book> book=null;
		try {
			em=Conection.getConnection();
           String q="select e from Book e";
          Query que=em.createQuery(q);
         book=que.getResultList();
         
          if(book==null) {
	      throw new NoRecordFound("No Record Found");
          }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public List<Book> viewAvailableBook() throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		List<Book> book=null;
		try {
			em=Conection.getConnection();
           String q="select e from Book e where availability =:a";
          Query que=em.createQuery(q);
          que.setParameter("a", true);
         book=que.getResultList();
         
          if(book==null) {
	      throw new NoRecordFound("No Record Found");
          }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public List<Book> viewBookByName(String name) throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		List<Book> book=null;
		try {
			em=Conection.getConnection();
           String q="select e from Book e where availability =:a and bookTitle like :name";
          Query que=em.createQuery(q);
          que.setParameter("a", true);
          que.setParameter("name","%"+ name+"%");
         book=que.getResultList();
         
          if(book==null) {
	      throw new NoRecordFound("No Record Found");
          }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public List<Book> viewBookByAuthorName(String name) throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		List<Book> book=null;
		try {
			em=Conection.getConnection();
           String q="select e from Book e where availability =:a and author like :name";
          Query que=em.createQuery(q);
          que.setParameter("a", true);
          que.setParameter("name","%"+ name+"%");
         book=que.getResultList();
         
          if(book==null) {
	      throw new NoRecordFound("No Record Found");
          }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public List<Book> viewBookDesc() throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		List<Book> book=null;
		try {
			em=Conection.getConnection();
           String q="select e from Book e where availability =:a order by bookTitle desc";
          Query que=em.createQuery(q);
          que.setParameter("a", true);
        
         book=que.getResultList();
         
          if(book==null) {
	      throw new NoRecordFound("No Record Found");
          }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public List<Book> viewBookAsc() throws SomethingWentWrong, NoRecordFound {
		EntityManager em=null;
		List<Book> book=null;
		try {
			em=Conection.getConnection();
           String q="select e from Book e where availability =:a order by bookTitle asc";
          Query que=em.createQuery(q);
          que.setParameter("a", true);
          
         book=que.getResultList();
         
          if(book==null) {
	      throw new NoRecordFound("No Record Found");
          }
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public void rentBook(String bookId, LocalDate da, LocalDate date, int id) throws SomethingWentWrong, NoRecordFound {
EntityManager em=null;
		
		try {
			em=Conection.getConnection();
			
			Student l=em.find(Student.class, id);
			Book b=em.find(Book.class, bookId);
			
       if(b!=null && b.getAvailability()) {
    	    RentBooks rb=new RentBooks(b,da,date,l);
	        EntityTransaction et=em.getTransaction();
            et.begin();
            b.setAvailability(false);
            em.persist(rb);
            et.commit();
         }else {
        	 throw new NoRecordFound("No Record Found"); 
         }
            
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public List<Feedback> viewBookq() throws SomethingWentWrong, NoRecordFound {
    EntityManager em=null;
    List <Feedback> list=null;
		try {
			em=Conection.getConnection();
			String q="select e from Feedback e";
			Query que=em.createQuery(q);
			list=que.getResultList();
            
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return list;
	}

	@Override
	public void giveF(String bId, String massage, double rating) throws SomethingWentWrong, NoRecordFound {
		   EntityManager em=null;
			
			try {
				em=Conection.getConnection();
				Book b=em.find(Book.class, bId);
				if(b!=null) {
					Feedback rb=new Feedback(massage,rating,b);
				EntityTransaction et=em.getTransaction();
				et.begin();
				em.persist(rb);
				et.commit();
				}else {
					throw new NoRecordFound("No Record Found");
				}
				
			}catch(SqlScriptException e) {
				throw new SomethingWentWrong("Something Went Wrong");
			}
			finally {
				em.close();
			}
		
	}

	@Override
	public List<RentBooks> getBook(int id) throws SomethingWentWrong, NoRecordFound {
		
		 EntityManager em=null;
		 List<RentBooks> book=null;
		try {
			em=Conection.getConnection();
			Student s=em.find(Student.class, id);
			String q="select e from RentBooks e where Sid =:id1";
			Query que=em.createQuery(q);
			que.setParameter("id1", s);
			book=que.getResultList();
            
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		return book;
	}

	@Override
	public void returnBook(String bId) throws SomethingWentWrong, NoRecordFound {
		 EntityManager em=null;
		try {
			em=Conection.getConnection();
			EntityTransaction et=em.getTransaction();
			Book b=em.find(Book.class, bId);
			if(b!=null) {
				String q="delete from RentBooks where bi =:id";
				Query que=em.createQuery(q);
				que.setParameter("id", b);
				et.begin();
				b.setAvailability(true);
				int deletedCount = que.executeUpdate();
				System.out.println("Your Payment Amount Is "+b.getRentPrice());
				et.commit();
			}else {
				throw new NoRecordFound("No Record Found ");
			}
		}catch(SqlScriptException e) {
			throw new SomethingWentWrong("Something Went Wrong");
		}
		finally {
			em.close();
		}
		
		
	}


}
