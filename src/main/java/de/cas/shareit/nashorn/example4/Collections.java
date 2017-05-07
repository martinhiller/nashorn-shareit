package de.cas.shareit.nashorn.example4;

import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class Collections {
	
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Robert", "Glaser", 42));
		persons.add(new Person("Britta", "Glatt", 36));
		persons.add(new Person("Werner", "Klein", 51));
		engine.put("persons", persons);
		
		ExternalScript.eval(engine, Collections.class.getResource("collections.js"));
	}
}
