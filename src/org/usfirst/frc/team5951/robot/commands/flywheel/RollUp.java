package org.usfirst.frc.team5951.robot.commands.flywheel;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Flywheel;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RollUp extends Command {

	private Flywheel flywheel;
	
    public RollUp() {
        flywheel = Robot.FLYWHEEL;
        requires(flywheel);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.flywheel.speedUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Motor speed: ", this.flywheel.getError());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	flywheel.stopFlywheel();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
