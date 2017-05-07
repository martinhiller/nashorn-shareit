package de.cas.shareit.nashorn.common;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class ExternalScript {

	public static Object eval(ScriptEngine engine, URL url) throws IOException, ScriptException {
		try (Reader reader = Resources.asCharSource(url, Charsets.UTF_8).openBufferedStream()) {
			return engine.eval(reader);
		}
	}

}
