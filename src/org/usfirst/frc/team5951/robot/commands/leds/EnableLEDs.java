package org.usfirst.frc.team5951.robot.commands.leds;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.LEDs;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class EnableLEDs extends InstantCommand {
	
	private LEDs leds;
	
    public EnableLEDs() {
        leds = Robot.LEDS;
        requires(this.leds);
    }

    // Called once when the command executes
    protected void initialize() {
    	this.leds.ledsOn();
    }

}
