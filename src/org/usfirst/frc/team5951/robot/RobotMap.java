package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//OI
	public static final int DRIVER_STICK_PORT = 0;
	public static final int OPERATOR_STICK_PORT = 1;

	//Motor controllers
	public static final int CHASSIS_TALON_LEFT_FRONT = 1;
	public static final int CHASSIS_TALON_LEFT_REAR = 2;
	public static final int CHASSIS_TALON_RIGHT_FRONT = 3;
	public static final int CHASSIS_TALON_RIGHT_REAR = 4;
	
	public static final int FLYWHEEL_TALON = 5;
	
	//Pneumatics
	//General
	public static final int PCM = 0;
	
	//Chassis
	public static final int SHIFTERS_OPEN = 0;
	public static final int SHIFTERS_CLOSED = 1;
	
	//Sensors
	public static final int CHASSIS_ENCODER_LEFT_A = 1;
	public static final int CHASSIS_ENCODER_LEFT_B = 2;
	public static final int CHASSIS_ENCODER_RIGHT_A = 3;
	public static final int CHASSIS_ENCODER_RIGHT_B = 4;
	
	//LEDs
	public static final int LED_RELAY = 1;
	
}
