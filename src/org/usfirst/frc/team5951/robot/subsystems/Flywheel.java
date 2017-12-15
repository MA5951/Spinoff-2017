package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flywheel extends Subsystem {

	private CANTalon flywheelMotor;

	// TODO Find values
	public static final double FLYWHEEL_P = 0;
	public static final double FLYWHEEL_I = 0;
	public static final double FLYWHEEL_D = 0;
	public static final double FLYWHEEL_F = 1.0 / 5600.0;

	public static final int FLYWHEEL_CPR = 1024; //Codes per revolution

	public static final double SHOOTING_VELOCITY = 4000;
	public static final double STOPPED_VELOCITY = 0;

	/**
	 * Flyhweel constructor
	 */
	public Flywheel() {
		this.flywheelMotor = new CANTalon(RobotMap.FLYWHEEL_TALON);
		this.flywheelMotor.changeControlMode(TalonControlMode.Speed);
		this.flywheelMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.flywheelMotor.setPID(FLYWHEEL_P, FLYWHEEL_I, FLYWHEEL_D);
		this.flywheelMotor.setF(FLYWHEEL_F);
		this.flywheelMotor.setInverted(true);
		this.flywheelMotor.configEncoderCodesPerRev(FLYWHEEL_CPR);
		this.flywheelMotor.enable();
		this.flywheelMotor.set(0);
	}

	/**
	 * Enables the speed controller sets the flywheel speed to
	 * {@link SHOOTING_VALOCITY}
	 */
	public void speedUp() {
		this.flywheelMotor.set(SHOOTING_VELOCITY);
		this.flywheelMotor.enable();
	}
	
	public double getError() {
		return this.flywheelMotor.getError();
	}

	/**
	 * Stops the flywheel (velocity 0)
	 */
	public void stopFlywheel() {
		this.flywheelMotor.set(STOPPED_VELOCITY);
	}

	public void initDefaultCommand() {
	}
}
