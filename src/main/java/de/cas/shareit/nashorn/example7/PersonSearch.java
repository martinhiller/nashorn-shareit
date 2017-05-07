package de.cas.shareit.nashorn.example7;

import java.util.List;

import de.cas.shareit.nashorn.common.Person;

public interface PersonSearch {
	
	List<Person> filter(List<Person> persons, String keyword);

}
