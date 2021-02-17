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

public class Intake extends SubsystemBase {
  private TalonSRX Intake;

  public Intake() {
    Intake = new TalonSRX(Constants.RobotMap.kIntake);

    //set motors to default
    Intake.configFactoryDefault();

    //set if inverted
    Intake.setInverted(false);

    //set deadban
    Intake.configNeutralDeadband(0);

    //neutralMode to brake
    Intake.setNeutralMode(NeutralMode.Brake);
}

public void stop(){
  Intake.set(ControlMode.PercentOutput, 0);
}

public void setVelocity(double rpm) {
  //Convert Revolutions per Minute (RPM) to Cycles per 100 milliseconds (cpm) for closed loop controller
  double cpm = rpm * 600 / 8192; 
  Intake.set(ControlMode.Velocity, cpm); 
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}