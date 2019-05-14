/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class RotateStart extends Command {

  public RotateStart() {

  }
  @Override
  protected void initialize() {
    System.out.println("RotateStart");
  }
  @Override
  protected void execute() {
    RobotMap.rotating = true; // Setting to Rotation Drive
  }
  @Override
  protected boolean isFinished() {
    return true;
  }
  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
