package de.cas.shareit.nashorn.proxy;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import de.cas.shareit.nashorn.common.ExternalScript;

public class JavaProxyExample {
	
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		engine.put("obj", new JavaProxy());
		
		ExternalScript.eval(engine, JavaProxyExample.class.getResource("java-proxy.js"));
	}
}
