package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDs extends Subsystem {
	
	private Relay ledRelay;
	
    public LEDs() {
    	this.ledRelay = new Relay(RobotMap.LED_RELAY);
    	this.ledRelay.set(Value.kOff);
    }
    
    public void ledsOn() {
    	this.ledRelay.set(Value.kOn);
    }
    
    public void ledsOff() {
    	this.ledRelay.set(Value.kOff);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

