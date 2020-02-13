package frc.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//WPI Imports
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;

//Rev Imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  //Left Side Spark Max's
  private CANSparkMax bottomLeftBack = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax bottomLeftFront = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax topLeft = new CANSparkMax(3, MotorType.kBrushless); 

  //Right Side Spark Max's
  private CANSparkMax bottomRightBack = new CANSparkMax(4, MotorType.kBrushless);
  private CANSparkMax bottomRightFront = new CANSparkMax(5, MotorType.kBrushless);
  private CANSparkMax topRight = new CANSparkMax(6, MotorType.kBrushless);

  //Left and Right SpeedControllerGroups for our Three Motor Drivetrain
  SpeedControllerGroup left = new SpeedControllerGroup(topLeft, bottomLeftFront, bottomLeftBack);
  SpeedControllerGroup right = new SpeedControllerGroup(topRight, bottomRightFront, bottomRightBack);

  //Differential Drive for our Three Wheel NEO
  private DifferentialDrive threeWheel = new DifferentialDrive(left, right);

  //Xbox Controller
  XboxController controller = new XboxController(1);

  public void robotInit() {
    left.setInverted(true);

    threeWheel.arcadeDrive(controller.getRawAxis(1), controller.getRawAxis(0));
  }

  public void teleopPeriodic() {
    
  }
}
