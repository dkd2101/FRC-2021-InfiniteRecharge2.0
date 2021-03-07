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
//import com.revrobotics.SparkMax;

//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private TalonSRX leftFollower;
    private TalonSRX leftLeader;
    private TalonSRX rightFollower;
    private TalonSRX rightLeader;

  public Drivetrain() {

    leftFollower = new TalonSRX(Constants.RobotMap.kleftFollower);
    leftLeader = new TalonSRX(Constants.RobotMap.kleftLeader);
    rightFollower = new TalonSRX(Constants.RobotMap.krightFollower);
    rightLeader = new TalonSRX(Constants.RobotMap.krightLeader);

  


    //set motors to default
    leftFollower.configFactoryDefault();
    leftLeader.configFactoryDefault();
    rightFollower.configFactoryDefault();
    rightLeader.configFactoryDefault();

    //set if inverted
    leftLeader.setInverted(true);
    rightLeader.setInverted(true);
    leftFollower.setInverted(true);
    rightFollower.setInverted(true);

    //set motors to follow
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);

    //set deadban
    leftFollower.configNeutralDeadband(0);
    rightFollower.configNeutralDeadband(0);

    //neutralMode to brake
    leftFollower.setNeutralMode(NeutralMode.Brake);
    rightFollower.setNeutralMode(NeutralMode.Brake);
    leftLeader.setNeutralMode(NeutralMode.Brake);
    rightLeader.setNeutralMode(NeutralMode.Brake);

    }
    
    public void stop(){
      leftLeader.set(ControlMode.PercentOutput, 0);
      rightLeader.set(ControlMode.PercentOutput, 0);
    } 

    public void setTank(double leftPower, double rightPower){
      leftLeader.set(ControlMode.PercentOutput, leftPower);
      rightLeader.set(ControlMode.PercentOutput, rightPower);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
