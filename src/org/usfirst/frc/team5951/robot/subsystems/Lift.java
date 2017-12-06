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
	public static final double DOWN_POSITION = 0;
	public static final double DYNAMIC_POSITION = 20;
	public static final double STATIC_POSITION = 70;
	public static final double RELEASE_DISTANCE = 10;
	
	//Speeds
	public static final double DOWN_SPEED = -1;

	// Sets the number of pulses in 360 degrees
	public static final int DISTANCE_PER_PULSE = 500;

	// Sets the proprotinal, integral and derivative for the PID
	public static final double LIFT_P = 0.5;
	public static final double LIFT_I = 0;
	public static final double LIFT_D = 0;

	// The constructor of the subsystem
	public Lift() {
		// Sets the CANTalon
		liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
		liftMotor.changeControlMode(TalonControlMode.Position);
		liftMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		liftMotor.setPID(LIFT_P, LIFT_I, LIFT_D);
		liftMotor.setPulseWidthPosition(DISTANCE_PER_PULSE);

		limitSwitch = new DigitalInput(RobotMap.LIFT_LIMITED_SWITCH_PORT);
	}

	// downPosition method brings the lift to the bottom
	public void downPosition() {
		liftMotor.set(DOWN_POSITION);
	}

	// dynamicPosition method brings the lift to the dynamic peg
	public void dynamicPosition() {
		liftMotor.set(DYNAMIC_POSITION);
	}

	// staticPosition method brings the lift to the static peg
	public void staticPosition() {
		liftMotor.set(STATIC_POSITION);
	}

	// Resets the encoder when the micro switch is bumped
	public void encoderReset() {
		liftMotor.reset();
	}
	
	public void downToReset() {
		liftMotor.set(DOWN_SPEED);
	}
	
	public boolean isSwitchPressed() {
		return limitSwitch.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

}
