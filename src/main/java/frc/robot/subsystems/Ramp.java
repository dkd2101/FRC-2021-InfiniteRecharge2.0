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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Ramp extends SubsystemBase {
  /**
   * Creates a new Ramp2.
   */
  private final TalonSRX Ramp;
  private final CANSparkMax Lifter;
  
  public Ramp() {
    Ramp = new TalonSRX(Constants.RobotMap.kRamp);
    Lifter = new CANSparkMax(Constants.RobotMap.kLifter, MotorType.kBrushless);

    Ramp.configFactoryDefault();

    // set if inverted
    Ramp.setInverted(true);

    // set deadban
    Ramp.configNeutralDeadband(0);

    // neutralMode to brake
    Ramp.setNeutralMode(NeutralMode.Brake);

    Lifter.setInverted(false);

   
  }

  public void stopRamp() {
    Ramp.set(ControlMode.PercentOutput, 0);
  }

  public void setPowerRamp(final double power) {
    Ramp.set(ControlMode.PercentOutput, power);
  }

  public void setPowerLift(final double power){
    Lifter.set(power);
  }

  public void stopLift(){
    Lifter.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
