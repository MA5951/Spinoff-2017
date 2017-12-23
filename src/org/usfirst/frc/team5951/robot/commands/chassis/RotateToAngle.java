package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateToAngle extends Command {

	private Chassis chassis;
	private double rotateAngle;

	public RotateToAngle(double rotateAngle) {
		this.chassis = Robot.CHASSIS;
		requires(chassis);

		this.rotateAngle = rotateAngle;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.chassis.resetGyro();
		this.chassis.strongGear();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		this.chassis.arcadeDrive(0, getAngleError() * Chassis.ROTATE_KP);
		SmartDashboard.putNumber("Robot angle: ", this.chassis.getRobotAngle());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.isInTolerance();
	}

	// Called once after isFinished returns true
	protected void end() {
		this.chassis.stopChassis();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	/**
	 * Checks if the angle error is less than 2 degrees
	 * @return
	 */
	private boolean isInTolerance() {
		return Math.abs(this.getAngleError()) < 2;
	}
	
	/**
	 * Returns the error in the angle of the robot relative to the setpoint
	 * @return
	 */
	private double getAngleError() {
		return this.rotateAngle - this.chassis.getRobotAngle();
	}
}
