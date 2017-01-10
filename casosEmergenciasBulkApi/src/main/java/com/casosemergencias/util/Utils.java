package com.casosemergencias.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Utils {
	final static Logger logger = Logger.getLogger(Utils.class);
	
	public static Date parseStringToDate (String dateValue) {
		Date javaDate = null;
		if (!isNullOrEmptyString(dateValue)) {
			String[] dateFormats = {"yyyy-MM-dd\'T\'HH:mm:ss", "yyyy-MM-dd"};
			logger.info("Fecha a modificar: " + dateValue);
			for (String format : dateFormats) {
				try {
					javaDate = new SimpleDateFormat(format).parse(dateValue);
				} catch (ParseException e) {}
			}
		}
		logger.info("Fecha modificada: " + javaDate);
		return javaDate;
	}
	
	public static Boolean parseStringToBoolean (String booleanValue) {
		Boolean javaBoolean = null;
		if (!isNullOrEmptyString(booleanValue)) {
			String booleanStringLowerCase = booleanValue.toLowerCase();
			if ("true".equals(booleanStringLowerCase) || "false".equals(booleanStringLowerCase)) {
				javaBoolean = new Boolean(booleanStringLowerCase);
			}
		}
		logger.info("Valor del boolean: " + javaBoolean);
		return javaBoolean;
	}
	
	public static Integer parseStringToInteger (String integerValue) {
		Integer javaInteger = null;
		if (!isNullOrEmptyString(integerValue)) {
			try {
				javaInteger = Integer.valueOf(integerValue);
			} catch (NumberFormatException e) {}
		}
		logger.info("Valor del boolean: " + javaInteger);
		return javaInteger;
	}
	
	public static boolean isNullOrEmptyString(String value) {
		boolean isNullOrEmptyString = false;
		if (value == null || "".equals(value.trim())) {
			isNullOrEmptyString = true;
		}
		logger.info("String nulo o vacio: " + isNullOrEmptyString);
		return isNullOrEmptyString;
	}
}