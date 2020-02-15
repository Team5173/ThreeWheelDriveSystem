package frc.robot;

//WPI Imports
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.*;

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

  //Victor Implementation
  private VictorSP leftSnowblower = new VictorSP(0);
  //private VictorSP rightSnowblower = new VictorSP(1);

  //Differential Drive for our Three Wheel NEO
  private DifferentialDrive threeWheel = new DifferentialDrive(topLeft, topRight);

  //Xbox Controller
  XboxController controller = new XboxController(1);

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;

  public void autonomousInit() {
    bottomLeftFront.follow(topLeft);
    bottomLeftBack.follow(topLeft);

    bottomRightFront.follow(topRight);
    bottomRightBack.follow(topRight);
  }

  public void autonomousPeriodic() {
    
  }


  public void robotInit() {
    topLeft.setInverted(true);

    bottomLeftFront.follow(topLeft);
    bottomLeftBack.follow(topLeft);

    bottomRightFront.follow(topRight);
    bottomRightBack.follow(topRight);
  }

  public void teleopPeriodic() {
    if(controller.getRawAxis(5) > 0.7){
      leftSnowblower.setSpeed(0.7);
      //rightSnowblower.setSpeed(-0.7);
    }else if(controller.getRawAxis(5)< -0.7){
      leftSnowblower.setSpeed(-0.7);
      //rightSnowblower.setSpeed(0.7);
    }

    threeWheel.arcadeDrive(controller.getRawAxis(1), controller.getRawAxis(0));
    }
  }