package com.nilohit.gql.gqltwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nilohit.gql.gqltwo.repos.SuperCharacterRepo;
import com.nilohit.gql.gqltwo.repos.SuperGroupRepo;
import com.nilohit.gql.gqltwo.resolvers.Mutation;
import com.nilohit.gql.gqltwo.resolvers.Query;

@SpringBootApplication
public class GqltwoApplication {

	@Autowired
	SuperCharacterRepo superCharacterRepo;
	
	@Autowired
	SuperGroupRepo superGroupRepo;
	
	@Bean
	public Query query() {
		
		return new Query(superCharacterRepo, superGroupRepo);
	}
	
	@Bean
	public Mutation mutation() {
		
		return new Mutation(superCharacterRepo, superGroupRepo);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(GqltwoApplication.class, args);
	}

}
