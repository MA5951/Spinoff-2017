package org.usfirst.frc.team5951.robot.commands.ballShakers;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Shake extends CommandGroup {

    public Shake() {
        addSequential(new ShakeDown());
        addSequential(new WaitCommand(0.1));
        addSequential(new ShakeUp());
        addSequential(new WaitCommand(0.1));
        addSequential(new StopShakers());
    }
}
