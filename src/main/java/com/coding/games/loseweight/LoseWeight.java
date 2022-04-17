package com.coding.games.loseweight;

public class LoseWeight {
	// 1% of actual weight per week
	private final static double RECOMMENDED_PERCENTAGE_OF_LOSS_WEIGHT_PER_WEEK = 0.01;

	public int numberOfWeekToReachIdealWeight(double actualWeight, double idealWeight) {
		int numberOfWeek = 0;
		while (actualWeight > idealWeight) {
			actualWeight *= 1 - RECOMMENDED_PERCENTAGE_OF_LOSS_WEIGHT_PER_WEEK;
			numberOfWeek++;
		}
		return numberOfWeek;
	}
}