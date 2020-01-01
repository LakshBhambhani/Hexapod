 
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.laksh.hexapod.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.laksh.hexapod.Robot;
import com.laksh.hexapod.utils.Logger;

/**
 * An example command.  You can replace me with your own command.
 */
public class ReverseTest extends Command {

   private int counter = 1;
   private int seconds;

  public ReverseTest(int seconds) {
	  this.seconds = seconds;
    requires(Robot.body);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(seconds);
    Logger.consoleLog("Seconds: %s", seconds);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() { 
	  if(counter == 1) {
		  for (int side = 0; side < Robot.body.getAllLegs().length; side++) {
				for (int leg = 0; leg < Robot.body.getAllLegs()[side].length; leg++) {
					for (int servo = 0; servo < Robot.body.getAllLegs()[side][leg].length; servo++) {
						Robot.body.getAllLegs()[side][leg][servo].home();

					}
				}

			}
		  System.out.println("Home");
	  }
	  else {
		  for (int side = 0; side < Robot.body.getAllLegs().length; side++) {
				for (int leg = 0; leg < Robot.body.getAllLegs()[side].length; leg++) {
					for (int servo = 0; servo < Robot.body.getAllLegs()[side][leg].length; servo++) {
						Robot.body.getAllLegs()[side][leg][servo].goToMin();

					}
				}

			}
		  System.out.println(0);
	  }
	  counter *= -1;
	  try {
		Thread.sleep(1500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  Logger.consoleLog();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Logger.consoleLog("Seconds: %s", seconds);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
