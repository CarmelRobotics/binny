/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class RotateEnd extends Command {

  public RotateEnd() {

  }
  @Override
  protected void initialize() {
    System.out.println("RotateEnd");
  }
  @Override
  protected void execute() {
    RobotMap.rotating = false; // Setting back to Holonomic drive
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
