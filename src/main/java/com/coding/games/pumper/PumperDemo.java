package com.coding.games.pumper;

import static com.coding.games.pumper.PumperUtils.checkTimeValidity;
import static com.coding.games.pumper.PumperUtils.convertTimeToSeconds;
import static com.coding.games.pumper.PumperUtils.convertSecondsToTime;
import static java.util.Objects.isNull;

public class PumperDemo {
	
	private static PumperDemo instance;
	
	private PumperDemo() {}
	
	public static PumperDemo getInstance() {
		if(isNull(instance)) {
			instance = new PumperDemo();
		}
		return instance;
	}
	
	public String executePumpersTogether(int numberOfPumpers, Pumper[] pumpers) throws IllegalArgumentException {
		if (numberOfPumpers != pumpers.length) {
			throw new IllegalArgumentException("First argument is number of pumpers. Therefore, the second argument has to be a vector containing the same number of pumpers");
		}
		
		double poolsFilledInOneHour = 0;
		
		for (Pumper pumper : pumpers) {
			String timeToFillOnePool = pumper.getTimeToFillOnePool();
			int timeToFillOnePoolInSeconds = convertTimeToSeconds(timeToFillOnePool);
			checkTimeValidity(timeToFillOnePool);
			// number of pool could be filled by this pumper in 1 hour
			poolsFilledInOneHour += (double) 3600 / timeToFillOnePoolInSeconds;
		}
		/*
		 * After the loop, we got this :
		 * 		3600seconds (1 hour) 	=> 	`poolsFilledInOneHour` pool
		 * 		x seconds 				=> 	1 pool
		 * How many time `x` we need to fill just 1 pool using all pumpers together?
		 * 		`poolsFilledInOneHour` * x = 3600 means x = 3600 / `poolsFilledInOneHour`
		 */
		int timeToFillOnePoolByAllPumpers = (int) (3600 / poolsFilledInOneHour);
		return convertSecondsToTime(timeToFillOnePoolByAllPumpers);
	}
}
