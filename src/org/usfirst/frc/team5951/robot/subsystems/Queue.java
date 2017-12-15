package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Queue extends Subsystem {

	private CANTalon queueMotor;
	
	private DigitalInput limitSwitch;
	
	public static final double INSERT_SPEED = 0.8;
	public static final double REMOVE_SPEED = -0.8;
	
	public Queue() {
		this.queueMotor = new CANTalon(RobotMap.QUEUE_TALON);
		this.limitSwitch = new DigitalInput(RobotMap.QUEUE_SWITCH);
	}
	
	public boolean isSwitchPressed() {
		return !this.limitSwitch.get();
	}
	
	public void insertBalls() {
		this.queueMotor.set(INSERT_SPEED);
	}
	
	public void removeBalls() {
		this.queueMotor.set(REMOVE_SPEED);
	}
	
	public void stopQueue() {
		this.queueMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

