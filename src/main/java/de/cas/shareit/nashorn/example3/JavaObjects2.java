package de.cas.shareit.nashorn.example3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;

public class JavaObjects2 {

	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		ExternalScript.eval(engine, JavaObjects2.class.getResource("java-objects2.js"));
		
		System.out.println(engine.get("person"));
	}
}
