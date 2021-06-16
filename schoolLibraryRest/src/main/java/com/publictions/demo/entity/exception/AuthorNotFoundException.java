package com.publictions.demo.entity.exception;

import java.text.MessageFormat;

public class AuthorNotFoundException extends RuntimeException{
	
	public AuthorNotFoundException(int id) {
		super(MessageFormat.format("could not find Author with id:{0}",id));
	}

}
