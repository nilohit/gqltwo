package com.nilohit.gql.gqltwo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.nilohit.gql.gqltwo.models.Orientation;
import com.nilohit.gql.gqltwo.models.SuperCharacter;
import com.nilohit.gql.gqltwo.models.SuperGroup;
import com.nilohit.gql.gqltwo.repos.SuperCharacterRepo;
import com.nilohit.gql.gqltwo.repos.SuperGroupRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mutation implements GraphQLMutationResolver {
	
	private SuperCharacterRepo characterRepo;
	private SuperGroupRepo superGroupRepo;
	
	public Mutation(SuperCharacterRepo repo ,SuperGroupRepo sgr) {
		this.characterRepo = repo;
		this.superGroupRepo = sgr;
		
	}
	
	public SuperCharacter addCharacter(String name, Integer age, String groupName) {
		
		return characterRepo.addCharacter(name, age, groupName);
		
	}
	
public SuperGroup addGroup(String name, Orientation orientation) {
		
		return superGroupRepo.addGroup(name, orientation);
		
	}

}
