package de.cas.shareit.nashorn.example2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class PrimitiveValues2 {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Define values in script
		engine.eval("var name = 'Robert'");
		engine.eval("var age = 42.4");
		engine.eval("var male = true");
		
		// Access them in Java
		printVarInfo("name", engine.get("name"));
		printVarInfo("age", engine.get("age"));
		printVarInfo("male", engine.get("male"));
	}
	
	private static void printVarInfo(String name, Object value) {
		System.out.println(String.format("%s: %s (%s)", name, value, value.getClass().getName()));
	}
}
