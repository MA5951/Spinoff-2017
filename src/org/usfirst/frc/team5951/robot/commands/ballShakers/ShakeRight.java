package org.usfirst.frc.team5951.robot.commands.ballShakers;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShakeRight extends CommandGroup {

    public ShakeRight() {
        addSequential(new RightShakerDown(), 0.3);
        addSequential(new RightShakerUp(), 0.325);
    }
}
