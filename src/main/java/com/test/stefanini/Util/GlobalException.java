package com.test.stefanini.Util;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.Logger;

@ControllerAdvice
public class GlobalException {
	
	private static final Logger logger = LogManager.getLogger(GlobalException.class);

	
	@ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleRuntimeException(RuntimeException ex) {
		logger.error("A ocurrido un error: ", ex);
    }

}
