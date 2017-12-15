package org.usfirst.frc.team5951.robot.commands.intakeGears;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.GearsIntake;

import edu.wpi.first.wpilibj.command.Command;


 /**
  * 
  * @author Omer Libai
  *	Releases the gears until the limit-switch isn't pressed.
  */
public class OuttakeGears extends Command {
	private GearsIntake gearsIntake;

	public OuttakeGears() {
		gearsIntake = Robot.GEARS_INSTAKE;
		requires(gearsIntake);
	}

	protected void initialize() {
	}

	protected void execute() {
		gearsIntake.outtake();
	}

	
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		gearsIntake.stop();
	}

	protected void interrupted() {
		end();
	}
}