/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class Rotate extends Command {
  public Rotate() {
  }
  @Override
  protected void initialize() {
  }
  @Override
  protected void execute() {
    RobotMap.rotating = true;
  }
  @Override
  protected boolean isFinished() {
    return false;
  }
  @Override
  protected void end() {
    RobotMap.rotating = false;
  }
  @Override
  protected void interrupted() {
  }
}
