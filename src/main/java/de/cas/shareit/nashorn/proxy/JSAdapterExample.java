package de.cas.shareit.nashorn.proxy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;

public class JSAdapterExample {
	
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		ExternalScript.eval(engine, JSAdapterExample.class.getResource("jsadapter.js"));
	}
}
