package de.cas.shareit.nashorn.example3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class JavaObjects1 {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		Person person = new Person("Robert", "Glaser", 42);
		engine.put("person", person);
		
		ExternalScript.eval(engine, JavaObjects1.class.getResource("java-objects1.js"));
	}
}
