package com.netease.shopping.exception;

import com.netease.shopping.constant.ReturnFormat;
import com.netease.shopping.constant.StatusCode;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import static com.netease.shopping.constant.StatusCode.*;

/**
 * Created by yuanchuang on 2018-3-31.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandler(RuntimeException runtimeException) {

        return returnFormat(ER100);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView nullPointerExceptionHandler(NullPointerException ex) {
       log.debug(ex.getMessage());
        return returnFormat(ER101);
    }
    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public ModelAndView classCastExceptionHandler(ClassCastException ex) {
        log.debug(ex.getMessage());
        return returnFormat(ER102);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public ModelAndView iOExceptionHandler(IOException ex) {
        log.debug(ex.getMessage());
        return returnFormat(ER103);
    }
    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public ModelAndView noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.debug(ex.getMessage());
        return returnFormat(ER104);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ModelAndView indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        log.debug(ex.getMessage());
        return returnFormat(ER105);
    }
    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ModelAndView requestNotReadable(HttpMessageNotReadableException ex){
        System.out.println("400..requestNotReadable");
        log.debug(ex.getMessage());
        return returnFormat(ER400);
    }
    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public ModelAndView requestTypeMismatch(TypeMismatchException ex){
        System.out.println("400..TypeMismatchException");
        log.debug(ex.getMessage());
        return returnFormat(ER400);
    }
    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ModelAndView requestMissingServletRequest(MissingServletRequestParameterException ex){
        System.out.println("400..MissingServletRequest");
        log.debug(ex.getMessage());
        return returnFormat(ER400);
    }
    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView request405(){
        return returnFormat(ER405);
    }
    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ModelAndView request406(){
        System.out.println("404...");
        return returnFormat(ER406);
    }
    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class,HttpMessageNotWritableException.class})
    public ModelAndView server500(RuntimeException runtimeException){
        return returnFormat(ER500);
    }


    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public ModelAndView uploadSize(){
        return returnFormat(ER106);
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(){
        return returnFormat(ER10);
    }
    private ModelAndView returnFormat(int status){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", StatusCode.messageMap.get(String.valueOf(status)));
        return modelAndView;
    }
}
