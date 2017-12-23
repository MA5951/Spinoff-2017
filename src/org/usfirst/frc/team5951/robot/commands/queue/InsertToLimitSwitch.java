package org.usfirst.frc.team5951.robot.commands.queue;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Queue;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InsertToLimitSwitch extends Command {
	private Queue queue;

	public InsertToLimitSwitch() {
    	this.queue = Robot.QUEUE;
    	requires(queue);
    }

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		this.queue.insertBalls();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		 return this.queue.isSwitchPressed();
	}

	// Called once after isFinished returns true
	protected void end() {
		this.queue.stopQueue();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}
