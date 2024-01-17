// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlexMotor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final FlexMotor m_FlexMotor = new FlexMotor();
  private final Joystick joy = new Joystick(0);

  private final JoystickButton OneForBut = new JoystickButton(joy, 2);
  private final JoystickButton TwoForBut = new JoystickButton(joy, 4);
  private final JoystickButton OneBackBut = new JoystickButton(joy, 3);
  private final JoystickButton TwoBackBut = new JoystickButton(joy, 5);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    
    m_FlexMotor.setDefaultCommand(new RunCommand(() -> m_FlexMotor.motorStop(), m_FlexMotor));
    configureButtonBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.  ..
   */

   private void configureButtonBindings() {
    OneForBut.whileTrue(new RunCommand(()     -> m_FlexMotor.oneForward()));
    TwoForBut.whileTrue(new RunCommand(()     -> m_FlexMotor.twoForward()));
    OneBackBut.whileTrue(new RunCommand(()     -> m_FlexMotor.oneBack()));
    TwoBackBut.whileTrue(new RunCommand(()     -> m_FlexMotor.twoBack()));
  
  /* Driver Buttons  and their actions*/}
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous 
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}