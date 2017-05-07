package de.cas.shareit.nashorn.example8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptIsolation {
	
	public static void main(String[] args) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		// No isolation: eval calls operate on the same global JavaScript context
		engine.eval("var foo = 'bar'");
		engine.eval("print(typeof foo == 'undefined' ? 'foo is undefined' : 'foo exists')");
		
		// New Bindings for every eval call
		engine.eval("var foo = 'bar'", engine.createBindings());
		engine.eval("print(typeof foo == 'undefined' ? 'foo is undefined' : 'foo exists')", engine.createBindings());
	}
}
