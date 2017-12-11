package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.chassis.ToggleShifters;
import org.usfirst.frc.team5951.robot.commands.flywheel.RollUp;
import org.usfirst.frc.team5951.robot.commands.intakeGears.IntakeGears;
import org.usfirst.frc.team5951.robot.commands.intakeGears.OuttakeGears;
import org.usfirst.frc.team5951.robot.commands.leds.BlinkLEDs;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDownPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftDynamicPosition;
import org.usfirst.frc.team5951.robot.commands.lift.LiftEncoderReset;
import org.usfirst.frc.team5951.robot.commands.lift.LiftStaticPosition;
import org.usfirst.frc.team5951.robot.triggers.GearInside;
import org.usfirst.frc.team5951.robot.triggers.OperatorLeftTriggerPressed;
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
	public static final JoystickButton COMMENCE_SHOOT_SEQUENCE = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	
	public static final JoystickButton LIFT_ENCODER_RESET = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
	
	public static final JoystickButton LIFT_INTAKE_POS = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	
	public static final JoystickButton LIFT_LOW_PEG =
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	
	public static final JoystickButton LIFT_HIGH_PEG = 
			new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	
	public static final JoystickButton TOGGLE_SHIFTERS = 
			new JoystickButton(DRIVER_STICK, JoystickUtil.JOYSTICK.TRIGGER);
	
	//Triggers
	public static final GearInside GEAR_INSIDE_TRIGGER = 
			new GearInside();
	
	public static final OperatorLeftTriggerPressed INTAKE_GEARS = 
			new OperatorLeftTriggerPressed();
	
	public static final OperatorRightTriggerPressed RELEASE_GEARS = 
			new OperatorRightTriggerPressed();
	
	public OI() {
		//Operator
		//TODO Add insert ball on RB
		COMMENCE_SHOOT_SEQUENCE.toggleWhenPressed(new RollUp());
		
		LIFT_ENCODER_RESET.whenPressed(new LiftEncoderReset());
		
		LIFT_INTAKE_POS.whenPressed(new LiftDownPosition());
		
		LIFT_LOW_PEG.whenPressed(new LiftDynamicPosition());
		
		LIFT_HIGH_PEG.whenPressed(new LiftStaticPosition());
		
		INTAKE_GEARS.whileActive(new IntakeGears());

		RELEASE_GEARS.whileActive(new OuttakeGears());
		
		//Driver
		TOGGLE_SHIFTERS.whenPressed(new ToggleShifters());
		
		//Triggers
		GEAR_INSIDE_TRIGGER.whenActive(new BlinkLEDs());
	}
}
