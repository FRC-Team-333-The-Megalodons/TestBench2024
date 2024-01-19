// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
    public class FlexMotor extends SubsystemBase{
    private CANSparkFlex flexMotor1;
    private CANSparkFlex flexMotor2;
    private DigitalInput pe;

    public FlexMotor() {
        flexMotor1 = new CANSparkFlex(4, MotorType.kBrushless);
        flexMotor2 = new CANSparkFlex(8, MotorType.kBrushless);
        pe = new DigitalInput(3);
    }
    
    public void oneForward(){flexMotor1.set(0.3);}
    public void twoForward(){flexMotor1.set(-0.55); flexMotor2.set(0.55);}
    public void oneBack(){flexMotor1.set(-0.3);}
    public void twoBack(){flexMotor1.set(-0.3); flexMotor2.set(0.3);}
    public void motorStop(){flexMotor1.set(0); flexMotor2.set(0);}

    @Override
    public void periodic(){
        SmartDashboard.putBoolean("NODE?", pe.get());
    }
}
 
