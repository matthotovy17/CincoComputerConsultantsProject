package com.cinco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter<T> {
	
	public void toJson(String fileName, Map<String, ?> map) {
		Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
		FileWriter outputFile = null;
		try {
			outputFile = new FileWriter(fileName);
			outputFile.write(gsonBuilder.toJson(map));
			outputFile.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
