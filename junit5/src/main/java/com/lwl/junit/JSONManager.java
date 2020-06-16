package com.lwl.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONManager {
	private ObjectMapper om;

	{
		this.om = new ObjectMapper();
	}

	public <T> T LoadGenericJson(Class<T> obj, String filename) throws FileNotFoundException {
		File fs = new File(filename);
		try {
			return om.readValue(fs, obj);
			// JavaType type = om.getTypeFactory().constructParametricType(obj.class, obj);
			// return om.readValue(fs, new TypeReference<T>() {});

		} catch (JsonParseException e1) {
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return null;
	}
}
