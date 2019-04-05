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

import frc.robot.RobotMap;

/**
 * 3 Wheel Holonomic Drive
 * 
 */
public class DriveTrain extends Subsystem {
  
  private SpeedController motorA;
  private SpeedController motorB;
  private SpeedController motorC;

  public DriveTrain(){
    motorA = new Talon(RobotMap.MOTOR_A_ID);
    motorB = new Talon(RobotMap.MOTOR_B_ID);
    motorC = new Talon(RobotMap.MOTOR_C_ID);
  }


  public void holonomicDrive(double xValue, double yValue) {

    double maxSpeed = 1.0;

    double x = xValue;
    double y = yValue;

    

    double theta = Math.toDegrees(Math.atan(y/x));
    double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    double speed = maxSpeed * r;

    double motorATheta = 90-theta;
    double motorBTheta = 210-theta;
    double motorCTheta = 330-theta;

    double aSpeed = speed*Math.sin(motorATheta) < 1.0 ? speed*Math.sin(motorATheta) : 1.0;
    double bSpeed = speed*Math.sin(motorBTheta) < 1.0 ? speed*Math.sin(motorBTheta) : 1.0;
    double cSpeed = speed*Math.sin(motorCTheta) < 1.0 ? speed*Math.sin(motorCTheta) : 1.0;

    motorA.set(aSpeed);
    motorB.set(bSpeed);
    motorC.set(cSpeed);
    

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
