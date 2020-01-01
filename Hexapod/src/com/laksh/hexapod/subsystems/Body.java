/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.laksh.hexapod.subsystems;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pi4j.component.servo.impl.PCA9685GpioServoDriver;
import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.laksh.hexapod.constants.RobotConstants;
import com.laksh.hexapod.constants.RobotMap;
import com.laksh.hexapod.utils.Logger;

/**
 * Represents a hexapod's body
 * 
 * @author lakshbhambhani
 */
public class Body extends Subsystem {

	private static PCA9685GpioProvider gpioProvider;
	
	private static Hip frontLeftHip;
	private static Hip frontRightHip;
	private static Hip midLeftHip;
	private static Hip midRightHip; 
	private static Hip backLeftHip;
	private static Hip backRightHip; 
	
	private static Foot frontLeftFoot; 
	private static Foot frontRightFoot; 
	private static Foot midLeftFoot;
	private static Foot midRightFoot; 
	private static Foot backLeftFoot;
	private static Foot backRightFoot; 

	public Body() {
		
		final GpioController gpio = GpioFactory.getInstance();
		
		try {
			gpioProvider = createProvider();
		} catch (UnsupportedBusNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frontLeftHip = new Hip(RobotMap.FRONT_LEFT_HIP, false, "frontLeftHip", RobotConstants.frontLeftHipHomePos, 0, 180);
		frontRightHip = new Hip(RobotMap.FRONT_RIGHT_HIP, true, "frontRightHip", RobotConstants.frontRightHipHomePos, 0, 180);
//		midLeftHip = new Hip(RobotMap.MID_LEFT_HIP, false, "midLeftHip", RobotConstants.midLeftHipHomePos, 0, 180);
//		midRightHip = new Hip(RobotMap.MID_RIGHT_HIP, true, "midRightHip", RobotConstants.midRightHipHomePos, 0, 180);
		backLeftHip = new Hip(RobotMap.BACK_LEFT_HIP, false, "backLeftHip", RobotConstants.backLeftHipHomePos, 0, 180);
		backRightHip = new Hip(RobotMap.BACK_RIGHT_HIP, false, "backRightHip", RobotConstants.backRightHipHomePos, 0, 180);
		
		frontLeftFoot = new Foot(RobotMap.FRONT_LEFT_FOOT, true, "frontLeftFoot", RobotConstants.frontLeftFootHomePos, 0, 180);
		frontRightFoot = new Foot(RobotMap.FRONT_RIGHT_FOOT, false, "frontRightFoot", RobotConstants.frontRightFootHomePos, 0, 180);
//		midLeftFoot = new Foot(RobotMap.MID_LEFT_FOOT, true, "midLeftFoot", RobotConstants.midLeftFootHomePos, 0, 180);
//		midRightFoot = new Foot(RobotMap.MID_RIGHT_FOOT, false, "midRightFoot",RobotConstants.midRightFootHomePos, 0, 180);
		backLeftFoot = new Foot(RobotMap.BACK_LEFT_FOOT, false, "backLeftFoot", RobotConstants.backLeftFootHomePos, 0, 180);
		backRightFoot = new Foot(RobotMap.BACK_RIGHT_FOOT, false, "backRightFoot", RobotConstants.backRightFootHomePos, 0, 180);


        // Define outputs in use for this example
        provisionPwmOutputs(gpioProvider);
    
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(null);
	}
	
	private PCA9685GpioProvider createProvider() throws UnsupportedBusNumberException, IOException {
        BigDecimal frequency = PCA9685GpioProvider.ANALOG_SERVO_FREQUENCY;
        BigDecimal frequencyCorrectionFactor = new BigDecimal("1.0578");

        I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
        return new PCA9685GpioProvider(bus, 0x40, frequency, frequencyCorrectionFactor);
    }
	
	private GpioPinPwmOutput[] provisionPwmOutputs(final PCA9685GpioProvider gpioProvider) {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinPwmOutput myOutputs[] = {
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "Servo 00"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_06, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_07, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_08, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_09, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_10, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_11, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_12, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_13, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_14, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_15, "not used")};
        return myOutputs;
    }
	
