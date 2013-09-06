package CH5;

import java.util.*;
import CtCILibrary.*;

public class Question7 {
	static class BitInteger {
		public static int INTEGER_SIZE;
		private boolean[] bits;

		public BitInteger() {
			bits = new boolean[INTEGER_SIZE];
		}

		// 0..N MSB..LSB
		public BitInteger(int value) {
			bits = new boolean[INTEGER_SIZE];
			for (int j = 0; j < INTEGER_SIZE; j++) {
				if (((value >> j) & 1) == 1)
					bits[INTEGER_SIZE - 1 - j] = true;
				else
					bits[INTEGER_SIZE - 1 - j] = false;
			}
		}

		// return kth MSB
		public int fetch(int k) {
			if (bits[k])
				return 1;
			else
				return 0;

		}

		// set kth MSB
		public void set(int k, int bitValue) {
			if (bitValue == 0)
				bits[k] = false;
			else
				bits[k] = true;
		}

		// set kth MSB
		public void set(int k, char bitValue) {
			if (bitValue == 0)
				bits[k] = false;
			else
				bits[k] = true;
		}

		public void swapValues(BitInteger number) {
			for (int i = 0; i < INTEGER_SIZE; i++) {
				int temp = number.fetch(i);
				number.set(i, this.fetch(i));
				this.set(i, temp);
			}
		}

		public int toInt() {
			int number = 0;
			for (int j = INTEGER_SIZE - 1; j >= 0; j--) {
				number = number | fetch(j);
				if (j > 0) {
					number = number << 1;
				}
			}
			return number;
		}
	}

	public static int findMissing(ArrayList<BitInteger> array) {
		return findMissing(array, BitInteger.INTEGER_SIZE - 1);
	}

	// if count(0)<=count(1), 0, else 1
	public static int findMissing(ArrayList<BitInteger> input, int column) {
		if (column < 0) {
			return 0;
		}
		ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>();
		ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>();
		for (BitInteger t : input) {
			if (t.fetch(column) == 0) {
				zeroBits.add(t);
			} else {
				oneBits.add(t);
			}
		}
		if (zeroBits.size() <= oneBits.size()) {
			int v = findMissing(zeroBits, column - 1);
			System.out.print("0");
			return (v << 1) | 0;
		} else {
			int v = findMissing(oneBits, column - 1);
			System.out.print("1");
			return (v << 1) | 1;
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int n = rand.nextInt(300000) + 1;
		int missing = rand.nextInt(n + 1);
		ArrayList<BitInteger> array = initialize(n, missing);
		System.out.println("The array contains all numbers but one from 0 to "
				+ n + ", except for " + missing);

		int result = findMissing(array);
		if (result != missing) {
			System.out.println("Error in the algorithm!\n"
					+ "The missing number is " + missing
					+ ", but the algorithm reported " + result);
		} else {
			System.out.println("The missing number is " + result);
		}
	}

	public static ArrayList<BitInteger> initialize(int n, int missing) {
		BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length();
		ArrayList<BitInteger> array = new ArrayList<BitInteger>();

		for (int i = 1; i <= n; i++) {
			array.add(new BitInteger(i == missing ? 0 : i));
		}

		// Shuffle the array once.
		for (int i = 0; i < n; i++) {
			int rand = i + (int) (Math.random() * (n - i));
			array.get(i).swapValues(array.get(rand));
		}

		return array;
	}
}