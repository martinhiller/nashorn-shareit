package de.cas.shareit.nashorn.example6;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;
import de.cas.shareit.nashorn.common.Person;

public class ImplementInterfaces {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Load function "greetLater"
		ExternalScript.eval(engine, ImplementInterfaces.class.getResource("greeter.js"));
		
		// Wrap into Java interface
		Invocable invocable = (Invocable) engine;
		Greeter greeter = invocable.getInterface(Greeter.class);
		
		// Get Runnable from script
		Runnable greetRunnable = greeter.greetLater(new Person("Robert", "Glaser", 42));
		
		// Call returned Runnable
		greetRunnable.run();
	}
}
