/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private TalonSRX Shooter;

  public Shooter() {
    Shooter = new TalonSRX(Constants.RobotMap.kShooter);

    //set motors to default
    Shooter.configFactoryDefault();

    //set if inverted
    Shooter.setInverted(true);

    //set deadban
    Shooter.configNeutralDeadband(0);

    //neutralMode to brake
    Shooter.setNeutralMode(NeutralMode.Brake);
}

public void stop(){
  Shooter.set(ControlMode.PercentOutput, 0);
}

public void setPower(double power){
  Shooter.set(ControlMode.PercentOutput, power);
}

public class Ramp extends SubsystemBase{
  private TalonSRX Ramp;

  public Ramp() {
    Ramp = new TalonSRX(Constants.RobotMap.kRamp);

    //set motors to default
    Ramp.configFactoryDefault();

    //set if inverted
    Ramp.setInverted(true);

    //set deadban
    Ramp.configNeutralDeadband(0);

    //neutralMode to brake
    Ramp.setNeutralMode(NeutralMode.Brake);
}

public void stop(){
  Ramp.set(ControlMode.PercentOutput, 0);
}

public void setRampPower(double power){
  Ramp.set(ControlMode.PercentOutput, power);
}

}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
