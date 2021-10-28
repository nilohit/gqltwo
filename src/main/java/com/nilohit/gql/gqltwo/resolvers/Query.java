package com.nilohit.gql.gqltwo.resolvers;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nilohit.gql.gqltwo.models.SuperCharacter;
import com.nilohit.gql.gqltwo.models.SuperGroup;
import com.nilohit.gql.gqltwo.repos.SuperCharacterRepo;
import com.nilohit.gql.gqltwo.repos.SuperGroupRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Query implements GraphQLQueryResolver{
	
	private SuperCharacterRepo superCharacterRepo;
	private SuperGroupRepo superGroupRepo;
	
	public Query(SuperCharacterRepo repo, SuperGroupRepo groupRepo) {
		
		this.superCharacterRepo=repo;
		this.superGroupRepo = groupRepo;
	}
	public List<SuperCharacter> characters(){
		return superCharacterRepo.getCharacters();
		
		
	}
	public SuperCharacter characterById(String id){
		return superCharacterRepo.getCharacterById(id);
		
		
	}
	
	public List<SuperGroup> groups(){
		return superGroupRepo.getGroups();
		
		
	}
	
	public SuperGroup getGroupByName(String name){
		return superGroupRepo.getGroupByName(name);
		
		
	}

}
