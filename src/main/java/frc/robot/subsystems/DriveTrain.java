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
  
  private VictorSP motorA;
  private VictorSP motorB;
  private VictorSP motorC;
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

    theta = Math.atan(x/(-y)) + Math.toRadians(90);

    if (y < 0)
      theta = theta + Math.toRadians(180); 
    if (x < 0 && Math.toDegrees(theta) == 0)
      theta = Math.toRadians(180);
    if (x > 0 && Math.toDegrees(theta) == 180)
      theta = Math.toRadians(0); 
    
    double degrees = Math.toDegrees(theta);
    double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    speed = r;
    double convertedTheta = theta;

    if (theta > Math.toRadians(90))
      convertedTheta = theta - Math.toRadians(90);
    else if (Math.toDegrees(theta) > 180)
      convertedTheta = theta - Math.toRadians(180);
    else if (Math.toDegrees(theta) > 270)
      convertedTheta = theta - Math.toRadians(360);

    double maxMagnitude = 0;

    if (y > 0 && x > 0 && Math.abs(y) > Math.abs(x))
      maxMagnitude = 1/(Math.cos((Math.PI / 2) - convertedTheta));
    else if (y > 0 && x > 0 && Math.abs(y) < Math.abs(x))
      maxMagnitude = 1/(Math.cos(convertedTheta));
    else if (Math.abs(y) > Math.abs(x))
      maxMagnitude = 1/(Math.cos(convertedTheta));
    else
      maxMagnitude = 1/(Math.cos((Math.PI / 2) - convertedTheta));

    speed = Math.abs(r / (maxMagnitude * robotMaxSpeed));

    if (degrees == 0 || degrees == 90 || degrees == 180 || degrees == 270)
      speed = r;

    if (speed > 1)
      speed = 1.0;

    System.out.println("Sp: " + speed + ", D: " + Math.toDegrees(theta));

    speed = Math.abs(speed);

    double motorATheta = Math.toRadians(90) - theta;
    double motorBTheta = Math.toRadians(210) - theta;
    double motorCTheta = Math.toRadians(330) - theta;

    double aSpeed = speed*Math.sin(motorATheta); //< 1.0 ? speed*Math.sin(motorATheta) : 1.0;
    double bSpeed = speed*Math.sin(motorBTheta); //< 1.0 ? speed*Math.sin(motorBTheta) : 1.0;
    double cSpeed = speed*Math.sin(motorCTheta); //< 1.0 ? speed*Math.sin(motorCTheta) : 1.0;

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
