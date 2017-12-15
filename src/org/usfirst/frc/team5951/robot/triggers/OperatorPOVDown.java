package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class OperatorPOVDown extends Trigger {

    public boolean get() {
        return (OI.OPERATOR_STICK.getPOV() > 270 || 
        	    OI.OPERATOR_STICK.getPOV() < 90) &&
        		OI.OPERATOR_STICK.getPOV() != -1;
    }
}
