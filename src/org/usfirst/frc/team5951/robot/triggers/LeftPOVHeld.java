package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class LeftPOVHeld extends Trigger {

    public boolean get() {
        return 235 <= OI.OPERATOR_STICK.getPOV() && OI.OPERATOR_STICK.getPOV() <= 305;
    }
}
