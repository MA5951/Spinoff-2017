package org.usfirst.frc.team5951.robot.commands.intakeGears;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.GearsIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Omer Libai
 *	Intakes the gears until the limit-switch is pressed.
 */
public class IntakeGears extends Command {

	private GearsIntake gearsIntake;

	public IntakeGears() {
		gearsIntake = Robot.GEARS_INSTAKE;
		requires(gearsIntake);
	}

	protected void initialize() {
	}

	protected void execute() {
		gearsIntake.intake();
	}

	protected boolean isFinished() {
		return gearsIntake.isLimitActive(); //makes sure the command stops when the limit switch is pressed.
	}

	protected void end() {
		gearsIntake.stop();
	}

	protected void interrupted() {
		end();
	}
}