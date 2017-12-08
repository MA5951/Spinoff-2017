package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * 
 * @author Omer Libai and Yair Ziv
 *	a trigger that returns if the gears-intake limit-switch is active
 */
public class GearInside extends Trigger {
	
	/**
	 * 
	 */
	public boolean get() {
		return Robot.gearsIntake.isLimitActive();
	}

}
