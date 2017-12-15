package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Lift subsystem
 *
 * the methods of this subsystem: 
 * downPosition- used to bring the gear griper to the ground to collect gears 
 * dynamicPosition- used to bring the gear griper to dynamic peg 
 * staticPosition- used to bring the gear griper to static peg 
 * encoderReset- used to enable the driver to reset the encoder.
 */
public class Lift extends Subsystem {

	// Creating new CANTalon and a DigitalInput
	private CANTalon liftMotor;

	private DigitalInput limitSwitch;

	// Sets down, dynamic and static position
	public static final double DOWN_POSITION = -20;
	public static final double DYNAMIC_POSITION = 10;
	public static final double STATIC_POSITION = 70;
	public static final double RELEASE_DISTANCE = 10;
	
	//Speeds
	public static final double DOWN_SPEED = -0.7;

	// Sets the number of pulses in 360 degrees
	public static final int LIFT_CPR = 1024;

	// Sets the proportional, integral and derivative for the PID
	public static final double LIFT_P = 0.5;
	public static final double LIFT_I = 0;
	public static final double LIFT_D = 0;

	// The constructor of the subsystem
	public Lift() {
		// Sets the CANTalon
		liftMotor = new CANTalon(RobotMap.LIFT_TALON);
//		liftMotor.changeControlMode(TalonControlMode.Position);
//		liftMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
//		liftMotor.setPID(LIFT_P, LIFT_I, LIFT_D);
//		liftMotor.enableBrakeMode(true);

		limitSwitch = new DigitalInput(RobotMap.LIFT_LIMITED_SWITCH_PORT);
	}

	// downPosition method brings the lift to the bottom
	public void downPosition() {
		liftMotor.changeControlMode(TalonControlMode.Position);
		liftMotor.set(DOWN_POSITION * LIFT_CPR);
		liftMotor.enable();
	}

	// dynamicPosition method brings the lift to the dynamic peg
	public void dynamicPosition() {
		liftMotor.changeControlMode(TalonControlMode.Position);
		liftMotor.set(DYNAMIC_POSITION * LIFT_CPR);
		liftMotor.enable();
	}

	// staticPosition method brings the lift to the static peg
	public void staticPosition() {
		liftMotor.changeControlMode(TalonControlMode.Position);
		liftMotor.set(STATIC_POSITION * LIFT_CPR);
		liftMotor.enable();
	}

	// Resets the encoder when the micro switch is bumped
	public void encoderReset() {
		liftMotor.reset();
	}
	
	public void downToReset() {
		liftMotor.disable();
		liftMotor.changeControlMode(TalonControlMode.PercentVbus);
		liftMotor.set(DOWN_SPEED);
	}
	
	public void raise(double power) {
		this.liftMotor.set(power);
	}
	
	public void lower(double power) {
		this.liftMotor.set(power);
	}
	
	public void stopLift() {
		liftMotor.changeControlMode(TalonControlMode.PercentVbus);
		liftMotor.set(0);
	}
	
	public boolean isSwitchPressed() {
		return limitSwitch.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

}