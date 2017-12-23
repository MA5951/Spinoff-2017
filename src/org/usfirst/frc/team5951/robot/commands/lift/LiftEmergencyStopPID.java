package org.usfirst.frc.team5951.robot.commands.lift;

import org.usfirst.frc.team5951.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LiftEmergencyStopPID extends InstantCommand {

    public LiftEmergencyStopPID() {
        super();
        // Use requires() here to declare subsystem dependencies
         requires(Robot.LIFT);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.LIFT.stopPID();
    }

}
