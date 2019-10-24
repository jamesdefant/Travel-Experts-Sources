package service;

import java.lang.reflect.Type;

import com.google.gson.Gson;

import dbAccess.AgentDb;

public class GenericREST {

	
	public static <T> String getJson(T obj, Type type) {
		

		  Gson gson = new Gson();
		  return gson.toJson(obj, type);
		
	}
	
//	public static <T> Object getObject(String jsonString, Type type) {
//		
//		  Gson gson = new Gson();
//		  return gson.fromJson(jsonString, type);
//	}
	
	public static String getMsg(String tableName, String methodName, int rows) {
		
		  String msg = "";		 
		  
		  if(rows <= 0) {
			  msg = tableName + " " + methodName + " failed";
		  } else if(rows == 1) {
			  msg = tableName + " " + methodName + " successful";
		  }
	    
		  msg += " - # of rows affected: " + rows;
		  return msg;
	}
	
}
