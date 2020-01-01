
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
 * An example command. You can replace me with your own command.
 */
public class TripodGait extends Command {

	private int counter = 1;
	private int steps, stepsTaken;

	private int delay = 100;

	public TripodGait(int steps) {
		this.steps = steps;
		stepsTaken = 0;
		requires(Robot.body);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Logger.consoleLog("Steps: %s", steps);

		for (int side = 0; side < Robot.body.getAllLegs().length; side++) {
			for (int leg = 0; leg < Robot.body.getAllLegs()[side].length; leg++) {
				for (int servo = 0; servo < Robot.body.getAllLegs()[side][leg].length; servo++) {
					Robot.body.getAllLegs()[side][leg][servo].home();

				}
			}

		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot.body.logAllServoPositions();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		Robot.body.getFrontRightFoot().setPosition(Robot.body.getFrontRightFoot().getServo().getPosition() + 30);
		Robot.body.getMidLeftFoot().setPosition(Robot.body.getMidLeftFoot().getServo().getPosition() + 30);
		Robot.body.getBackRightFoot().setPosition(Robot.body.getBackRightFoot().getServo().getPosition() + 30);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Robot.body.getFrontLeftHip().setPosition(Robot.body.getFrontLeftHip().getServo().getPosition() - 20);
		Robot.body.getMidRightHip().setPosition(Robot.body.getMidRightHip().getServo().getPosition() - 20);
		Robot.body.getBackLeftHip().setPosition(Robot.body.getBackLeftHip().getServo().getPosition() - 20);

//	  try {
//			Thread.sleep(delay);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Robot.body.getFrontRightHip().setPosition(Robot.body.getFrontRightHip().getServo().getPosition() + 20);
		Robot.body.getMidLeftHip().setPosition(Robot.body.getMidLeftHip().getServo().getPosition() + 20);
		Robot.body.getBackRightHip().setPosition(Robot.body.getBackRightHip().getServo().getPosition() + 20);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Robot.body.getFrontRightFoot().setPosition(Robot.body.getFrontRightFoot().getServo().getPosition() - 30);
		Robot.body.getMidLeftFoot().setPosition(Robot.body.getMidLeftFoot().getServo().getPosition() - 30);
		Robot.body.getBackRightFoot().setPosition(Robot.body.getBackRightFoot().getServo().getPosition() - 30);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// OTHER SIDE

		Robot.body.getFrontLeftFoot().setPosition(Robot.body.getFrontLeftFoot().getServo().getPosition() + 30);
		Robot.body.getMidRightFoot().setPosition(Robot.body.getMidRightFoot().getServo().getPosition() + 30);
		Robot.body.getBackLeftFoot().setPosition(Robot.body.getBackLeftFoot().getServo().getPosition() + 30);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Robot.body.getFrontRightHip().setPosition(Robot.body.getFrontRightHip().getServo().getPosition() - 20);
		Robot.body.getMidLeftHip().setPosition(Robot.body.getMidLeftHip().getServo().getPosition() - 20);
		Robot.body.getBackRightHip().setPosition(Robot.body.getBackRightHip().getServo().getPosition() - 20);

//	  try {
//			Thread.sleep(delay);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Robot.body.getFrontLeftHip().setPosition(Robot.body.getFrontLeftHip().getServo().getPosition() + 20);
		Robot.body.getMidRightHip().setPosition(Robot.body.getMidRightHip().getServo().getPosition() + 20);
		Robot.body.getBackLeftHip().setPosition(Robot.body.getBackLeftHip().getServo().getPosition() + 20);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Robot.body.getFrontLeftFoot().setPosition(Robot.body.getFrontLeftFoot().getServo().getPosition() - 30);
		Robot.body.getMidRightFoot().setPosition(Robot.body.getMidRightFoot().getServo().getPosition() - 30);
		Robot.body.getBackLeftFoot().setPosition(Robot.body.getBackLeftFoot().getServo().getPosition() - 30);

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stepsTaken++;

		Logger.consoleLog(stepsTaken + " Steps Done");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return stepsTaken == steps;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Logger.consoleLog("Steps: %s", steps);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
