package org.usfirst.frc.team5951.robot.commands.lift;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *Brings the lift down and resets the Encoder there
 */
public class LiftEncoderReset extends Command {
	
	//set a new Lift object
	private Lift lift;
	
    public LiftEncoderReset() {
    	//sets the lift object as a Lift
    	lift = Robot.LIFT;
    	//using lift object
        requires(lift);
        this.setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	lift.downToReset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return lift.isSwitchPressed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	lift.encoderReset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
