package com.Practice.RatingService.ControllerLayer;

import org.springframework.http.HttpStatus;
import com.Practice.RatingService.Exception.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Practice.RatingService.Exception.MovieNotFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	public static class Error{
		private final String reason;
		private final String message;
		
		// getter methods for ResponseBody
		public String getReason() {
			return reason;
		}
		public String getMessage() {
			return message;
		}

        // Constructor to initialize final fields
        public Error(String reason, String message) {
            this.reason = reason;
            this.message = message;
        }
		
	}
	
	
	// handle -> 404 Data From DB Not Found Error
		@ExceptionHandler(MovieNotFoundException.class)
		@ResponseBody
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public Error handleMovieNotFoundException(MovieNotFoundException ex) {
			log.warn(ex.getMessage());
			return new Error(HttpStatus.NOT_FOUND.getReasonPhrase(),ex.getMessage());
		}
	
		@ExceptionHandler(Exception.class)
		@ResponseBody
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		public Error handleUnknownException(Exception ex) {
			log.error(ex.getMessage());
			return new Error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),ex.getMessage());
		}
}
