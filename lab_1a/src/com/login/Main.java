package com.login;

public class Main {
	
	    public static void main(String[] args) {
	       
	        loginpage Logger = loginpage.getInstance();

	        
	        Logger.log("Application started :).");
	        Logger.log("User logged in.");
	        Logger.log("Error: Unable to connect to the database.");

	        
	    loginpage anotherLogger = loginpage.getInstance();

	       	        anotherLogger.log("This is logged using another reference to the same Logger instance.");

	        
	        if (Logger == anotherLogger) {
	            System.out.println("Both logger instances are the same.");
	        } else {
	            System.out.println("Logger instances are different.");
	        }
	    }
	}


