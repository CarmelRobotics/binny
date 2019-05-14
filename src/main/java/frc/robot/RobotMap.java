/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  /* IDs */
  public static final int JOYSTICK_A_ID = 0;
  public static final int ROTATION_BUTTON_ID = 5;

  public static final int MOTOR_A_ID = 0;
  public static final int MOTOR_B_ID = 1;
  public static final int MOTOR_C_ID = 2;

  public static boolean rotating = false;

  /* Joystick and Buttons */
  public static final Joystick JOYSTICK_A = new Joystick(JOYSTICK_A_ID);

  public static final JoystickButton ROTATION_BUTTON = new JoystickButton(JOYSTICK_A, ROTATION_BUTTON_ID);

  /*Various other Variables*/
}
