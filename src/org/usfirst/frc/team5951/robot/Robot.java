
package org.usfirst.frc.team5951.robot;


import org.usfirst.frc.team5951.robot.commands.auton.BlueGearsLeft;
import org.usfirst.frc.team5951.robot.commands.auton.BlueGearsRight;
import org.usfirst.frc.team5951.robot.commands.auton.BoilerAutonomous;
import org.usfirst.frc.team5951.robot.commands.auton.PassAutoLine;
import org.usfirst.frc.team5951.robot.commands.auton.RedGearsLeft;
import org.usfirst.frc.team5951.robot.commands.auton.RedGearsRight;
import org.usfirst.frc.team5951.robot.subsystems.BallShakers;
import org.usfirst.frc.team5951.robot.subsystems.Chassis;
import org.usfirst.frc.team5951.robot.subsystems.Flywheel;
import org.usfirst.frc.team5951.robot.subsystems.GearsIntake;
import org.usfirst.frc.team5951.robot.subsystems.LEDs;
import org.usfirst.frc.team5951.robot.subsystems.Lift;
import org.usfirst.frc.team5951.robot.subsystems.Queue;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final Flywheel FLYWHEEL = new Flywheel();
	public static final Chassis CHASSIS = new Chassis();
	public static final LEDs LEDS = new LEDs();
	public static final Lift LIFT = new Lift();
	public static final GearsIntake GEARS_INSTAKE = new GearsIntake();
	public static final BallShakers BALL_SHAKERS = new BallShakers();
	public static final Queue QUEUE = new Queue();
	
	public static OI oi;

	//autonomous
	public SendableChooser<CommandGroup> autoChooser;
	public CommandGroup autoCommand;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		//autonomous
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("Blue Alliance, Right", new BlueGearsRight());
		autoChooser.addObject("Blue Alliance, Left", new BlueGearsLeft());
		autoChooser.addDefault("Red Alliance, Right", new RedGearsRight());
		autoChooser.addObject("Red Alliance, Left", new RedGearsLeft());
		autoChooser.addObject("Boiler Autonomous", new BoilerAutonomous());
		autoChooser.addObject("pass auto line", new PassAutoLine());
		SmartDashboard.putData("Autonomous chooser: ", autoChooser);
		CameraServer.getInstance().startAutomaticCapture().setResolution(40, 30);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		CHASSIS.resetGyro();
		autoCommand = (CommandGroup) autoChooser.getSelected();
		// TODO: CHASSIS.setChassisMultiplyer(1);
		if (autoCommand != null)
			autoCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
	}

	@Override
	public void teleopInit() {
		if(autoCommand != null){
			autoCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
