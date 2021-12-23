package com.harman.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harman.Exception.EmployeeNotFoundException;
import com.harman.Exception.IdAlreadyExistsException;
import com.harman.dto.ErrorMsg;

//global Exception Handling


@RestControllerAdvice
public class EmpExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMsg handleEmpNotFoundException(EmployeeNotFoundException ex) {
		return new ErrorMsg(ex.getMessage(), HttpStatus.NOT_FOUND.toString());
	}
	
	@ExceptionHandler(IdAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMsg handleIDAlreadyExists(IdAlreadyExistsException ex) {
		return new ErrorMsg(ex.getMessage(), HttpStatus.BAD_REQUEST.toString());
	}
	
}
