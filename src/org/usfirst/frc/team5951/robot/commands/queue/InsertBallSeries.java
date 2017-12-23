package org.usfirst.frc.team5951.robot.commands.queue;

import org.usfirst.frc.team5951.robot.commands.flywheel.WaitForSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class InsertBallSeries extends CommandGroup {

    public InsertBallSeries() {
        addSequential(new InsertToLimitSwitch());
        addSequential(new WaitForSpeed());
        addSequential(new InsertBall());
    }
}
