package com.jsp.hospital.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.hospital.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> getException(IdNotFoundException ex){
		
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("id not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status,WebRequest request){
		
		List<ObjectError> listoferror=ex.getAllErrors();
		Map<String, String>map=new HashMap<String, String>();
		for(ObjectError error:listoferror) {
			String message=error.getDefaultMessage();
			String feildName=((FieldError)error).getField();
			map.put(feildName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
}
