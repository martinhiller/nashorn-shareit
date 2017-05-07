package de.cas.shareit.nashorn.example4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class Maps {
	
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Robert", "Glaser", 42));
		persons.add(new Person("Britta", "Glatt", 36));
		persons.add(new Person("Werner", "Klein", 51));
		
		Map<String, Person> personsMap = persons.stream()
				.collect(Collectors.toMap(Person::getLastName, Function.identity()));
		engine.put("persons", personsMap);
		
		ExternalScript.eval(engine, Maps.class.getResource("maps.js"));
	}
}
