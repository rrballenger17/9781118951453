package com.example;

import java.lang.reflect.*;

public class DBParamProcessor{

	public static void main(String[] args) {

		String classWithAnnotation = "com.example.MyDBWorker";
     
		try {

			Class loadedClass = Class.forName(classWithAnnotation);
       
			if (loadedClass.isAnnotationPresent(DBParams.class)){
				DBParams annotation = (DBParams) loadedClass.getAnnotation(DBParams.class);
				System.out.println("Class: " + loadedClass.getName() + 
						". \nParameters of DBParams are: " +
						"\n database="+ annotation.dbName() +
						",\n username="+ annotation.uid() +
						",\n password="+
						annotation.password());
			}
       
		}catch (ClassNotFoundException e) {
                  e.printStackTrace();
		} 
     
	}
}
