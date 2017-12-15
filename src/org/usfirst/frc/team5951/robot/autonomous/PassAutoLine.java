package org.usfirst.frc.team5951.robot.autonomous;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Omer Libai and Yair Ziv
 */
public class PassAutoLine extends CommandGroup {

    public PassAutoLine() {
        addSequential(new DriveStraight(6.0));
    }
}
