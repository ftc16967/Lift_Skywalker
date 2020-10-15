//Copyright 2019 FIRST Tech Challenge Team 16967
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
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
public class ArcadeDrive extends OpMode {
    /* Declare OpMode members. */
    DcMotor fL;
    DcMotor fR;
    DcMotor bL;
    DcMotor bR;
    DcMotor elevator;
    //right servo and left servo
    CRServo rF;
    CRServo lF;
    //right wheel intake servo and left wheel intake servo
    Servo lC;
    Servo rC;

    @Override
    public void init() {
        // initializing the DcMotor variables from above.
        fL = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        fR = hardwareMap.get(DcMotor.class, "frontRightMotor");
        bL = hardwareMap.get(DcMotor.class, "backLeftMotor");
        bR = hardwareMap.get(DcMotor.class, "backRightMotor");
    // initializing continuous rotation servos
    rF = hardwareMap.get(CRServo.class, "rightFourbar");
    lF = hardwareMap.get(CRServo.class, "leftFourbar");
    // initializing servos for the claw
    rC = hardwareMap.get(Servo.class, "leftClaw");
    lC = hardwareMap.get(Servo.class, "rightClaw");
    // initializing touch sensors
        // digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        
    //DC motor modes
        fL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
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
        
    //Second controller intake code
    //mecanum strafing
        boolean rb = gamepad1.right_bumper;
        boolean lb = gamepad1.left_bumper;
        
    //gamepad1
        // if else statements for mecanum strafing
        if (rb) {
            fR.setPower(-0.5);
            bR.setPower(0.5);
            fL.setPower(0.5);
            bL.setPower(-0.5);
        } else if (lb) {
            fR.setPower(0.5);
            bR.setPower(-0.5);
            fL.setPower(-0.5);
            bL.setPower(0.5);
        } else {
            fR.setPower(-this.gamepad1.left_stick_y-this.gamepad1.left_stick_x);
            bR.setPower(-this.gamepad1.left_stick_y-this.gamepad1.left_stick_x);
            fL.setPower(-this.gamepad1.left_stick_y+this.gamepad1.left_stick_x);
            bL.setPower(-this.gamepad1.left_stick_y+this.gamepad1.left_stick_x);
        }
    
    //gamepad2
    //four-Bar linkage code
    rF.setPower(this.gamepad1.right_stick_y);
    lF.setPower(-this.gamepad1.right_stick_y);

    //claw intake
    if (this.gamepad1.a){
        rC.setPosition(0);
        lC.setPosition(1);
    }
    else if (this.gamepad1.b)
    {
        rC.setPosition(1);
        lC.setPosition(0);
    }
}
}
