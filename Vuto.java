package org.firstinspires.ftc.teamcode.Drivetrain;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class Vuto extends LinearOpMode{
   //declare opmode members 
        /* Declare OpMode members. */
   DcMotor fL;
   DcMotor fR;
   DcMotor bL;
   DcMotor bR;
   DcMotor elevator;
    //right servo and left servo which operate the clamp
   Servo rC;
   Servo lC;
   Servo cap;
    //touch sensor declaration
   DigitalChannel digitalTouch;
   DigitalChannel digitalTouchT;
   ColorSensor colorSensor;

    public void runOpMode(){
    //initialize the hardware code from the robot hardware class
    // initializing the DcMotor variables from above.
        fL = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        fR = hardwareMap.get(DcMotor.class, "frontRightMotor");
        bL = hardwareMap.get(DcMotor.class, "backLeftMotor");
        bR = hardwareMap.get(DcMotor.class, "backRightMotor");
    // initializing continuous rotation servos
    // initializing servos for the claw
    rC = hardwareMap.get(Servo.class, "leftClaw");
    lC = hardwareMap.get(Servo.class, "rightClaw");
    // initializing touch sensors
        // digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        
    //DC motor modes
        fL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //sensor modes
        // digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        //intake motor modes
        // elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
    //set power to 0
        fL.setPower(0);
        fR.setPower(0);
        bL.setPower(0);
        bR.setPower(0);
        
    //zero power behavior
        

    // Other info.
    // We might need to change direction if inverse
        telemetry.addData("Status", "Initialized");
        fR.setDirection(DcMotorSimple.Direction.REVERSE);
        bR.setDirection(DcMotorSimple.Direction.REVERSE);
    //double rotation *= 383.6;    // there are 383.6 encoder ticks in one rotation of 3606 gobilda mecanum wheel     
    //double distance *= 3.836;     // there is 1mm per every 3.836
    // Both of the the variables above need to be checked before we actually use them. 
    // If you are to use them make sure to replace the encoderTicks variable with the distance variable for all of the motions 
    // How would i use this Code 
    
    /*
    double ticksPerRev = 383.6;
    double distanceTravelledPerRev = 4.0 * Math.PI;

    // later
    motor.getMotorPosition / ticksPerRev * distanTravelledPerRev;
    */
    
    waitForStart();
        fwdBwd(0.5, 383, 500);
        
        //example color sensor code that uses combined color value of that the color sensor detects
        while(colorSensor.argb()<1){
            
        }
           
        }
    
     /*
     This method can be used to make the robot go forward or backwards.
     If you want it to go forwards then set both the power and encoderTicks values to positive values.
     milliSeconds value is used for the amount of time the robot will take to perform a specific instance.
     */
     public void fwdBwd(double power, int encoderTicks, int milliSeconds){
            fR.setTargetPosition(encoderTicks);
        fL.setTargetPosition(encoderTicks);
        bR.setTargetPosition(encoderTicks);
        bL.setTargetPosition(encoderTicks);
        fR.setPower(power);
        fL.setPower(power);
        bR.setPower(power);
        bL.setPower(power);
        sleep(milliSeconds);    
    }
    public void turnRight(double power, int encoderTicks, int milliSeconds){
            fR.setTargetPosition(-encoderTicks);
        fL.setTargetPosition(encoderTicks);
        bR.setTargetPosition(-encoderTicks);
        bL.setTargetPosition(encoderTicks);
        fR.setPower(-power);
        fL.setPower(power);
        bR.setPower(-power);
        bL.setPower(power);
        sleep(milliSeconds);    
    }
    public void turnLeft(double power, int encoderTicks, int milliSeconds){
            fR.setTargetPosition(encoderTicks);
        fL.setTargetPosition(-encoderTicks);
        bR.setTargetPosition(encoderTicks);
        bL.setTargetPosition(-encoderTicks);
        fR.setPower(power);
        fL.setPower(-power);
        bR.setPower(power);
        bL.setPower(-power);
        sleep(milliSeconds);    
    }
    public void strafeRight(double power, int encoderTicks, int milliSeconds){
            fR.setTargetPosition(-encoderTicks);
        fL.setTargetPosition(encoderTicks);
        bR.setTargetPosition(encoderTicks);
        bL.setTargetPosition(-encoderTicks);
        fR.setPower(-power);
        fL.setPower(power);
        bR.setPower(power);
        bL.setPower(-power);
        sleep(milliSeconds);    
    }
    public void strafeLeft(double power, int encoderTicks, int milliSeconds){
            fR.setTargetPosition(encoderTicks);
        fL.setTargetPosition(-encoderTicks);
        bR.setTargetPosition(-encoderTicks);
        bL.setTargetPosition(encoderTicks);
        fR.setPower(power);
        fL.setPower(-power);
        bR.setPower(-power);
        bL.setPower(power);
        sleep(milliSeconds);    
    }
    public void closeClamp(){
        rC.setPosition(1);
        lC.setPosition(0);
        sleep(500);    
    }
    public void elevUpDwn(double power, int encoderTicks, int milliSeconds) {
        // make the power and encoder tick values positive if you want the elevator to go up and negative to go down
        elevator.setTargetPosition(encoderTicks);
        elevator.setPower(power);
        sleep(milliSeconds);    
    }
}
