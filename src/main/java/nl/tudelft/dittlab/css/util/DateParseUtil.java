package nl.tudelft.dittlab.css.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParseUtil {
	
public static Date stringParamToDate(String date) {
		
		Date result = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {

			result = df.parse(date);

		} catch (ParseException e) {
			System.out.println("String to date parse exception.");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static Date stringParamsToDate(String datestring, String timestring) {
		
		Date result = null;
		String combinedDate = datestring + " " + timestring;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy h:mmaa");
		
		try {

			result = df.parse(combinedDate);

		} catch (ParseException e) {
			System.out.println("String to date parse exception.");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public static String dateToDayString(Date date) {
		
		String result = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		result = df.format(date);
		
		return result;
		
	}
	
	public static String dateToTimeString(Date date) {
		
		String result = null;
		DateFormat df = new SimpleDateFormat("h:mmaa");
		
		result = df.format(date);
		
		return result;
		
	}

}
