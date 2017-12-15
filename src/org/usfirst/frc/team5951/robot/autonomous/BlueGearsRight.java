package org.usfirst.frc.team5951.robot.autonomous;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.chassis.RotateToAngle;
import org.usfirst.frc.team5951.robot.commands.intakeGears.OuttakeGears;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDynamicPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *@author Omer Libai and Yair Ziv
 *
 */
public class BlueGearsRight extends CommandGroup {

    public BlueGearsRight() {
       addSequential(new DriveStraight(4.5));
       addSequential(new WaitCommand(0.3));
       addSequential(new RotateToAngle(90));
       addSequential(new WaitCommand(0.3));
       addSequential(new LiftDynamicPosition());
       addSequential(new WaitCommand(0.3));
       addSequential(new DriveStraight(0.98));
       addParallel(new OuttakeGears());
       addSequential(new LiftDynamicPosition());
       //TODO: add dance
    }
}
