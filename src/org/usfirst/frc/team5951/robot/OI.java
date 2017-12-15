package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.ballShakers.Shake;
import org.usfirst.frc.team5951.robot.commands.chassis.ToggleShifters;
import org.usfirst.frc.team5951.robot.commands.intakeGears.IntakeGears;
import org.usfirst.frc.team5951.robot.commands.intakeGears.OuttakeGears;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDownNP;
import org.usfirst.frc.team5951.robot.commands.lift.LiftUpNP;
import org.usfirst.frc.team5951.robot.commands.queue.ShootBall;
import org.usfirst.frc.team5951.robot.commands.queue.RemoveBall;
import org.usfirst.frc.team5951.robot.triggers.OperatorPOVDown;
import org.usfirst.frc.team5951.robot.triggers.OperatorPOVUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//Joysticks
	public static final Joystick DRIVER_STICK = 
			new Joystick(RobotMap.DRIVER_STICK_PORT);
	
	public static final XboxController OPERATOR_STICK =
			new XboxController(RobotMap.OPERATOR_STICK_PORT);
	
	public static final Joystick DRIVER_TANK_LEFT = 
			new Joystick(RobotMap.DRIVER_TANK_LEFT_PORT);
	
	public static final Joystick DRIVER_TANK_RIGHT = 
			new Joystick(RobotMap.DRIVER_TANK_RIGHT_PORT);
	
	//Buttons
//	public static final JoystickButton COMMENCE_SHOOT_SEQUENCE = 
//			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
//	
//	public static final JoystickButton LIFT_ENCODER_RESET = 
//			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
//	
//	public static final JoystickButton LIFT_INTAKE_POS = 
//			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
//	
//	public static final JoystickButton LIFT_LOW_PEG =
//			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
//	
//	public static final JoystickButton LIFT_HIGH_PEG = 
//			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	
	public static final JoystickButton SHAKE_RIGHT = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	
	public static final JoystickButton TOGGLE_SHIFTERS = 
			new JoystickButton(DRIVER_STICK, JoystickUtil.JOYSTICK.TRIGGER);
	
	public static final JoystickButton INSERT_GEARS = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);
	
	public static final JoystickButton INSERT_BALL = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	
	public static final JoystickButton REMOVE_BALL = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	
	public static final OperatorPOVUp RAISE_LIFT = 
			new OperatorPOVUp();
	
	public static final OperatorPOVDown LOWER_LIFT = 
			new OperatorPOVDown();

	public static final JoystickButton REMOVE_GEARS = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	
	
	
	public OI() {
		//Driver
		TOGGLE_SHIFTERS.whenPressed(new ToggleShifters());
		SHAKE_RIGHT.whenPressed(new Shake());
		
		INSERT_GEARS.toggleWhenPressed(new IntakeGears());
		REMOVE_GEARS.toggleWhenPressed(new OuttakeGears());
		
		RAISE_LIFT.whileActive(new LiftUpNP());
		LOWER_LIFT.whileActive(new LiftDownNP());
		
		INSERT_BALL.whileHeld(new ShootBall());
		REMOVE_BALL.whileHeld(new RemoveBall());
	}
}
