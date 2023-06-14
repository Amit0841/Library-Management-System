package com.masai.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conection {
static EntityManagerFactory emf;
static {
	emf =Persistence.createEntityManagerFactory("connect");
}
  static EntityManager getConnection() {
	 
	return emf.createEntityManager();
}
}
