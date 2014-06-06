package lejossimple;

import java.util.Random;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.CompassHTSensor;
import lejos.robotics.navigation.CompassPilot;

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
		int n = 1;
		int lastN = 0;
		
		// move in a fibonacci spiral
		CompassHTSensor compass = new CompassHTSensor(SensorPort.S3);
	    CompassPilot pilot = new CompassPilot(compass, 2.25f, 4.8f, Motor.A, Motor.C);
	    pilot.calibrate();
	    LCD.drawInt((int) pilot.getHeading(), 4, 0, 0);
        Button.waitForAnyPress();
		for(int i = 0; i<10; i++) {
	        pilot.travel(n);
	        pilot.rotate(90 - pilot.getCompassHeading());
	        pilot.getCompass().resetCartesianZero();
	        n = n + lastN;
	        lastN = n;
		}
	}

}
