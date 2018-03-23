package com.mandiri.util;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DateControllerAdvice {
	
//  @InitBinder
//  public void initBinder(WebDataBinder binder) {
//	  SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
//	  binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
//  }
	
}