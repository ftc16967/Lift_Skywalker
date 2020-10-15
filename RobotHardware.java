//Copyright 2019 FIRST Tech Challenge Team 16967
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.qualcomm.robotcore.hardware.ColorSensor;


  /*
  Expansion Hub 1:
  DcMotor:
  port 0: frontLeftMotor
  port 1: frontRightMotor
  port 2: backLeftMotor
  port 3: backRightMotor
  
  Servos:
  port 0: leftClamp
  port 1: rightClamp
  
  i2c Ports:
  1st i2c port 0: colorSensor
  */
  
@TeleOp
public class RobotHardware {
    /* Declare OpMode members. */
   public DcMotor fL;
   public DcMotor fR;
   public DcMotor bL;
   public DcMotor bR;
   public DcMotor elevator;
    //right servo and left servo which operate the clamp
   public CRServo rC;
   public CRServo lC;
   public Servo cap;
    //touch sensor declaration
  public DigitalChannel digitalTouch;
//   public DigitalChannel digitalTouchT;
//   public ColorSensor colorSensor;
   //creating the hardware map
   HardwareMap hardwareMap;
   
    public void init(HardwareMap hardwareMap) {
    
  // initializing the DcMotor variables from above.
        fL = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        fR = hardwareMap.get(DcMotor.class, "frontRightMotor");
        bL = hardwareMap.get(DcMotor.class, "backLeftMotor");
        bR = hardwareMap.get(DcMotor.class, "backRightMotor");
    // initializing elevator motor variables
        elevator = hardwareMap.get(DcMotor.class, "elevator");
    // initializing servos for the claw
    lC = hardwareMap.get(CRServo.class, "leftClamp");
    rC = hardwareMap.get(CRServo.class, "rightClamp");
    cap = hardwareMap.get(Servo.class, "cappingServo");
    // initializing touch sensors
        digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        // digitalTouchT = hardwareMap.get(DigitalChannel.class, "digitalTouchT");
    // initializing color sensors
    // colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
    
    //DC motor modes
        fL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //sensor modes
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
    // digitalTouchT.setMode(DigitalChannel.Mode.INPUT);
        //intake motor modes
        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
    //set power to 0
        fL.setPower(0);
        fR.setPower(0);
        bL.setPower(0);
        bR.setPower(0);
        //set elevator power to 0
        elevator.setPower(0);

        //zero power behavior
        fL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    //set servo(regular servos) position for the claw
    rC.setPower(0);
    lC.setPower(0);
    cap.setPosition(1);
    // Other info.
    fR.setDirection(DcMotorSimple.Direction.REVERSE);
    bR.setDirection(DcMotorSimple.Direction.REVERSE);
    elevator.setDirection(DcMotorSimple.Direction.FORWARD);
    }
} 
