
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.laksh.hexapod.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.laksh.hexapod.Robot;
import com.laksh.hexapod.subsystems.Body;
import com.laksh.hexapod.subsystems.ServoSubsystem;
import com.laksh.hexapod.utils.Logger;

/**
 * An example command. You can replace me with your own command.
 */
public class HomeAll extends Command {

	public HomeAll() {
		requires(Robot.body);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(2);
		for (int side = 0; side < Robot.body.getAllLegs().length; side++) {
			for (int leg = 0; leg < Robot.body.getAllLegs()[side].length; leg++) {
				for (int servo = 0; servo < Robot.body.getAllLegs()[side][leg].length; servo++) {
					Robot.body.getAllLegs()[side][leg][servo].home();

				}
			}

		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	// Called once after isFinished returns true
	  @Override
	  protected void end() {
		  Robot.body.logAllServoPositions();
	  }

}
