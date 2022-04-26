package com.coding.games.faircoin;

import lombok.Data;

@Data
public class FairCoin {
	private static int numberOfFlip;
	private FairCoinEnum fairCoinSide;

	public FairCoin() {
		numberOfFlip = 0;
	}

	public void flip() {
		fairCoinSide = (numberOfFlip++) % 2 == 0 ? FairCoinEnum.HEADS : FairCoinEnum.TAILS;
	}
}
