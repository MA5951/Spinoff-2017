package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Omer Libai and Tomer Asher in spirit
 *
 */
public class GearsIntake extends Subsystem {

	private CANTalon intakeMotor;

	public static final int MAX_TALON_POWER = 1;
	public static final int MIN_TALON_POWER = -1;

	/**
	 * 
	 */
	public GearsIntake() {

		// init the CANTalon
		intakeMotor = new CANTalon(RobotMap.GEARS_INTAKE_TALON);
		intakeMotor.changeControlMode(TalonControlMode.PercentVbus);

	}


	/**
	 * Sets the CANTalon value forward. This function intakes the gears.
	 */
	public void intake() {
		intakeMotor.set(MAX_TALON_POWER);
	}

	/**
	 * Sets the CANTalon value backwards. This function outtakes the gears.
	 */
	public void outtake() {
		intakeMotor.set(MIN_TALON_POWER);
	}

	/**
	 * Sets the CANTalon value to 0. This function stops any intake/outtake.
	 */
	public void stop() {
		intakeMotor.set(0);
	}

	/**
	 * Sets the CANTalon's power to a given parameter.
	 * 
	 * @param power
	 *            - the power to set the CANTalon.
	 */
	public void setPower(double power) {
		intakeMotor.set(power);
	}

	/**
	 * 
	 */
	@Override
	protected void initDefaultCommand() {

	}

}
