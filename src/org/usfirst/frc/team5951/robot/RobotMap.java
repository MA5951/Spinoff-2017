package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

public static final int GEARS_INTAKE_LIMIT_SWITCH = 400; // TODO fix port
	
	public static final int GEARS_INTAKE_TALON = 400; // TODO fix port
	
	//CANTalon powers
	//not sure this is supposed to be here, but Yair told me to add it.
	public static final int MAX_TALON_POWER = 1;
	public static final int MIN_TALON_POWER = -1;
}
