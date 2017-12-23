package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.RotateToAngle;
import org.usfirst.frc.team5951.robot.commands.intakeGears.OuttakeGears;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDownPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDynamicPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftEncoderReset;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RedGearsRight extends CommandGroup {

    public RedGearsRight() {
    	addParallel(new LiftDynamicPosition());
		addSequential(new DriveStraight(4.03));
		addParallel(new LiftEncoderReset());
		addSequential(new WaitCommand(0.3));
		addSequential(new RotateToAngle(-78));
		addSequential(new WaitCommand(0.3));
		addParallel(new LiftDynamicPosition());
		addSequential(new DriveStraight(-0.9));
		addParallel(new OuttakeGears());
		addSequential(new LiftDownPosition());
		addSequential(new DriveStraight(0.4));
		addSequential(new WaitCommand(0.2));
		addSequential(new RotateToAngle(30));
		addSequential(new WaitCommand(0.2));
		addSequential(new DriveStraight(1.7));
    }
}
