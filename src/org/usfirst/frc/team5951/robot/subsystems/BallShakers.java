package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallShakers extends Subsystem {

    private Servo leftServo;
    private Servo rightServo;
    
    public BallShakers() {
    	this.leftServo = new Servo(RobotMap.LEFT_SERVO_PORT);
    	this.rightServo = new Servo(RobotMap.RIGHT_SERVO_PORT);
    }
    
    public void shakeDown() {
    	this.leftServo.set(0);
    	this.rightServo.set(0);
    }
    
    public void shakeUp() {
    	this.leftServo.set(1);
    	this.rightServo.set(1);
    }

    public void stopShakers() {
    	this.leftServo.set(0.5);
    	this.rightServo.set(0.5);
    }
    
    public void initDefaultCommand() {
    }
}

