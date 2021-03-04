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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

    private SpeedController leftFollower;
    private SpeedController leftLeader;
    private SpeedController rightFollower;
    private SpeedController rightLeader;
    
    public DifferentialDrive arcade;

    private SpeedControllerGroup left; 
    private SpeedControllerGroup right;  

  public Drivetrain() {
    //not correct
    leftFollower = new WPI_TalonSRX(Constants.RobotMap.kleftFollower);
    leftLeader = new WPI_TalonSRX(Constants.RobotMap.kleftLeader);
    rightFollower = new WPI_TalonSRX(Constants.RobotMap.krightFollower);
    rightLeader = new WPI_TalonSRX(Constants.RobotMap.krightLeader);
    left = new SpeedControllerGroup(leftLeader, leftFollower);
    right = new SpeedControllerGroup(rightLeader, rightFollower);
    arcade = new DifferentialDrive(left, right);

    //set if inverted
    leftLeader.setInverted(false);
    rightLeader.setInverted(false);
    leftFollower.setInverted(false);
    rightFollower.setInverted(false);



  }
    
   public void arcadeDrive(double xSpeed, double zRotation, boolean squaredInputs){
    arcade.arcadeDrive(xSpeed, zRotation, squaredInputs);

  }

    public void stop(double xSpeed, double zRotation, boolean squaredInputs){
    xSpeed = 0;
    zRotation = 0;
    squaredInputs = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