	public static PCA9685GpioProvider getGpioProvider() {
		return gpioProvider;
	}
	
	public Hip getFrontLeftHip() {
		return frontLeftHip;
	}
	
	public Hip getFrontRightHip() {
		return frontRightHip;
	}
	
	public Hip getMidLeftHip() {
		return midLeftHip;
	}
	
	public Hip getMidRightHip() {
		return midRightHip;
	}
	
	public Hip getBackLeftHip() {
		return backLeftHip;
	}
	
	public Hip getBackRightHip() {
		return backRightHip;
	}
	
	public Foot getFrontLeftFoot() {
		return frontLeftFoot;
	}
	
	public Foot getFrontRightFoot() {
		return frontRightFoot;
	}
	
	public Foot getMidLeftFoot() {
		return midLeftFoot;
	}
	
	public Foot getMidRightFoot() {
		return midRightFoot;
	}
	
	public Foot getBackLeftFoot() {
		return backLeftFoot;
	}
	
	public Foot getBackRightFoot() {
		return backRightFoot;
	}
	
	public ServoSubsystem[] getFrontLeftLeg() {
		 return new ServoSubsystem[]{frontLeftHip, frontLeftFoot};
	}
	
	public ServoSubsystem[] getFrontRightLeg() {
		 return new ServoSubsystem[]{frontRightHip, frontRightFoot};
	}
	
	public ServoSubsystem[] getMidLeftLeg() {
		 return new ServoSubsystem[]{midLeftHip, midLeftFoot};
	}
	
	public ServoSubsystem[] getMidRightLeg() {
		 return new ServoSubsystem[]{midRightHip, midRightFoot};
	}
	
	public ServoSubsystem[] getBackLeftLeg() {
		 return new ServoSubsystem[]{backLeftHip, backLeftFoot};
	}
	
	public ServoSubsystem[] getBackRightLeg() {
		 return new ServoSubsystem[]{backRightHip, backRightFoot};
	}

	public ServoSubsystem[][] getLeftSideLegs() {
		return new ServoSubsystem[][] {getFrontLeftLeg(), getBackLeftLeg()};
	}
	
	public ServoSubsystem[][] getRightSideLegs() {
		return new ServoSubsystem[][] {getFrontRightLeg(), getBackRightLeg()};
	}
	
	public ServoSubsystem[][][] getAllLegs() {
		return new ServoSubsystem[][][] {getLeftSideLegs(), getRightSideLegs()};
	}
	
	public Hip[] getHips() {
		return new Hip[] {getFrontLeftHip(), getFrontRightHip(), getMidLeftHip(), getMidRightHip(), getBackLeftHip(), getBackRightHip()};
	}
	
	public Foot[] getFeet() {
		return new Foot[] {getFrontRightFoot(), getFrontLeftFoot(), getMidLeftFoot(), getMidRightFoot(), getBackLeftFoot(), getBackRightFoot()};
	}
	
	public void logAllServoPositions() {
		Logger.consoleLog("FrontLefHip %s", getFrontLeftHip().getServo().getPosition());
		Logger.consoleLog("FrontRightHip %s", getFrontRightHip().getServo().getPosition());
		Logger.consoleLog("MidLeftHip %s", getMidLeftHip().getServo().getPosition());
		Logger.consoleLog("MidRightHip %s", getMidRightHip().getServo().getPosition());
		Logger.consoleLog("BackLeftHip %s", getBackLeftHip().getServo().getPosition());
		Logger.consoleLog("BackRightHip %s", getBackRightHip().getServo().getPosition());
		Logger.consoleLog("FrontLeftFoot %s", getFrontLeftFoot().getServo().getPosition());
		Logger.consoleLog("FrontRightFoot %s", getFrontRightFoot().getServo().getPosition());
		Logger.consoleLog("MidLeftFoot %s", getMidLeftFoot().getServo().getPosition());
		Logger.consoleLog("MidRightFoot %s", getMidRightFoot().getServo().getPosition());
		Logger.consoleLog("BackLeftFoot %s", getBackLeftFoot().getServo().getPosition());
		Logger.consoleLog("BackRightFoot %s", getBackRightFoot().getServo().getPosition());
	}
	
}
