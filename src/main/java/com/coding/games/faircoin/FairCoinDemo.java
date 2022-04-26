package com.coding.games.faircoin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FairCoinDemo {
	private FairCoinDemo() {
	}

	public static FairCoinDemo getInstance() {
		return new FairCoinDemo();
	}

	public int flipMultipleFairCoinsAtSameTime(int n) {
		int numberOfRounds = 0;
		List<FairCoin> fairCoins = new ArrayList<>();
		while (n > 1) {
			fairCoins = Stream.generate(FairCoin::new).limit(n).collect(Collectors.toList());
			for (FairCoin coin : fairCoins) {
				coin.flip();
				// Any coin come up tails we set it aside
				if (FairCoinEnum.TAILS.equals(coin.getFairCoinSide())) {
					n--;
				}
			}
			fairCoins.clear();
			numberOfRounds++;
		}
		return numberOfRounds;
	}
}
