package org.usfirst.frc.team5951.robot.commands.leds;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class BlinkLEDs extends CommandGroup {
	
    public BlinkLEDs() {
    	this.addSequential(new EnableLEDs());
    	this.addSequential(new WaitCommand(0.15));
    	this.addParallel(new DisableLEDs());
    	this.addSequential(new WaitCommand(0.15));
    	this.addSequential(new EnableLEDs());
    	this.addSequential(new WaitCommand(0.15));
    	this.addParallel(new DisableLEDs());
    	this.addSequential(new WaitCommand(0.15));
    	this.addSequential(new EnableLEDs());
    	this.addSequential(new WaitCommand(0.15));
    	this.addParallel(new DisableLEDs());
    }
}
