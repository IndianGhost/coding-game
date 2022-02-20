package com.coding.games.powerOfTwo;

import static java.util.Objects.isNull;

public class PowerOfTwoDemo {
	private static PowerOfTwoDemo instance;
	
	private PowerOfTwoDemo() {}
	
	public static PowerOfTwoDemo getInstance() {
		if(isNull(instance)) {
			instance = new PowerOfTwoDemo();
		}
		return instance;
	}
	
	public int wichPowerOfTwo(int n) throws IllegalArgumentException {
		if( !(1<=n && n<=2147483647) ) {
			throw new IllegalArgumentException("The argument n should be : 1<=n<=2147483647");
		}
		// Odd numbers are not Powers of two
		if(n % 2 != 0) {
			return -1;
		}
		// Even numbers
		int count = 0;
		int quotient = n;
		int rest = 0;
		while(quotient>1) {
			rest = quotient % 2;
			quotient /= 2;
			count++;
			// if rest equals to 1 in any iteration it means n is not a power of two
			if(rest != 0) {
				return -1;
			}
		}
		return count;
	}
}
