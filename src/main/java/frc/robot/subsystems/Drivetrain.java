/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.revrobotics.SparkMax;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {

  private final SpeedController leftBack;
  private final SpeedController leftFront;
  private final SpeedController rightBack;
  private final SpeedController rightFront;
    
    public MecanumDrive mecanumDrive;

    private SpeedControllerGroup left; 
    private SpeedControllerGroup right;
    
    

  public Drivetrain() {
    //not correct
    leftBack = new WPI_TalonFX(Constants.RobotMap.kleftBack);
    leftFront = new WPI_TalonFX(Constants.RobotMap.kleftFront);
    rightBack = new WPI_TalonFX(Constants.RobotMap.krightBack);
    rightFront = new WPI_TalonFX(Constants.RobotMap.krightFront);

    //set if inverted
    leftFront.setInverted(true);
    rightFront.setInverted(true);
    leftBack.setInverted(true);
    rightBack.setInverted(true);

    
   mecanumDrive = new MecanumDrive(leftBack, leftFront, rightBack, rightFront);


   mecanumDrive.setDeadband(0.04);

  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
