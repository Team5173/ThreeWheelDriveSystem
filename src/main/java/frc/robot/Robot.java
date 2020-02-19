package frc.robot;

//WPI Imports
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.*;

//Rev Imports
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

public class Robot extends TimedRobot {
  //Left Side Spark Max's
  private CANSparkMax bottomLeftBack = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax bottomLeftFront = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax topLeft = new CANSparkMax(3, MotorType.kBrushless); 

  //Right Side Spark Max's
  /*private CANSparkMax bottomRightBack = new CANSparkMax(4, MotorType.kBrushless);
  private CANSparkMax bottomRightFront = new CANSparkMax(5, MotorType.kBrushless);
  private CANSparkMax topRight = new CANSparkMax(6, MotorType.kBrushless);*/

//private CANSparkMax leftSpin = new CANSparkMax(8, MotorType.kBrushless);
//private CANSparkMax rightSpin = new CANSparkMax(9, MotorType.kBrushless);

  //Victor Implementation
  //private VictorSP leftSnowblower = new VictorSP(0);
  //private VictorSP rightSnowblower = new VictorSP(1);

  //Differential Drive for our Three Wheel NEO
  //private DifferentialDrive threeWheel = new DifferentialDrive(topLeft, topRight);

  //Xbox Controller
  XboxController controller = new XboxController(0);

  //double distance;

  //double circumfrence;

  //CANEncoder encoder;

  private Timer time = new Timer();

  //double CPR = encoder.getCountsPerRevolution();
  //double pos = encoder.getPosition();

  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;

  public void autonomousInit() {
    /*bottomLeftFront.follow(topLeft);
    bottomLeftBack.follow(topLeft);

    bottomRightFront.follow(topRight);
    bottomRightBack.follow(topRight);*/

    time.reset();

    time.start();
  }

  public void autonomousPeriodic() {
    //circumfrence = 2 * Math.PI * 3;

    //distance = (pos/CPR) * circumfrence;


  }


  public void robotInit() {
    topLeft.setInverted(true);

    bottomLeftFront.follow(topLeft);
    bottomLeftBack.follow(topLeft);

    //bottomRightFront.follow(topRight);
    //bottomRightBack.follow(topRight);

    //leftSpin.setInverted(true);
  }

  public void teleopPeriodic() {
    /*if(controller.getRawAxis(5) > 0.7){
      leftSnowblower.setSpeed(0.7);
      //rightSnowblower.setSpeed(-0.7);
    }else if(controller.getRawAxis(5)< -0.7){
      leftSnowblower.setSpeed(-0.7);
      //rightSnowblower.setSpeed(0.7);
    }else {
      leftSnowblower.set(0);
    }*/

    /*if(controller.getRawButton(5) == true){
      leftSpin.set(0.5);
      rightSpin.set(0.5);
    }else if(controller.getRawButton(6) == true){
      leftSpin.set(-0.5);
      rightSpin.set(-0.5);
    }else{
      leftSpin.set(0);
      rightSpin.set(0);
    }*/

    if(controller.getRawAxis(1) > 0.6){
      topLeft.set(1);
      
    }else if(controller.getRawAxis(0) > .5){
      topLeft.set(-1);
    }else{
      topLeft.set(0.0);
    }

    //threeWheel.arcadeDrive(controller.getRawAxis(1), controller.getRawAxis(0));
    }
  }