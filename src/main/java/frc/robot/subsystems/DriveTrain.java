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
 * @author Robert Paul, Aristotle Henderson
 * @version 0.0
 */
public class DriveTrain extends Subsystem {
  
  private VictorSP motorA;
  
  private VictorSP motorB;
  private VictorSP motorC;
  private double theta;
  private double speed;

  private double robotMaxSpeed = 1.0;
  private double robotMaxRotate = 0.5;

  public DriveTrain(){
    motorA = new VictorSP(RobotMap.MOTOR_A_ID);
    motorB = new VictorSP(RobotMap.MOTOR_B_ID);
    motorC = new VictorSP(RobotMap.MOTOR_C_ID);
  }


  /**
   * 3 Wheeled DriveTrain
   * @param xValue
   * @param yValue
   */
  public void holonomicDrive(double xValue, double yValue) {

    double x = xValue;
    double y = -yValue;

    theta = Math.atan(x/(-y)) + Math.toRadians(90); // Finds Angle of movement

    // Below are some edge cases
    if (y < 0) 
      theta = theta + Math.toRadians(180); 
    if (x < 0 && Math.toDegrees(theta) == 0)
      theta = Math.toRadians(180);
    if (x > 0 && Math.toDegrees(theta) == 180)
      theta = Math.toRadians(0); 
    // Above are some edge cases

    double degrees = Math.toDegrees(theta); //Stores Angle as a Degree for ease of math
    double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)); // Finds the magnitude of movement
    speed = r; 
    double convertedTheta = theta; 

    // Corrects theta for the quadrant (I, II, III, IV)
    if (theta > Math.toRadians(90))
      convertedTheta = theta - Math.toRadians(90);
    else if (Math.toDegrees(theta) > 180)
      convertedTheta = theta - Math.toRadians(180);
    else if (Math.toDegrees(theta) > 270)
      convertedTheta = theta - Math.toRadians(360);


    double maxMagnitude;
    
    // Determines the maximum magnitude so that we don't end up with numbers > 1
    if (y > 0 && x > 0 && Math.abs(y) > Math.abs(x)) {
      maxMagnitude = 1/(Math.cos((Math.PI / 2) - convertedTheta));
    }
    else if (y > 0 && x > 0 && Math.abs(y) < Math.abs(x)) {
      maxMagnitude = 1/(Math.cos(convertedTheta));
    }
    else if (Math.abs(y) > Math.abs(x)) {
      maxMagnitude = 1/(Math.cos(convertedTheta));
    }
    else {
      maxMagnitude = 1/(Math.cos((Math.PI / 2) - convertedTheta));
    }

    speed = Math.abs(r / (maxMagnitude * robotMaxSpeed)); 

    if (degrees == 0 || degrees == 90 || degrees == 180 || degrees == 270){
      speed = r;}
    
    if (speed > 1){ // A failsafe, so that if the speed is greater than 1 it is just set to 1
      speed = 1.0;}

    speed = Math.abs(speed);

    double motorATheta = Math.toRadians(90) - theta; // Finds the angle for the motors
    double motorBTheta = Math.toRadians(210) - theta; 
    double motorCTheta = Math.toRadians(330) - theta;

    double aSpeed = speed*Math.sin(motorATheta); // speed for motor A
    double bSpeed = speed*Math.sin(motorBTheta); // " " motor B
    double cSpeed = speed*Math.sin(motorCTheta); // " " motor C

    motorA.set(aSpeed);
    motorB.set(bSpeed);
    motorC.set(cSpeed);
    
  }

  /**
   * Sets motors to the value of z so that the bot spins..
   * 0
   * @param zValue
   */
  public void rotationDrive(double zValue) {
    double z = zValue;
 
    z = z * robotMaxRotate;

    motorA.set(z);
    motorB.set(z);
    motorC.set(z);

  }

  @Override
  public void initDefaultCommand() {}

}
