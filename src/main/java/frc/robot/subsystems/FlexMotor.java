// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
    public class FlexMotor extends SubsystemBase{
    private CANSparkFlex testPIDMotor;
    private PIDController pidController;
    private DutyCycleEncoder testEncoder;


    public FlexMotor() {
//         intakeMotor = new CANSparkFlex(6, MotorType.kBrushless);
//         intakeMotor.setIdleMode(IdleMode.kCoast);

//          shooterMotor1 = new CANSparkFlex(7, MotorType.kBrushless);
//          shooterMotor1.setIdleMode(IdleMode.kCoast);
//          shooterMotor2 = new CANSparkFlex(8, MotorType.kBrushless);
//          shooterMotor2.setIdleMode(IdleMode.kCoast);

    testPIDMotor = new CANSparkFlex(2, MotorType.kBrushless);
    testPIDMotor.setIdleMode(IdleMode.kBrake);

    testEncoder = new DutyCycleEncoder(6);
    testEncoder.setConnectedFrequencyThreshold(900);
    testEncoder.reset();
    pidController = new PIDController(0.354, 0, 0);
    // pidController.setP(0.5);
    // pidController.setI(0);
    // pidController.setD(0);
    // pidController.setFF(0);
    // pidController.setOutputRange(0, 1);
    // pidController.setPositionPIDWrappingEnabled(true);
;
    }
    public void toSetPOint() {
        testPIDMotor.set(pidController.calculate(testEncoder.getDistance(), 0.345));
    }

    public void run () {
        testPIDMotor.set(0.3);
    }

    public void stop () {
        testPIDMotor.set(0);
    }

    public boolean atSetpoint() {
        if (testEncoder.getAbsolutePosition() == 0.345) {
            return true;
        } else {
            return false;
        }
    }
// Calculates the output of the PID algorithm based on the sensor reading
// and sends it to a motor
    
//     public void intake(){intakeMotor.set(0.3);}
//     public void outake(){intakeMotor.set(-0.3);}
//     public void intakeStop(){intakeMotor.set(0);}
//     public void shootSlow(){shooterMotor1.set(-0.4); shooterMotor2.set(0.4);}
//     public void shootFast(){shooterMotor1.set(-1); shooterMotor2.set(1);}
//     public void shootStop(){shooterMotor1.set(0);shooterMotor2.set(0);}

//     public void everythingStop(){shooterMotor1.set(0);shooterMotor2.set(0);intakeMotor.set(0);}

//     public boolean detectNote(){
//         if (peLeft.get() || peRight.get()){
//             return true;
//         } else {return false; }
//     }
     @Override
     public void periodic(){
//         SmartDashboard.putBoolean("Left", peLeft.get());
//         SmartDashboard.putBoolean("Right", peRight.get());
//         SmartDashboard.putBoolean("GetNote", detectNote());

        SmartDashboard.putNumber("encoder", testEncoder.getAbsolutePosition());
         SmartDashboard.putBoolean("Encoder at positoin?", pidController.atSetpoint());

     }
 }
