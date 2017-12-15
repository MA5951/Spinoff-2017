package org.usfirst.frc.team5951.robot.commands.ballShakers;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShakeLeft extends CommandGroup {

    public ShakeLeft() {
        addSequential(new ShakeDown());
        addSequential(new WaitCommand(0.2));
        addSequential(new ShakeUp());
        addSequential(new WaitCommand(0.2));
        addSequential(new StopShakers());
    }
}
