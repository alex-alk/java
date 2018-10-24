package com.pack.magazin.factory;

import javax.annotation.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;

@Named
@ApplicationScoped
public class JPAEntityFactoryBean {
	EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("TestApp");
	}
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}

