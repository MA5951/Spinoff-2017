package org.usfirst.frc.team5951.robot.autonomous;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveTest extends CommandGroup {

    public DriveTest() {
        addSequential(new DriveStraight(1.0));
    }
}
