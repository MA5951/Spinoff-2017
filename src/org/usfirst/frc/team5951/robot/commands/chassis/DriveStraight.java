package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	private Chassis chassis;
	private double setpoint;
	
    public DriveStraight(double setpoint) {
        this.chassis = Robot.CHASSIS;
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.chassis.strongGear();
    	this.chassis.resetEncoder();
    	this.chassis.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.chassis.arcadeDrive(-getDistanceError() * Chassis.DRIVE_KP, 
    							 getAngleError() * Chassis.ROTATE_KP);    
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
    	this.end();
    }
    
    /**
     * Checks if the robot is in the correct place and rotation
     */
    private boolean isInTolerance() {
    	return (Math.abs(getDistanceError()) < 0.05 && Math.abs(getAngleError()) < 2);
    }
    
    /**
     * Returns the distance between the robot and the setpoint
     */
    private double getDistanceError() {
    	return this.setpoint - this.chassis.getRightEncoderDistance();
    }
    
    /**
     * Returns the angle relative to 0
     */
    private double getAngleError() {
    	return -this.chassis.getRobotAngle();
    }
}
