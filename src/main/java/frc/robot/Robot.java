/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;


public class Robot extends TimedRobot {
  public static OI oi;
  SendableChooser<Command> chooser = new SendableChooser<>();

  public static DriveTrain dTrain; 
  
  public static Joystick jStick;

  public static boolean rotating;

  @Override
  public void robotInit() {
    oi = new OI();
    dTrain = new DriveTrain();
    jStick = RobotMap.JOYSTICK_A;
    rotating = false;
    SmartDashboard.putData("Auto mode", chooser);
  }

  
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  
  @Override
  public void autonomousInit() {
  }

  
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    if(Math.abs(jStick.getZ()) > 0.4) {
      dTrain.rotationDrive(jStick.getZ());
      System.out.println("rotate");
    }
    else {
      dTrain.holonomicDrive(jStick.getX(), jStick.getY());
      System.out.println("holonomic");
    }
  }

  
  @Override
  public void testPeriodic() {
  }
}