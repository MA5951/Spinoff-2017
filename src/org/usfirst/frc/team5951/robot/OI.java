package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.flywheel.RollUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick DRIVER_STICK = 
			new Joystick(RobotMap.DRIVER_STICK_PORT);
	
	public static final Joystick OPERATOR_STOCK =
			new Joystick(RobotMap.OPERATOR_STICK_PORT);
	
	public static final JoystickButton SHOOT = 
			new JoystickButton(OPERATOR_STOCK, JoystickUtil.XBOX.A);
	
	public OI() {
		SHOOT.toggleWhenPressed(new RollUp());
	}
}
