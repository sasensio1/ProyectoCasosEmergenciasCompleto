package com.casosemergencias.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class Utils {
	final static Logger logger = Logger.getLogger(Utils.class);
	
	/**
	 * Parses a date in String to a Java Date object.
	 * 
	 * @param dateValue
	 *            Date in String.
	 * @return Date date parsed as a Java Object.
	 */
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
	
	/**
	 * Parses a boolean value in String to a Java Boolean object.
	 * 
	 * @param booleanValue
	 *            Boolean value in String.
	 * @return Boolean boolean value parsed as a Java Object.
	 */
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
	
	/**
	 * Parses an integer value in String to a Java Integer object.
	 * 
	 * @param integerValue
	 *            Integer value in String.
	 * @return Integer integer value parsed as a Java Object.
	 */
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
	
	/**
	 * Checks if a String is null or has an empty value.
	 * 
	 * @param stringValue
	 *            Value to String.
	 * @return boolean True if the String is null or has an empty value. False
	 *         otherwise.
	 */
	public static boolean isNullOrEmptyString(String stringValue) {
		boolean isNullOrEmptyString = false;
		if (stringValue == null || "".equals(stringValue.trim())) {
			isNullOrEmptyString = true;
		}
		logger.info("String nulo o vacio: " + isNullOrEmptyString);
		return isNullOrEmptyString;
	}
	
	/**
	 * Substracts a given number of days to a Date.
	 * 
	 * @param date
	 *            Date to which days are to be subtracted.
	 * @param daysToSubstract
	 *            Days to substract to the date.
	 * @return Date date obtained after the substraction.
	 */
	public static Date substractDaysToDate(Date date, int daysToSubstract) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -(daysToSubstract));
		return calendar.getTime();
	}
}