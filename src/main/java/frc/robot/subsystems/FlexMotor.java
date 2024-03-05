// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkAbsoluteEncoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
    public class FlexMotor extends SubsystemBase{
        private CANSparkFlex motor;
        private SparkAbsoluteEncoder encoder;
        private PIDController pidController; 


    public FlexMotor() {
        motor = new CANSparkFlex(2, MotorType.kBrushless);
        motor.setIdleMode(IdleMode.kBrake);
        pidController = new PIDController(0.1, 0, 0);
        encoder = motor.getAbsoluteEncoder(com.revrobotics.SparkAbsoluteEncoder.Type.kDutyCycle);
        pidController.enableContinuousInput(-1, 1); }
    public void spin() {motor.set(0.4);}
    public void stop() {motor.set(0);}
    public void testPIDController(){motor.set(pidController.calculate(encoder.getPosition(),0.12666
        
        ));}
    public void getPosition(){ encoder.getPosition();}
    public boolean atSetpoint(){
        if(encoder.getPosition() == 0.364){
            return true;
        } else { return false;}
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Encoder value", encoder.getPosition());
        SmartDashboard.putBoolean("is at position", atSetpoint());
    }
 }
