package org.usfirst.frc.team5951.robot.commands.ballShakers;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.BallShakers;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LeftShakerDown extends Command {

	private BallShakers ballShakers;
	
    public LeftShakerDown() {
    	this.ballShakers = Robot.BALL_SHAKERS;
    	requires(ballShakers);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ballShakers.shakeDownLeft();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ballShakers.stopLeftServo();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
