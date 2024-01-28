// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlexMotor;
import frc.robot.subsystems.Leds;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS5Controller;
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
  private final Leds m_Leds = new Leds();


  private final JoystickButton intakeBut = new JoystickButton(joy, PS5Controller.Button.kR1.value);
  private final JoystickButton outakeBut  = new JoystickButton(joy, PS5Controller.Button.kL1.value); 
  private final JoystickButton shooFastBut = new JoystickButton(joy, PS5Controller.Button.kR2.value);
  private final JoystickButton shootSlowBut = new JoystickButton(joy, PS5Controller.Button.kL2.value);
  private final JoystickButton LedBut = new JoystickButton(joy, PS5Controller.Button.kTouchpad.value);
  private final JoystickButton PIDButtonOne = new JoystickButton(joy, PS5Controller.Button.kCircle.value);
  private final JoystickButton PIDButtonZero = new JoystickButton(joy, PS5Controller.Button.kCross.value);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    
    m_FlexMotor.setDefaultCommand(new RunCommand(() -> m_FlexMotor.everythingStop(), m_FlexMotor));
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
    intakeBut.whileTrue(new RunCommand(()   -> m_FlexMotor.intake()));
    intakeBut.whileFalse(new RunCommand(()  -> m_FlexMotor.intakeStop()));  // One motor shoot (upper one)

    outakeBut.whileTrue(new RunCommand(()   -> m_FlexMotor.outake())); // Shoot
    outakeBut.whileFalse(new RunCommand(()  -> m_FlexMotor.intakeStop()));

    shooFastBut.whileTrue(new RunCommand(()   -> m_FlexMotor.shootFast()));   // One motor intake (upper one)
    shooFastBut.whileFalse(new RunCommand(()  -> m_FlexMotor.shootStop()));

    shootSlowBut.whileTrue(new RunCommand(()   -> m_FlexMotor.shootSlow()));   // Intake 
    shootSlowBut.whileFalse(new RunCommand(()  -> m_FlexMotor.shootStop()));

    LedBut.whileTrue(new RunCommand(() -> m_Leds.royalBlueLED()));
    LedBut.whileFalse(new RunCommand(() -> m_Leds.orangeLED()));

    PIDButtonOne.whileTrue(new RunCommand(() -> m_FlexMotor.toSetPoint()));
    PIDButtonZero.whileTrue(new RunCommand(() -> m_FlexMotor.setToZero()));
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}