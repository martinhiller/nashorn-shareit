package de.cas.shareit.nashorn.example7;

import java.util.ArrayList;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class StreamExample {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Prepare person list
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Robert", "Glaser", 42));
		persons.add(new Person("Britta", "Glatt", 36));
		persons.add(new Person("Werner", "Klein", 51));
		
		// Load script
		ExternalScript.eval(engine, StreamExample.class.getResource("stream.js"));
		Invocable invocable = (Invocable) engine;
		PersonSearch personSearch = invocable.getInterface(PersonSearch.class);
		
		// Call and output
		System.out.println("Search result:");
		personSearch.filter(persons, "gla").forEach(System.out::println);
	}
}
