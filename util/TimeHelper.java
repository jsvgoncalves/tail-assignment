package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeHelper {
	
	/**
	 * Returns the minutes since Epoch.
	 * @param year
	 * @param month
	 * @param day
	 * @param hours
	 * @param minutes
	 * @return Time in minutes since Epoch
	 * @throws ParseException 
	 */
	public static int getMinutes(int year, int month, int day, int hour, int minute) throws ParseException{
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day, hour, minute);
		long timeInMillisSinceEpoch = cal.getTimeInMillis();
		return safeLongToInt(TimeUnit.MILLISECONDS.toMinutes(timeInMillisSinceEpoch));
	}
	
	/**
	 * Converts a formated timestamp to the number of minutes since the Epoch. 
	 * @param timestamp Format: "yyyy-MM-dd hh:mm"
	 * @return Time in minutes since Epoch
	 * @throws ParseException
	 */
	public static int getMinutes(String timestamp) throws ParseException{
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Date date = sdf.parse(timestamp);
		long timeInMillisSinceEpoch = date.getTime();
		return safeLongToInt(TimeUnit.MILLISECONDS.toMinutes(timeInMillisSinceEpoch));
	}
	
	private static int safeLongToInt(long l) {
	    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
	        throw new IllegalArgumentException
	            (l + " cannot be cast to int without changing its value.");
	    }
	    return (int) l;
	}
}
