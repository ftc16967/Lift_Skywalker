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
public class RedLoadzone extends LinearOpMode{
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
    //other Stuff 
    int aproxMm;
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
    // initializing color sensors
    colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
    //DC motor modes
        fL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        fR.setDirection(DcMotorSimple.Direction.REVERSE);
        bR.setDirection(DcMotorSimple.Direction.REVERSE);
        
        
        
        //sensor modes
        // digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        //intake motor modes
        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
    //set power to 0
        fL.setPower(0);
        fR.setPower(0);
        bL.setPower(0);
        bR.setPower(0);

    // Other info.
    // We might need to change direction if inverse
        telemetry.addData("Status", "Initialized");
        fR.setDirection(DcMotorSimple.Direction.REVERSE);
        bR.setDirection(DcMotorSimple.Direction.REVERSE);
        //Place the amount of millimeters as the aproxMm variable
        aproxMm = aproxMm * 4;         // there is 1mm per every 3.836 which rounds to 1mm/4ticks
        
    // Both of the the variables above need to be checked before we actually use them. 
    // If you are to use them make sure to replace the aproxMm variable with the distance variable for all of the motions 
    // How would i use this Code 
    
    /*
    double ticksPerRev = 383.6;
    double distanceTravelledPerRev = 4.0 * Math.PI;

    // later
    motor.getMotorPosition / ticksPerRev * distantTravelledPerRev;
    */
    
    //Currently all of these values for the instances are placeholders for when we edit them for fine tuning
    waitForStart();
    
    
        // fwdBwd(0.5, 5, 500);
        // brake();
        // //color sensor code to detect black(will require testing)
        // // while((colorSensor.red()*colorSensor.green())/Math.pow(colorSensor.blue(), 2) > 3){ //This while loop detects everything except black 
        // //     strafeLeft(.5,100,200);
        // // }
        // brake();
        // closeClamp();
        // fwdBwd(-.5, -100, 200);
        // // lift up elevator to expose the color sensor
        // elevUpDwn(.8, 400, 1000);
        // //strafe until robot is within the build zone an just ahead of the neutral bridge 
        // strafeRight(1, 500, 3000);
        // // while((colorSensor.red()*colorSensor.green())/Math.pow(colorSensor.blue(), 2) > 3){//This while loop detects everything except black
        // //     strafeRight(.8,10,100);
        // // }
        //     // after the color sensor detects the foundation, scooch forward just a little bit 
        //     fwdBwd(.8, 10, 100);
        //     openClamp();
        //     elevUpDwn(-.8, -100, 1000);
        //     closeClamp();
        //     turnRight(.8, 100, 500);
        //     fwdBwd(.5, 100, 200);
        //     openClamp();
        //     // move left 
        //     strafeLeft(.8, 100, 500);
        //     // move directly backwards
        //     fwdBwd(-1, 1000, 500);      //Because our robot has a length of 18 inches it has that much room for error
        //     brake();
    }
     // aproxMm equals how many rotations times 383
     // if you try to use distance it creates decimal values
     
     /*
     This method can be used to make the robot go forward or backwards.
     If you want it to go forwards then set both the power and aproxMm values to positive values.
     milliSeconds value is used for the amount of time the robot will take to perform a specific instance.
     */
     public void fwdBwd(double power, int aproxMm, int milliSeconds){
            fR.setTargetPosition(aproxMm);
        fL.setTargetPosition(aproxMm);
        bR.setTargetPosition(aproxMm);
        bL.setTargetPosition(aproxMm);
        fR.setPower(power);
        fL.setPower(power);
        bR.setPower(power);
        bL.setPower(power);
        sleep(milliSeconds);    
    }
    public void turnRight(double power, int aproxMm, int milliSeconds){
            fR.setTargetPosition(-aproxMm);
        fL.setTargetPosition(aproxMm);
        bR.setTargetPosition(-aproxMm);
        bL.setTargetPosition(aproxMm);
        fR.setPower(-power);
        fL.setPower(power);
        bR.setPower(-power);
        bL.setPower(power);
        sleep(milliSeconds);    
    }
    public void turnLeft(double power, int aproxMm, int milliSeconds){
            fR.setTargetPosition(aproxMm);
        fL.setTargetPosition(-aproxMm);
        bR.setTargetPosition(aproxMm);
        bL.setTargetPosition(-aproxMm);
        fR.setPower(power);
        fL.setPower(-power);
        bR.setPower(power);
        bL.setPower(-power);
        sleep(milliSeconds);    
    }
    public void strafeRight(double power, int aproxMm, int milliSeconds){
            fR.setTargetPosition(-aproxMm);
        fL.setTargetPosition(aproxMm);
        bR.setTargetPosition(aproxMm);
        bL.setTargetPosition(-aproxMm);
        fR.setPower(-power);
        fL.setPower(power);
        bR.setPower(power);
        bL.setPower(-power);
        sleep(milliSeconds);    
    }
    public void strafeLeft(double power, int aproxMm, int milliSeconds){
            fR.setTargetPosition(aproxMm);
        fL.setTargetPosition(-aproxMm);
        bR.setTargetPosition(-aproxMm);
        bL.setTargetPosition(aproxMm);
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
    public void openClamp(){
        rC.setPosition(0.5);
        lC.setPosition(0.5);
        sleep(500);
    }
    public void elevUpDwn(double power, int aproxMm, int milliSeconds) {
        // make the power and encoder tick values positive if you want the elevator to go up and negative to go down
        elevator.setPower(power);
        elevator.setTargetPosition(aproxMm);
        sleep(milliSeconds);    
    }
     public void brake(){
        fR.setPower(0);
        fL.setPower(0);
        bR.setPower(0);
        bL.setPower(0);
        sleep(10);    
    }
}
