package com.casosemergencias.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.casosemergencias.model.UserSessionInfo;

public class Utils {
	final static Logger LOGGER = Logger.getLogger(Utils.class);
	
	/**
	 * Parses a date in String to a Java Date object.
	 * 
	 * @param dateValue
	 *            Date in String.
	 * @return Date date parsed as a Java Object.
	 */
	public static Date parseStringToDate (String dateValue) {
		Date javaDate = null;
		DateFormat dateFormat = null;
	    if (!isNullOrEmptyString(dateValue)) {
			String[] dateFormats = {"yyyy-MM-dd\'T\'HH:mm:ss.SSSZ","yyyy-MM-dd\'T\'HH:mm:ss","yyyy-MM-dd"};
			for (String format : dateFormats) {
				try {
					dateFormat = new SimpleDateFormat(format);
					javaDate = dateFormat.parse(dateValue);
					break;
				} catch (ParseException e) {}
			}
	    }
		return javaDate;
	}
	
	/**
	 * Parses a Java Date object to a String object.
	 * 
	 * @param javaDate
	 *            Date object.
	 * @return String Date in String format.
	 */
	public static String parseDateToString (Date javaDate) {
		String dateValue = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		dateValue = dateFormat.format(javaDate);
		return dateValue;
	}
	
	/**
	 * Sets the hour into a Date.
	 * 
	 * @param javaDate
	 *            Date to set the new hour.
	 * @param hours
	 *            Hours to set (0-23).
	 * @param minutes
	 *            Minutes to set (0-59).
	 * @param seconds
	 *            Seconds to set (0-59).
	 * @param milliseconds
	 *            Milliseconds to set (0-999).
	 * @return Date New Date with the new hour setted.
	 */
	public static Date setHourInDate(Date javaDate, int hours, int minutes, int seconds, int milliseconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(javaDate);
		calendar.set(Calendar.MILLISECOND, milliseconds);
		calendar.set(Calendar.SECOND, seconds);
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
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
		return javaInteger;
	}
	
	/**
	 * Parses an double value in String to a Java Double object.
	 * 
	 * @param doubleValue
	 *            Double value in String.
	 * @return Double Double value parsed as a Java Object.
	 */
	public static Double parseStringToDouble (String doubleValue) {
		Double javaDouble = null;
		if (!isNullOrEmptyString(doubleValue)) {
			try {
				javaDouble = Double.valueOf(doubleValue);
			} catch (NumberFormatException e) {}
		}
		return javaDouble;
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
	
	/**
	 * Reads one properties file and builds the UserSessionInfo object with the
	 * user information to login with Salesforce.
	 * 
	 * @return UserSessionInfo User information to login with Salesforce.
	 * @throws IOException
	 *             If it has occurred any problem reading the properties file.
	 */
	public static UserSessionInfo getUserSessionInfoFromProperties() throws IOException {
		Properties properties = new Properties();
		String username = null;
		String password = null;
		String token = null;
		UserSessionInfo userInfoFromProperties = null;
		
		InputStream propsInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/environment/dev/config.properties");
		properties.load(propsInputStream);
		username = properties.getProperty("heroku.user");
		password = properties.getProperty("heroku.pass");
		token = properties.getProperty("heroku.token");
		propsInputStream.close();	
		
		if (username != null && !"".equals(username) && password != null && !"".equals(password) && token != null && !"".equals(token)) {
			userInfoFromProperties = new UserSessionInfo();
			userInfoFromProperties.setUsername(username);
			userInfoFromProperties.setPassword(password);
			userInfoFromProperties.setAccessToken(token);
		}
		return userInfoFromProperties;
	}
	
	/**
	 * Parse one query in String and replace all spaces for '+' symbols to make
	 * a Salesforce Rest API calling.
	 * 
	 * @param stringQuery
	 *            Query in String format.
	 * @return String Query in URL format.
	 */
	public static String parseSqlQueryToUrlQuery(String stringQuery) {
		String urlQuery = null;
		String spaceChar = " ";
		String plusChar = "+";
		urlQuery = stringQuery.replaceAll(spaceChar, plusChar);
		urlQuery = urlQuery.replaceAll("<", "%3C");
		urlQuery = urlQuery.replaceAll(">", "%3E");
		urlQuery = urlQuery.replaceAll("=", "%3D");
		urlQuery = urlQuery.replaceAll("'", "%27");
		urlQuery = urlQuery.replaceAll("-", "%2D");
		urlQuery = urlQuery.replaceAll(":", "%3A");
		return urlQuery;
	}

	/**
	 * Generates and identifier based on the full current date, including time.
	 * 
	 * @return StringBuilder with the format 'yyyyMMddHHmmss'.
	 */
	public static StringBuilder generateDateId() {
		StringBuilder dateIdBuilder = new StringBuilder();
		ZonedDateTime fullCurrentDate = ZonedDateTime.now(ZoneOffset.UTC);
		dateIdBuilder.append(fullCurrentDate.getYear());
		dateIdBuilder.append((fullCurrentDate.getMonthValue() < 10 ? "0" + fullCurrentDate.getMonthValue() : fullCurrentDate.getMonthValue()));
		dateIdBuilder.append((fullCurrentDate.getDayOfMonth() < 10 ? "0" + fullCurrentDate.getDayOfMonth() : fullCurrentDate.getDayOfMonth()));
		dateIdBuilder.append((fullCurrentDate.getDayOfMonth() < 10 ? "0" + fullCurrentDate.getDayOfMonth() : fullCurrentDate.getDayOfMonth()));
		dateIdBuilder.append((fullCurrentDate.getHour() < 10 ? "0" + fullCurrentDate.getHour() : fullCurrentDate.getHour()));
		dateIdBuilder.append((fullCurrentDate.getMinute() < 10 ? "0" + fullCurrentDate.getMinute() : fullCurrentDate.getMinute()));
		dateIdBuilder.append((fullCurrentDate.getSecond() < 10 ? "0" + fullCurrentDate.getSecond() : fullCurrentDate.getSecond()));
		return dateIdBuilder;
	}
}