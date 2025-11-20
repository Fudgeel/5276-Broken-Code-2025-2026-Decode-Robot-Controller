package org.firstinspires.ftc.teamcode.mechanisms;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;




public class LiftMechanism {

    double upSpeed = 1.0;
    double downSpeed = 1.0;
    double ticks = 537.7/2; // 312 motor w/2:1 ratio
    double rotationCount = (19.5/2.54)/12.2;
    // 19.5 in (extension length) / 12.2cm (circumference of pulley)


    DcMotor leftLift;
    DcMotor rightLift;

    public void init(){
        leftLift = hardwareMap.get(DcMotor.class, "left_lift");
        rightLift = hardwareMap.get(DcMotor.class, "right_lift");

        leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void lift(String direction) {
        if (direction == "up") {

            leftLift.setTargetPosition((int) (rotationCount * ticks));
            rightLift.setTargetPosition((int) (rotationCount * ticks));

            leftLift.setPower(upSpeed);
            rightLift.setPower(upSpeed);

            leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        else{
            leftLift.setTargetPosition(0);
            rightLift.setTargetPosition(0);

            leftLift.setPower(downSpeed);
            rightLift.setPower(downSpeed);

            leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }


    }


}
