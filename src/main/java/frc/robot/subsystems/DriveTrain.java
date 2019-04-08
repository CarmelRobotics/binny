/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

/**
 * 3 Wheel Holonomic Drive
 * 
 */
public class DriveTrain extends Subsystem {
  
  private SpeedController motorA;
  private SpeedController motorB;
  private SpeedController motorC;
  private double theta;
  private double speed;

  public DriveTrain(){
    motorA = new VictorSP(RobotMap.MOTOR_A_ID);
    motorB = new VictorSP(RobotMap.MOTOR_B_ID);
    motorC = new VictorSP(RobotMap.MOTOR_C_ID);
  }


  public void holonomicDrive(double xValue, double yValue) {

    double robotMaxSpeed = 1.0;

    double x = xValue;
    double y = -yValue;

    theta = Math.atan(y/x);
    double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    speed = r;
    double convertedTheta = theta;

    if (theta > Math.toRadians(90))
      convertedTheta = theta - Math.toRadians(90);
    else if (theta > Math.toRadians(180))
      convertedTheta = theta - Math.toRadians(180);
    else if (theta > Math.toRadians(270))
      convertedTheta = theta - Math.toRadians(270);

    double maxMagnitude;
    if (Math.abs(x) > Math.abs(y))
      maxMagnitude = 1/(Math.cos(convertedTheta));
    else
      maxMagnitude = 1/(Math.cos((Math.PI / 2) - convertedTheta));
    speed = r / maxMagnitude * robotMaxSpeed;

    double motorATheta = Math.toRadians(90) - theta;
    double motorBTheta = Math.toRadians(210) - theta;
    double motorCTheta = Math.toRadians(330) - theta;

    double aSpeed = speed*Math.sin(motorATheta); //< 1.0 ? speed*Math.sin(motorATheta) : 1.0;
    double bSpeed = speed*Math.sin(motorBTheta); //< 1.0 ? speed*Math.sin(motorBTheta) : 1.0;
    double cSpeed = speed*Math.sin(motorCTheta); //< 1.0 ? speed*Math.sin(motorCTheta) : 1.0;

    motorA.set(aSpeed);
    motorB.set(bSpeed);
    motorC.set(cSpeed);
    
    System.out.println("D: " + Math.toDegrees(theta) + ", X: " + x + ", Y: " + y);
  }

  public void rotationDrive(double zValue) {
    double z = zValue;

    motorA.set(z);
    motorB.set(z);
    motorC.set(z);

  }

  @Override
  public void initDefaultCommand() {}

}
