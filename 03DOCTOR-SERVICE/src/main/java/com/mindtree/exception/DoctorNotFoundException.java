//DoctorNotFoundException.java
package com.mindtree.exception;

public class DoctorNotFoundException extends RuntimeException{

	public DoctorNotFoundException() {
		super();
	}
	
	public DoctorNotFoundException(String msg) {
		super(msg);
	}
}
