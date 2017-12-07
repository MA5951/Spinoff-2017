package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Lift Ports
	public static final int LIFT_MOTOR = 0;
	public static final int LIFT_ENCODER_A = 1;
	public static final int LIFT_ENCODER_B = 2;
	public static final int LIFT_LIMITED_SWITCH_PORT = 0;
	
	public static final int DRIVER_STICK_PORT = 0;
	public static final int OPERATOR_STICK_PORT = 1;
	
	public static final int FLYWHEEL_TALON = 1;
	
	public static final int LED_RELAY = 1;
}
