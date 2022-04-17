package com.coding.games.pumper;

public class PumperUtils {
	
	public static final String TIME_REGEX = "^[0-2][0-9]:([0-5][0-9]:*){2}$";
	
	public static void checkTimeValidity(String time) throws IllegalArgumentException{
		if (time.matches(TIME_REGEX)) {
			int hours = Integer.parseInt(time.substring(0, 2));
			if (hours > 23) {
				throw new IllegalArgumentException("Hours have to be less or equals to 23");
			}
		} else {
			throw new IllegalArgumentException("Time " + time + " is invalid. The correct format is HH:MM:SS");
		}
	}
	
	public static int convertTimeToSeconds(String time) {
        int timeInSeconds = 0;
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int seconds = Integer.parseInt(time.substring(6));
        timeInSeconds = hours*3600 + minutes * 60 + seconds;
        return timeInSeconds;
    }

    public static String convertSecondsToTime(int timeInSeconds) {
    	int hours = timeInSeconds / 3600;
    	timeInSeconds -= hours * 3600;
    	int minutes = timeInSeconds / 60;
    	timeInSeconds -= minutes * 60;
    	int seconds = timeInSeconds;
    	
    	String stringHours = timeUnitPresentation(hours);
    	String stringMinutes = timeUnitPresentation(minutes);
    	String stringSeconds = timeUnitPresentation(seconds);
    	
    	return new StringBuilder(stringHours)
    			.append(':')
    			.append(stringMinutes)
    			.append(':')
    			.append(stringSeconds)
    			.toString();
    }
    
    public static String timeUnitPresentation(int timeUnit) {
    	return timeUnit < 10 ? "0" + timeUnit : Integer.toString(timeUnit);
    }
}