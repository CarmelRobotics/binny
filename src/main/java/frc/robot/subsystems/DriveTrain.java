/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 3 Wheel Holonomic Drive
 * 
 */
public class DriveTrain extends Subsystem {
  
  private SpeedController motorA;
  private SpeedController motorB;
  private SpeedController motorC;

  public DriveTrain(){
    motorA = new Talon(0);
    motorB = new Talon(1);
    motorC = new Talon(2);
  }


  public void holonomicDrive(double xValue, double yValue) {

    double maxSpeed = 1.0;

    double x = xValue;
    double y = yValue;

    

    double theta = Math.toDegrees(Math.atan(y/x)));
    double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    double speed = maxSpeed * r;

    double aTheta = 90-theta;
    double bTheta = 210-theta;
    double cTheta = 330-theta;

    double aSpeed = speed*Math.sin(aTheta) < 1.0 ? speed*Math.sin(aTheta) : 1.0;
    double bSpeed = speed*Math.sin(bBheta) < 1.0 ? speed*Math.sin(bTheta) : 1.0;
    double cSpeed = speed*Math.sin(cTheta) < 1.0 ? speed*Math.sin(cTheta) : 1.0;

    motorA.set(aSpeed);
    motorB.set(bSpeed);
    motorC.set(cSpeed);
    

  }

  public void rotationDrive(double zValue) {

  }

  @Override
  public void initDefaultCommand() {}



}
