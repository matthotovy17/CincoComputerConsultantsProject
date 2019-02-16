//package com.cinco;
//
//public class JsonConverter {
//	
//	// TODO: Converting Map to prettyPrinting JSON format
//	public void toJson() {
//		// parameterize the toJson method
//		Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
//		FileWriter outputFile = null;
//		try {
//			outputFile = new FileWriter("data/Persons.json");
//			outputFile.write(gsonBuilder.toJson());
//			// TODO: pass in Map to toJson function
//			outputFile.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//	}
//}
