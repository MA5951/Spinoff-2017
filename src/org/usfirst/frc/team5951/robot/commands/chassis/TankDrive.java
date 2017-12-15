package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends Command {

	private Chassis chassis;
	
    public TankDrive() {
        chassis = Robot.CHASSIS;
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	chassis.stopChassis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.tankDrive(OI.DRIVER_TANK_RIGHT.getY(), 
    					  OI.DRIVER_TANK_LEFT.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	chassis.stopChassis();
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}