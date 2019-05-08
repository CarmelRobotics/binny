/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Rotate extends Command {
  
  boolean r = Robot.rotating;

  public Rotate() {

  }
  @Override
  protected void initialize() {
    System.out.println("button pressed");
  }
  @Override
  protected void execute() {
    if (r)
      Robot.rotating = false;
    else
      Robot.rotating = true;
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
    Robot.rotating = false;
  }
}
