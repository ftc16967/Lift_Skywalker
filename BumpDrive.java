//Copyright 2019 FIRST Tech Challenge Team 16967
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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

@TeleOp
public class BumpDrive extends OpMode {
    /* Declare OpMode members. */
RobotHardware robot = new RobotHardware();
    
    @Override
    public void init() {
        //initialize the hardware code from the robot hardware class
    robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        
        robot.rC.setPower(0);
        robot.lC.setPower(0);
    }
    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }
    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
    }
    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
   
    @Override
    public void loop() {
    //drivetrain code
  double x = this.gamepad1.left_stick_x;  //x value is speed for forward and backward
  double y = this.gamepad1.left_stick_y; //y value is strafing left and right
        
  //Second controller intake code
  double elevPwr = this.gamepad2.left_stick_y;

  //gamepad1
  // if else statements for drivetrain
  if(gamepad1.right_bumper) {
     robot.fR.setPower(0.8);
     robot.fL.setPower(-0.8);
     robot.bR.setPower(0.8);
     robot.bL.setPower(-0.8);
  } else if(gamepad1.left_bumper) {
     robot.fR.setPower(-0.8);
     robot.fL.setPower(0.8);
     robot.bR.setPower(-0.8);
     robot.bL.setPower(0.8);
  } else if(gamepad1.right_trigger >.9){
     robot.fR.setPower(0);
     robot.fL.setPower(-1);
     robot.bR.setPower(0);
     robot.bL.setPower(-1); 
  } else if(gamepad1.right_trigger >.9){
     robot.fR.setPower(-1);
     robot.fL.setPower(0);
     robot.bR.setPower(-1);
     robot.bL.setPower(0); 
  } else {
     robot.fR.setPower(y-x);
     robot.fL.setPower(y+x);
     robot.bR.setPower(y+x);
     robot.bL.setPower(y-x);
  }
  
  if (gamepad2.left_bumper)
  {
      robot.rC.setPower(0);
      robot.lC.setPower(0);
  }
  else if (gamepad2.right_bumper)
  {
      robot.rC.setPower(-.3);
      robot.lC.setPower(0.3);
  }
  else if (gamepad1.a)
  {
      robot.rC.setPower(0.3);
      robot.lC.setPower(-0.3);
  }
  else if (gamepad1.b)
  {
      robot.rC.setPower(-0.3);
      robot.lC.setPower(0.3);
  }
  else if (gamepad1.y)
  {
      robot.rC.setPower(0);
      robot.lC.setPower(0);
  }
  else if (gamepad2.a)
  {
      robot.rC.setPower(0.3);
      robot.lC.setPower(-0.3);
  }
  
  
    if(gamepad2.dpad_left){
     robot.cap.setPosition(1);
    } else if(gamepad2.dpad_right){
     robot.cap.setPosition(0);    
    } //else if(setCap){
    //  robot.rC.setPower(1);
    //  robot.lC.setPower(0);
    // } else if(closeClamp){
    //  robot.rC.setPower(0);
    //  robot.lC.setPower(1);
    // } else if(openClamp){
    //  robot.rC.setPower(0.7);
    //  robot.lC.setPower(0.3);
    // }
    
    //elevator
    //Touch Sensor is used so that we don't accidentally break the elevator
    //  if (robot.digitalTouch.getState() == false && elevPwr < 0) {
    //      //false is pressed.
    //      //bottom touch sensor
    //      robot.elevator.setPower(0);
    //      telemetry.addData("Elevator sensor", "PRESSED");
    //  } else if(robot.digitalTouchT.getState() == false && elevPwr > 0) {
    //      //top touch sensor
    //      robot.elevator.setPower(0);
    //      telemetry.addData("Top Elevator sensor", "PRESSED");
    //  } else {
    if (!robot.digitalTouch.getState() && -elevPwr < 0)
    {
        robot.elevator.setPower(0);
    }
    else
     robot.elevator.setPower(-elevPwr);
         //touch sensor is not pressed
         //telemetry.addData("Elevator sensor", "NOT PRESSED");
     //}
     telemetry.addData("Elevator encoder position", robot.elevator.getCurrentPosition());
}
    @Override
    public void stop() {
    }
}
