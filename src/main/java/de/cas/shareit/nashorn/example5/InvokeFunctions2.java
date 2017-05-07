package de.cas.shareit.nashorn.example5;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class InvokeFunctions2 {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Load function "getFullName"
		ExternalScript.eval(engine, InvokeFunctions2.class.getResource("fullname.js"));
		
		// Create argument
		Person person = new Person("Robert", "Glaser", 42);
		
		// Wrap script function into Java interface
		Invocable invocable = (Invocable) engine;
		FullNameRetriever scriptFunction = invocable.getInterface(FullNameRetriever.class);
		
		// Invoke script function and print result
		System.out.println(scriptFunction.getFullName(person));
	}
}
