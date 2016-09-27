package com.app.example.site.rest.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class RestExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    private final MessageSource messageSource;

    @Autowired
    public RestExceptionHandler(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException err)
    {
        ErrorResponse errors = new ErrorResponse();
        Locale currentLocale = LocaleContextHolder.getLocale();
        err.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError ->
                {
                    String errorMessage = messageSource.getMessage(fieldError.getCode(), null, fieldError.getDefaultMessage(), currentLocale);
                    ErrorItem error = new ErrorItem();
                    error.setCode(fieldError.getCode());
                    error.setMessage(errorMessage);
                    errors.addError(error);
                });


        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @SuppressWarnings("unused")
    public static class ErrorItem
    {
        private String code;
        private String message;

        @XmlAttribute
        public String getCode()
        {
            return code;
        }

        public void setCode(String code)
        {
            this.code = code;
        }

        @XmlValue
        public String getMessage()
        {
            return message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }
    }

    @SuppressWarnings("unused")
    @XmlRootElement(name = "errors")
    public static class ErrorResponse
    {
        private List<ErrorItem> errors = new ArrayList<>();

        @XmlElement(name = "error")
        public List<ErrorItem> getErrors()
        {
            return errors;
        }

        public void setErrors(List<ErrorItem> errors)
        {
            this.errors = errors;
        }

        public void addError(ErrorItem error)
        {
            this.errors.add(error);
        }
    }
}
