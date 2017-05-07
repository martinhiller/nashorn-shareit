package de.cas.shareit.nashorn.example2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;

public class PrimitiveValues1 {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// Put primitive Java values into engine
		engine.put("name", "Robert");
		engine.put("age", 42.34);
		engine.put("male", true);
		
		// Access the values in script
		ExternalScript.eval(engine, PrimitiveValues1.class.getResource("primitives.js"));
	}
}
