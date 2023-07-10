package frc.robot;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;

public final class CTREConfigs {
    public final TalonFXConfiguration swerveAngleFXConfig = new TalonFXConfiguration();
    public final TalonFXConfiguration swerveDriveFXConfig = new TalonFXConfiguration();
    public final CANcoderConfiguration swerveCANcoderConfig = new CANcoderConfiguration();

    public CTREConfigs() {
        /* Swerve Angle Motor Configurations */
        var angleMotorOutput = swerveAngleFXConfig.MotorOutput;
        angleMotorOutput.Inverted = Constants.Swerve.angleMotorInvert;
        angleMotorOutput.NeutralMode = Constants.Swerve.angleNeutralMode;

        var angleCurrentLimits = swerveAngleFXConfig.CurrentLimits;
        angleCurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.angleEnableCurrentLimit;
        angleCurrentLimits.SupplyCurrentLimit = Constants.Swerve.angleCurrentLimit;
        angleCurrentLimits.SupplyCurrentThreshold = Constants.Swerve.angleCurrentThreshold;
        angleCurrentLimits.SupplyTimeThreshold = Constants.Swerve.angleCurrentThresholdTime;

        var angleSlot0 = swerveAngleFXConfig.Slot0;
        angleSlot0.kS = Constants.Swerve.angleKS;
        angleSlot0.kV = Constants.Swerve.angleKV;
        angleSlot0.kP = Constants.Swerve.angleKP;
        angleSlot0.kI = Constants.Swerve.angleKI;
        angleSlot0.kD = Constants.Swerve.angleKD;

        /* Swerve Drive Motor Configuration */
        var driveMotorOutput = swerveDriveFXConfig.MotorOutput;
        driveMotorOutput.Inverted = Constants.Swerve.driveMotorInvert;
        driveMotorOutput.NeutralMode = Constants.Swerve.driveNeutralMode;

        var driveCurrentLimits = swerveDriveFXConfig.CurrentLimits;
        driveCurrentLimits.SupplyCurrentLimitEnable = Constants.Swerve.driveEnableCurrentLimit;
        driveCurrentLimits.SupplyCurrentLimit = Constants.Swerve.driveCurrentLimit;
        driveCurrentLimits.SupplyCurrentThreshold = Constants.Swerve.driveCurrentThreshold;
        driveCurrentLimits.SupplyTimeThreshold = Constants.Swerve.driveCurrentThresholdTime;

        var driveSlot0 = swerveDriveFXConfig.Slot0;
        driveSlot0.kS = 0.0;
        driveSlot0.kV = 0.0;
        driveSlot0.kP = Constants.Swerve.driveKP;
        driveSlot0.kI = Constants.Swerve.driveKI;
        driveSlot0.kD = Constants.Swerve.driveKD;

        swerveDriveFXConfig.OpenLoopRamps.DutyCycleOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;
        swerveDriveFXConfig.OpenLoopRamps.VoltageOpenLoopRampPeriod = Constants.Swerve.openLoopRamp;

        swerveDriveFXConfig.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;
        swerveDriveFXConfig.ClosedLoopRamps.VoltageClosedLoopRampPeriod = Constants.Swerve.closedLoopRamp;

        /* Swerve CANcoder Configuration */
        var cancoderMagnetSensor = swerveCANcoderConfig.MagnetSensor;
        cancoderMagnetSensor.AbsoluteSensorRange = AbsoluteSensorRangeValue.Unsigned_0To1;
        cancoderMagnetSensor.SensorDirection = Constants.Swerve.cancoderInvert;
    }
}