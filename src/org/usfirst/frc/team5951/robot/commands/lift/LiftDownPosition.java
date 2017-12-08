package org.usfirst.frc.team5951.robot.commands.lift;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *Brings the lift to the bottom position
 */
public class LiftDownPosition extends InstantCommand {
	
	//set a new Lift object
	private Lift lift;
	
	
    public LiftDownPosition() {
    	//sets the lift object as a Lift
    	lift = Robot.LIFT;
    	//using lift object
        requires(lift);
    }

    //Moves the lift in a PID to down position
    protected void initialize() {
    	lift.downPosition();
    }
}
