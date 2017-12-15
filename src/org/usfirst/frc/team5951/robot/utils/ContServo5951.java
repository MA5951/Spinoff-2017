package org.usfirst.frc.team5951.robot.utils;

import edu.wpi.first.wpilibj.PWM;

public class ContServo5951 extends PWM {
	
	public static final int PWM_MIDPOINT = 255 / 2; 
	
	public ContServo5951(int port) {
		super(port);		
	}

	/**
	 * Sets the power for the servo between 0-255
	 * @param power
	 */
	public void setPower(double power) {
		power = PWM_MIDPOINT + (power * PWM_MIDPOINT);
		if (power > 255) {
			power = 255;
		} else if (power < 0) {
			power = 0;
		}
	}
	
}
