package com.nilohit.gql.gqltwo.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nilohit.gql.gqltwo.models.Orientation;
import com.nilohit.gql.gqltwo.models.SuperGroup;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SuperGroupRepo {
	
	private List<SuperGroup> theGroups = new ArrayList<>();
	public SuperGroupRepo() {seedGroups();}
	
	public void seedGroups() {
		SuperGroup g1 = SuperGroup.builder().name("Bad guys").orientation(Orientation.VILLIAN).build();
		this.theGroups.add(g1);
	}
	
	public List<SuperGroup> getGroups(){ return this.theGroups; }
	public SuperGroup addGroup(String name, Orientation orientation) {
		SuperGroup newGroup = SuperGroup.builder().name(name).orientation(orientation).build();
		this.theGroups.add(newGroup);
		return newGroup;
	}

	public SuperGroup getGroupByName(String name) {
		// TODO Auto-generated method stub
		List<SuperGroup> sg = 
				this.theGroups.stream().filter(g-> g.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if(sg.size() >0)
			return sg.get(0);
		return null;
	}
}
