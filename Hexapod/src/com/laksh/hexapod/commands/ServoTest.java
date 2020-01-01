
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.laksh.hexapod.commands;

import edu.wpi.first.wpilibj.command.Command;
import com.laksh.hexapod.Robot;
import com.laksh.hexapod.subsystems.ServoSubsystem;
import com.laksh.hexapod.utils.Logger;

/**
 * An example command. You can replace me with your own command.
 */
public class ServoTest extends Command {

	private ServoSubsystem[] servos;
	private int timesTested;

	public ServoTest(ServoSubsystem[] servos) {
		this.servos = servos;
		timesTested = 0;
		requires(Robot.body);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Logger.consoleLog("Testing ");
		for(ServoSubsystem s : servos) {
			s.home();
		}
		Robot.body.logAllServoPositions();

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		for(ServoSubsystem s : servos) {
			s.setPosition(s.getServo().getPosition() + 10);
		}
		

		timesTested++;

		Logger.consoleLog(timesTested + " Times Tested");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timesTested == 3;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Logger.consoleLog("Times Tested: %s", timesTested);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
