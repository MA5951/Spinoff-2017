package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.chassis.ArcadeDrive;
import org.usfirst.frc.team5951.robot.utils.ChassisMath;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
    
	//Motor controllers
    private CANTalon rightFrontMotor,
    				 rightRearMotor,
    				 leftFrontMotor,
    				 leftRearMotor;
    
    //Pneumatics
    private DoubleSolenoid shifters;
    
    //Sensors
    //Encoders
    private Encoder rightEncoder;

    //NavX-MXP
    private AHRS navX;
    
    //Global variables
    public static final double DRIVE_KP = 4.3;
    public static final double DRIVE_KI = 0;
    public static final double DRIVE_KD = 0;

    public static final double ROTATE_KP = 0.04;
    public static final double ROTATE_KI = 0;
    public static final double ROTATE_KD = 0;
    
    public static final double CHASSIS_DPP = 1.0 / 1090.0;
    
    public static final double joystickDeadZone = 0.05;
    
    public Chassis() {
    	//Motor controllers initialize
    	this.leftFrontMotor = new CANTalon(RobotMap.CHASSIS_TALON_LEFT_FRONT);
    	this.leftRearMotor = new CANTalon(RobotMap.CHASSIS_TALON_LEFT_REAR);
    	this.rightFrontMotor = new CANTalon(RobotMap.CHASSIS_TALON_RIGHT_FRONT);
    	this.rightRearMotor = new CANTalon(RobotMap.CHASSIS_TALON_RIGHT_REAR);
    	
    	this.leftFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
    	this.leftRearMotor.changeControlMode(TalonControlMode.Follower);
    	this.rightFrontMotor.changeControlMode(TalonControlMode.PercentVbus);
    	this.rightRearMotor.changeControlMode(TalonControlMode.Follower);
    	
    	this.leftFrontMotor.setInverted(false);
    	this.leftRearMotor.reverseOutput(false);
    	this.rightFrontMotor.setInverted(true);
    	this.rightRearMotor.reverseOutput(false);
    	
    	this.leftRearMotor.set(this.leftFrontMotor.getDeviceID());
    	this.rightRearMotor.set(this.rightRearMotor.getDeviceID());
    	
    	//Pneumatics initialze
    	this.shifters = new DoubleSolenoid(RobotMap.PCM,
    									   RobotMap.SHIFTERS_OPEN,
    									   RobotMap.SHIFTERS_CLOSED);
    	
    	//Encoders initialize
    	this.rightEncoder = new Encoder(RobotMap.CHASSIS_ENCODER_RIGHT_A,
    									RobotMap.CHASSIS_ENCODER_RIGHT_B);
    	this.rightEncoder.setDistancePerPulse(CHASSIS_DPP);
    	this.rightEncoder.setReverseDirection(true);
    	
    	//NavX initialize
    	this.navX = new AHRS(Port.kMXP);
    }
    
    /**
     * Arcade drives using the given x y coordinates 
     * @param moveValue
     * @param rotateValue
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
    	double[] output = ChassisMath.calculatePower(moveValue, rotateValue);
    	this.rightFrontMotor.set(output[0]);
    	this.leftFrontMotor.set(output[1]);
    }
    
    /**
     * Stops the chassis
     */
    public void stopChassis() {
    	this.arcadeDrive(0, 0);
    }
    
    /**
     * TODO Test
     * Arcade drive using the given (x,y) coordinates
     * Has a dead-zone that keeps the chassis in place when the joystick values are 
     * less than {@code joystickDeadZone} 
     * @param moveValue
     * @param rotateValue
     */
    @Deprecated
    public void arcadeDriveDZ(double moveValue, double rotateValue) {
    	double[] output = ChassisMath.calculatePowerDZ(moveValue, rotateValue, joystickDeadZone);
    	this.rightFrontMotor.set(output[0]);
    	this.leftFrontMotor.set(output[1]);
    }
    
    /**
     * Tank drive using leftPower and rightPower
     * @param rightPower - Power for the right side of the chassis (Between -1 and 1)
     * @param leftPower - Power for the left side of the chassis (Between -1 and 1)
     */
    public void tankDrive(double rightPower, double leftPower) {
    	this.rightFrontMotor.set(rightPower);
    	this.leftFrontMotor.set(leftPower);
    }
    

    /**
     * Returns the right encoder value
     */
    public double getRightEncoderDistance() {
    	return this.rightEncoder.getDistance();
    }
        
    /**
     * Returns the robot's heading
     */
    public double getRobotAngle() {
    	return this.navX.getAngle();
    }
    
    /**
     * Resets the gyro
     */
    public void resetGyro() {
    	this.navX.reset();
    }
    
    /**
     * Toggles shifters position
     */
    public void toggleShifters() {
    	this.shifters.set(
    			this.shifters.get().equals(Value.kForward) ? Value.kReverse : Value.kForward);
    }
    
    /**
     * Shifts the shifters to strong gear
     */
    public void strongGear() {
    	this.shifters.set(Value.kForward);
    }
    
    /**
     * Shifts the shifters to fast gear
     */
    public void fastGear() {
    	this.shifters.set(Value.kReverse);
    }
    
    /**
     * Resets the encoders
     */
    public void resetEncoder() {
    	this.rightEncoder.reset();
    }
    
    /**
     * spins the robot left.
     */
    public void spinLeft() {
    	this.leftFrontMotor.set(-1);
    	this.leftRearMotor.set(-1);
    	this.rightFrontMotor.set(1);
    	this.rightRearMotor.set(1);
    }
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}

