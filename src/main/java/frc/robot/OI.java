/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private static Joystick jStick;
  private static JoystickButton rotation;
  
  public static void initialize() {
    jStick = RobotMap.JOYSTICK_A;
    
    rotation = RobotMap.ROTATION_BUTTON;

    rotation.whileHeld(new Rotate());
  }
  
}
