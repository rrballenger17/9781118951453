package com.example;

import java.lang.annotation.*;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DBParams {
	
    String dbName();
	String uid();
	String password();
	
}



