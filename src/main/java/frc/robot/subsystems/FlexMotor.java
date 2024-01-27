// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
    public class FlexMotor extends SubsystemBase{
    private CANSparkFlex flexMotor1;
    private CANSparkFlex flexMotor2;
    private CANSparkFlex flexMotor3;
    private DutyCycleEncoder encoder;
    private PIDController pidThing = new PIDController(0.3, 0, 0);

    private DigitalInput pe;

    public FlexMotor() {
        flexMotor1 = new CANSparkFlex(5, MotorType.kBrushless);
        flexMotor1.setIdleMode(IdleMode.kCoast);

        flexMotor2 = new CANSparkFlex(8, MotorType.kBrushless);
        flexMotor2.setIdleMode(IdleMode.kCoast);

        flexMotor3 = new CANSparkFlex(7, MotorType.kBrushless);
        flexMotor3.setIdleMode(IdleMode.kCoast);
        encoder = new DutyCycleEncoder(0);
        encoder.setConnectedFrequencyThreshold(900);
        encoder.reset();

        pe = new DigitalInput(3);
        pidThing.enableContinuousInput(0, 1);
    }
    
    public void oneForward(){flexMotor1.set(0.3);}
    public void twoForward(){flexMotor1.set(1); flexMotor2.set(1);}

    public void oneBack(){flexMotor1.set(-0.3);}
    public void twoBack(){flexMotor1.set(-0.3); flexMotor2.set(-0.3);}

    //public void intakeMotorIN(){flexMotor3.set(-0.3);}
    //public void intakeMotorStop(){flexMotor3.set(0);}

    public void motorStop(){flexMotor1.set(0); flexMotor2.set(0);}

    public void toSetPoint(){
        flexMotor3.set(pidThing.calculate(encoder.getAbsolutePosition(), 0.5)); 
    }

    public void setToZero(){
        flexMotor3.set(pidThing.calculate(encoder.getAbsolutePosition(), 0));
    }


    public boolean detect() {
        if (pe.get()) {
            return true;
        } else { return false;  }
    }

    public boolean atSetPoint() {
        if (encoder.getAbsolutePosition() == 0){
            return true;
        } else {
            return false;
        }
    }

    /*public void intakeIn() {
       do { intakeMotorStop();
        } while (detect());
    }*/
    @Override
    public void periodic(){
        SmartDashboard.putBoolean("NODE?", detect());
        //intakeIn();
        SmartDashboard.putNumber("encoder", encoder.get());
        SmartDashboard.getBoolean("Encoder at positoin?", atSetPoint());
}
    }
