package org.usfirst.frc.team5951.robot.commands.ballShakers;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.BallShakers;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShakeDown extends InstantCommand {

	private BallShakers ballShakers;
	
    public ShakeDown() {
        this.ballShakers = Robot.BALL_SHAKERS;
        requires(this.ballShakers);
    }

    // Called once when the command executes
    protected void initialize() {
    	this.ballShakers.shakeDown();
    }

}
