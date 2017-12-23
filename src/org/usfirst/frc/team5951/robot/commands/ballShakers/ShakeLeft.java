package org.usfirst.frc.team5951.robot.commands.ballShakers;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShakeLeft extends CommandGroup {

    public ShakeLeft() {
        addSequential(new LeftShakerDown(), 0.3);
        addSequential(new LeftShakerUp(), 0.3);
    }
}
