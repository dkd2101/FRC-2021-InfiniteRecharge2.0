/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    public static final class RobotMap{
        public static int kleftFollower = 4;
        public static int kleftLeader = 3;
        public static int krightFollower = 1;
        public static int krightLeader = 2;
        public static int kShooter = 5;
        public static int kIntake = 6;
        public static int kRamp = 7;
        public static int kShooter2 = 8;
        public static int kLifter = 9;
    }

    public static final class OIConstants{
        public static int kJoystick1 = 1;
        public static int kJoystick2 = 2;
    }
}

