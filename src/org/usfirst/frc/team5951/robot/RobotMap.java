package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * TODO Find real ports
 */
public class RobotMap {

	//OI
	public static final int DRIVER_STICK_PORT = 0;
	public static final int OPERATOR_STICK_PORT = 1;
	public static final int DRIVER_TANK_LEFT_PORT = 2;
	public static final int DRIVER_TANK_RIGHT_PORT = 3;
		
	//Motor controllers
	public static final int GEARS_INTAKE_TALON = 1;
	public static final int QUEUE_TALON = 2;
	public static final int CHASSIS_TALON_LEFT_FRONT = 3;
	public static final int CHASSIS_TALON_LEFT_REAR = 4;
	public static final int CHASSIS_TALON_RIGHT_FRONT = 5;
	public static final int CHASSIS_TALON_RIGHT_REAR = 6;	
	public static final int LIFT_TALON = 7;
	public static final int FLYWHEEL_TALON = 8;
	
	
	//Servos
	public static final int LEFT_SERVO_PORT = 0;
	public static final int RIGHT_SERVO_PORT = 1;
	
	//Pneumatics
	//General
	public static final int PCM = 0;
	
	//Chassis
	public static final int SHIFTERS_OPEN = 2;
	public static final int SHIFTERS_CLOSED = 3;
	
	//Sensors
	//Encoders
	public static final int CHASSIS_ENCODER_RIGHT_A = 3;
	public static final int CHASSIS_ENCODER_RIGHT_B = 4;

	//Limit switches
	public static final int LIFT_LIMITED_SWITCH_PORT = 5;
	public static final int QUEUE_SWITCH = 0;
	
	//LEDs
	public static final int LED_RELAY = 1;



}
