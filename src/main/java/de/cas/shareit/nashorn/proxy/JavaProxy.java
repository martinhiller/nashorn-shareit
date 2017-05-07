package de.cas.shareit.nashorn.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jdk.nashorn.api.scripting.AbstractJSObject;

@SuppressWarnings("restriction")
public class JavaProxy extends AbstractJSObject {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaProxy.class);
	
	@Override
	public Object call(Object thiz, Object... args) {
		LOGGER.info("Proxy called with args: {}", (Object) args);
		return null;
	}
	
	@Override
	public Object newObject(Object... args) {
		LOGGER.info("Called as constructor with args: {}", (Object) args);
		return null;
	}
	
	@Override
	public boolean hasMember(String name) {
		LOGGER.info("hasMember({})", name);
		return false;
	}
	
	@Override
	public Object getMember(String name) {
		LOGGER.info("getMember({})", name);
		return null;
	}
	
	@Override
	public void setMember(String name, Object value) {
		LOGGER.info("setMember({}, {})", name, value);
	}
	
	@Override
	public Object getSlot(int index) {
		LOGGER.info("getSlot({})", index);
		return null;
	}
	
	@Override
	public void setSlot(int index, Object value) {
		LOGGER.info("setSlot({}, {})", index, value);
	}
	
}
