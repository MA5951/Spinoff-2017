package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.ballShakers.ShakeLeft;
import org.usfirst.frc.team5951.robot.commands.ballShakers.ShakeRight;
import org.usfirst.frc.team5951.robot.commands.chassis.ToggleShifters;
import org.usfirst.frc.team5951.robot.commands.flywheel.RollUp;
import org.usfirst.frc.team5951.robot.commands.intakeGears.IntakeGears;
import org.usfirst.frc.team5951.robot.commands.intakeGears.OuttakeGears;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDownNP;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDownPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDynamicPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftEmergencyStopPID;
import org.usfirst.frc.team5951.robot.commands.lift.LiftEncoderReset;
import org.usfirst.frc.team5951.robot.commands.lift.LiftStaticPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftUpNP;
import org.usfirst.frc.team5951.robot.commands.queue.InsertBall;
import org.usfirst.frc.team5951.robot.commands.queue.InsertBallSeries;
import org.usfirst.frc.team5951.robot.triggers.LeftPOVHeld;
import org.usfirst.frc.team5951.robot.triggers.OperatorLeftTriggerPressed;
import org.usfirst.frc.team5951.robot.triggers.OperatorPOVDown;
import org.usfirst.frc.team5951.robot.triggers.OperatorPOVUp;
import org.usfirst.frc.team5951.robot.triggers.OperatorRightTriggerPressed;

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
	
	//Buttons
	//Driver
	public static final JoystickButton SHIFT_GEARS = 
			new JoystickButton(DRIVER_STICK, JoystickUtil.JOYSTICK.TRIGGER);
	
	//Operator
	public static final JoystickButton RESET_LIFT_ENCODER = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
	
	public static final JoystickButton LIFT_FLOOR_POS = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	
	public static final JoystickButton LIFT_DYNAMIC_POS = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	
	public static final JoystickButton LIFT_STATIC_POS = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	
	public static final JoystickButton ROLL_UP =
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);
	
	public static final JoystickButton SHAKER_LEFT = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	
	public static final JoystickButton SHAKER_RIGHT =
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.RB);
	
	public static final OperatorPOVDown LIFT_LOWER =
			new OperatorPOVDown();
	
	public static final OperatorPOVUp LIFT_RAISE =
			new OperatorPOVUp();
	
	public static final OperatorLeftTriggerPressed RELEASE_GEAR = 
			new OperatorLeftTriggerPressed();
	
	public static final OperatorRightTriggerPressed INSERT_GEAR = 
			new OperatorRightTriggerPressed();
	
	public static final LeftPOVHeld INSERT_BALLS =
			new LeftPOVHeld();

	public static final JoystickButton EMERGENCY_LIFT =
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.BACK);
	public OI() {
		SHIFT_GEARS.whenPressed(new ToggleShifters());
		RESET_LIFT_ENCODER.whenPressed(new LiftEncoderReset());
		LIFT_FLOOR_POS.whenPressed(new LiftDownPosition());
		LIFT_DYNAMIC_POS.whenPressed(new LiftDynamicPosition());
		LIFT_STATIC_POS.whenPressed(new LiftStaticPosition());
		ROLL_UP.toggleWhenPressed(new RollUp());
		SHAKER_LEFT.whenPressed(new ShakeLeft());
		SHAKER_RIGHT.whenPressed(new ShakeRight());
		RELEASE_GEAR.whileActive(new OuttakeGears());
		INSERT_GEAR.whileActive(new IntakeGears());
		
		
		LIFT_LOWER.whileActive(new LiftDownNP());
		LIFT_RAISE.whileActive(new LiftUpNP());
		INSERT_BALLS.toggleWhenActive(new InsertBallSeries());
		EMERGENCY_LIFT.whenActive(new LiftEmergencyStopPID());
	}
}
