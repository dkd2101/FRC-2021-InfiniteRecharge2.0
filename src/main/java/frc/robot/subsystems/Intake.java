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
  private TalonSRX IntakeFollow;

  public Intake() {
    Intake = new TalonSRX(Constants.RobotMap.kIntake);
    IntakeFollow = new TalonSRX(Constants.RobotMap.kIntakeFollow);

    //set motors to default
    Intake.configFactoryDefault();
    IntakeFollow.configFactoryDefault();

    //set if inverted
    Intake.setInverted(false);
    IntakeFollow.setInverted(false);

    //follow
    IntakeFollow.follow(Intake);

    //set deadban
    Intake.configNeutralDeadband(0);
    IntakeFollow.configNeutralDeadband(0);


    //neutralMode to brake
    Intake.setNeutralMode(NeutralMode.Brake);
    IntakeFollow.setNeutralMode(NeutralMode.Brake);
}

public void stop(){
  Intake.set(ControlMode.PercentOutput, 0);
}

public void setPower(double power) { 
  Intake.set(ControlMode.PercentOutput, 0); 
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}