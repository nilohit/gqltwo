package com.nilohit.gql.gqltwo.repos;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nilohit.gql.gqltwo.models.SuperCharacter;
import com.nilohit.gql.gqltwo.models.SuperGroup;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SuperCharacterRepo {
	
	private SuperGroupRepo groupRepo;
	
	private List<SuperCharacter> theCharacters = new ArrayList<SuperCharacter>();
	
	
	
	public SuperCharacterRepo(SuperGroupRepo grepo)
	{
		this.groupRepo=grepo;
		seedCharacters();
	}
	private void seedCharacters() {
		
		SuperCharacter c1 = SuperCharacter.builder().id("Char1")
				.name("Super Character1")
				.age(33)
				.build();
		SuperCharacter c2 = SuperCharacter.builder().id("Char2")
				.name("Super Character2")
				.age(99)
				.build();
		this.theCharacters.add(c1);
		this.theCharacters.add(c2);
		
	}
	
	public List<SuperCharacter> getCharacters(){
		return this.theCharacters;
		
		
	}
	
	public SuperCharacter getCharacterById(String id){
		List<SuperCharacter> matched = this.theCharacters.stream().filter(c->c.getId().equalsIgnoreCase(id)).collect(Collectors.toList());
		if(matched.size()> 0)
			return matched.get(0);
		else
			return null;
		
	}
	
	public SuperCharacter addCharacter(String name, Integer age, String groupname){
		SuperGroup sGroup = null;
		if(groupname != null)
			sGroup = groupRepo.getGroupByName(groupname);
		SuperCharacter newchar = SuperCharacter.builder().id("Char"+(this.theCharacters.size()+1)).name(name).age(age).group(sGroup).build();
		log.info("> Mutation.addcharacter("+name+ ")");
		this.theCharacters.add(newchar);
		this.theCharacters.add(newchar);
		
		if(sGroup!=null)sGroup.addCharacter(newchar);
		return newchar;
	}

}
