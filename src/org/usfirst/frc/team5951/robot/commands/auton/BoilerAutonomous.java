package org.usfirst.frc.team5951.robot.commands.auton;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.flywheel.RollUp;
import org.usfirst.frc.team5951.robot.commands.queue.InsertBall;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *@author Omer Libai and Yair Ziv
 * goes to the control zone and shoots balls.
 */
public class BoilerAutonomous extends CommandGroup {

    public BoilerAutonomous() {
    	addParallel(new RollUp());
        addSequential(new DriveStraight(4.5)); 
        addSequential(new WaitCommand(5));
        addSequential(new InsertBall()); //shoot!
    }
}
