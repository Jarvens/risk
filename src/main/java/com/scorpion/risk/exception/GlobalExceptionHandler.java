package com.scorpion.risk.exception;

import com.scorpion.risk.result.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


/**
 * Created on 2017/9/16.
 */
public class GlobalExceptionHandler {

    final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private BaseResult bindException(BindException E) {

        List<ObjectError> list = E.getAllErrors();

        String error = "";

        for (ObjectError objectError : list) {
            FieldError fieldError = (FieldError) objectError;

            error += fieldError.getField() + "***" + fieldError.getDefaultMessage() + "|";
        }

        logger.error("参数校验****" + error);

        return BaseResult.error("0002", error);
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private BaseResult exceptionHandler(Exception e) {
        logger.error("系统出错******", e);
        return BaseResult.systemError();
    }
}
