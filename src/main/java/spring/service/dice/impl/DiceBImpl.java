package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceBImpl implements Dice {

	int value;
	
	public DiceBImpl() {
		System.out.println("::"+getClass().getName()+" »ý¼ºÀÚ....");
	}

	@Override
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}

}
