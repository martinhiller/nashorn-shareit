package de.cas.shareit.nashorn.example5;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class InvokeFunctions {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Load function "getFullName"
		ExternalScript.eval(engine, InvokeFunctions.class.getResource("fullname.js"));
		
		// Create argument
		Person person = new Person("Robert", "Glaser", 42);
		
		// Invoke script function and print result
		Invocable invocable = (Invocable) engine;
		System.out.println(invocable.invokeFunction("getFullName", person));
	}
}
