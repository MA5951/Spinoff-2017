package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShiftStrongGear extends InstantCommand {

	private Chassis chassis;
	
    public ShiftStrongGear() {
        this.chassis = Robot.CHASSIS;
    }

    // Called once when the command executes
    protected void initialize() {
    	this.chassis.strongGear();
    }

}
