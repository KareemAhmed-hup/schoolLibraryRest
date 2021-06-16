package com.publictions.demo.entity.exception;

import java.text.MessageFormat;

public class PublictionNotFoundException extends RuntimeException {

	public PublictionNotFoundException(int id) {
		super(MessageFormat.format("could not find Publiction with id:{0}",id));
	}
	
	

}
