package lejossimple;

import java.util.Random;

import lejos.nxt.LCD;

public class HelloLejos {
	
	public static void main(String[] args) {
		// say hello world with random
		Random r = new Random();
		StringBuffer buf = new StringBuffer("Hello World #");
		buf.append(r.nextInt());
		
		// center the text
		int charsWide = LCD.SCREEN_WIDTH / LCD.CELL_WIDTH;
		int leftOffset = charsWide - buf.length() / 2;
		LCD.drawString(buf.toString(), leftOffset, 4);
	}

}
