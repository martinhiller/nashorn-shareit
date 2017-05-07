package de.cas.shareit.nashorn.example1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;

public class GettingStarted {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Print "Hello World"
		engine.eval("print('Hello World!')");
		
		// Engine remembers its state across eval calls
		engine.eval("var firstName = 'Robert'");
		engine.eval("var lastName = 'Glaser'");
		engine.eval("print('Hello, ' + firstName + ' ' + lastName + '!')");
		
		// Run external script
		ExternalScript.eval(engine, GettingStarted.class.getResource("getting-started.js"));
	}
}
