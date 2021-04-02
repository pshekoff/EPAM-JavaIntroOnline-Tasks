package javaIntro_4_Classes;

public class DecimalCounter {
	
	private int lowValue;
	private int topValue;
	private int currentValue;
	
	public DecimalCounter() {
		this.lowValue = -10;
		this.topValue = 10;
		this.currentValue = 0;
	}
	
	public DecimalCounter(int lowValue, int topValue, int currentValue) {
		if (lowValue > topValue) {
			System.out.println("Error: The low value is greater than top value! (Default values will be set)");
			this.lowValue = -10;
			this.topValue = 10;
			this.currentValue = 0;
		}
		if ((currentValue < lowValue)|(currentValue > topValue)) {
			System.out.println("Error: The current value out of range! (Default values will be set)");
			this.lowValue = -10;
			this.topValue = 10;
			this.currentValue = 0;
		}
		else {
			this.lowValue = lowValue;
			this.topValue = topValue;
			this.currentValue = currentValue;
		}
	}

	public int getLowValue() {
		return lowValue;
	}
	public int getTopValue() {
		return topValue;
	}
	public int getCurrentValue() {
		return currentValue;
	}
	
	public void increase() {
		if (currentValue == topValue) {
			System.out.println("Warning: maximum value is already reached!");
		}
		else {
			currentValue++;
		}
	}
	
	public void decrease() {
		if (currentValue == lowValue) {
			System.out.println("Warning: inimum value is already reached!");
		}
		else {
			currentValue--;
		}
	}
	
}
