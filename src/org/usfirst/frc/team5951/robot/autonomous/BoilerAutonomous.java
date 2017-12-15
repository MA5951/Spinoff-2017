package org.usfirst.frc.team5951.robot.autonomous;

import org.usfirst.frc.team5951.robot.commands.chassis.DriveStraight;
import org.usfirst.frc.team5951.robot.commands.flywheel.RollUp;
import org.usfirst.frc.team5951.robot.commands.queue.ShootBall;
import org.usfirst.frc.team5951.robot.commands.queue.RemoveBall;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *@author Omer Libai and Yair Ziv
 * goes to the control zone and shoots balls.
 */
public class BoilerAutonomous extends CommandGroup {

    public BoilerAutonomous() {
    	addParallel(new RollUp()); //get the Flywheel ready
        addSequential(new DriveStraight(4.5)); //from start point to control zone
        addSequential(new WaitCommand(0.5));
        addSequential(new ShootBall()); //shoot!
    }
}
