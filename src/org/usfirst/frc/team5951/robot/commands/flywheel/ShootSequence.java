package org.usfirst.frc.team5951.robot.commands.flywheel;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShootSequence extends CommandGroup {

    public ShootSequence() {
        addParallel(new RollUp());
        //TODO add vision
    }
}
