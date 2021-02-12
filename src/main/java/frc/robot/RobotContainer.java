/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.commands.ExampleCommand;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private static final String OIConstants = null;
  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();
  // The robot's subsystems and commands are defined here...
  private final Joystick joystick1 = new Joystick(Constants.OIConstants.kJoystick1);
  private final Joystick joystick2 = new Joystick(Constants.OIConstants.kJoystick2);
  private final static int leftPower = 0;
  private final static int rightPower = 0;


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    drivetrain.setDefaultCommand(new RunCommand(
        () -> drivetrain.setTank(Math.pow(-joystick1.getY(), 3), Math.pow(joystick2.getY(), 3)), drivetrain));

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      new JoystickButton(joystick1, 2).whenPressed(
        new StartEndCommand (
          ()->drivetrain.setTank( leftPower, rightPower), 
          ()->drivetrain.stop())
      );
      new JoystickButton(joystick1, 1).whileHeld(
        new StartEndCommand(
          ()-> shooter.setPower(0.75),
          ()-> shooter.stop())
        );
  }

public Command getAutonomousCommand() {
	return null;
}


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }*/
}

