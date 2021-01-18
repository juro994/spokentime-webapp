package sk.juraj.projects.timetospeech.exception;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { DateTimeParseException.class })
	protected ResponseEntity<ApiError> handleDateTimeParseException(RuntimeException ex, WebRequest request) {
		var apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return new ResponseEntity<ApiError>(apiError, HttpStatus.BAD_REQUEST);
	}
}