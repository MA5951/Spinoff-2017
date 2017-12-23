package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flywheel extends Subsystem {

	private CANTalon flywheelMotor;

	// TODO Find values
	public static final double FLYWHEEL_P = 0.0016;
	public static final double FLYWHEEL_I = 0.00001;
	public static final double FLYWHEEL_D = 0.00001;
	public static final double FLYWHEEL_F = 0;

	public static final int FLYWHEEL_CPR = 1400;
	public static final int ALLOWABLE_ERROR = 5;

	public static final double SHOOTING_VELOCITY = 3125;
	public static final double STOPPED_VELOCITY = 0;

	/**
	 * Flyhweel constructor
	 */
	public Flywheel() {
		this.flywheelMotor = new CANTalon(RobotMap.FLYWHEEL_TALON);
		this.flywheelMotor.configEncoderCodesPerRev(1400);
		this.flywheelMotor.changeControlMode(TalonControlMode.Speed);
		this.flywheelMotor.setAllowableClosedLoopErr(ALLOWABLE_ERROR);
		this.flywheelMotor.reverseOutput(true);
		this.flywheelMotor.reverseSensor(false);
		this.flywheelMotor.setPID(FLYWHEEL_P, FLYWHEEL_I, FLYWHEEL_D);
		this.flywheelMotor.enable();
	}

	/**
	 * Enables the speed controller sets the flywheel speed to
	 * {@link SHOOTING_VALOCITY}
	 */
	public void speedUp() {
		this.flywheelMotor.changeControlMode(TalonControlMode.Speed);
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
		this.flywheelMotor.changeControlMode(TalonControlMode.PercentVbus);
		this.flywheelMotor.set(STOPPED_VELOCITY);
	}

	public void initDefaultCommand() {
	}

	public double getSpeed() {
		// TODO Auto-generated method stub
		return this.flywheelMotor.getSpeed();
	}
}
