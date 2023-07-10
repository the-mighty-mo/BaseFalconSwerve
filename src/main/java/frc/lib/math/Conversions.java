package frc.lib.math;

public class Conversions {

    /**
     * @param positionRot CANcoder Position Rotations
     * @param gearRatio Gear Ratio between CANcoder and Mechanism
     * @return Degrees of Rotation of Mechanism
     */
    public static double CANcoderToDegrees(double positionRot, double gearRatio) {
        return positionRot * (360.0 / gearRatio);
    }

    /**
     * @param degrees Degrees of rotation of Mechanism
     * @param gearRatio Gear Ratio between CANcoder and Mechanism
     * @return CANcoder Position Rotations
     */
    public static double degreesToCANcoder(double degrees, double gearRatio) {
        return degrees / (360.0 / gearRatio);
    }

    /**
     * @param positionRot Falcon Position Rotations
     * @param gearRatio Gear Ratio between Falcon and Mechanism
     * @return Degrees of Rotation of Mechanism
     */
    public static double falconToDegrees(double positionRot, double gearRatio) {
        return positionRot * (360.0 / gearRatio);
    }

    /**
     * @param degrees Degrees of rotation of Mechanism
     * @param gearRatio Gear Ratio between Falcon and Mechanism
     * @return Falcon Position Rotations
     */
    public static double degreesToFalcon(double degrees, double gearRatio) {
        return degrees / (360.0 / gearRatio);
    }

    /**
     * @param velocityRPS Falcon Velocity RPS
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon RPM)
     * @return RPM of Mechanism
     */
    public static double falconToRPM(double velocityRPS, double gearRatio) {
        double motorRPM = velocityRPS * 60.0;
        double mechRPM = motorRPM / gearRatio;
        return mechRPM;
    }

    /**
     * @param RPM RPM of mechanism
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon RPM)
     * @return Falcon Velocity RPS
     */
    public static double RPMToFalcon(double RPM, double gearRatio) {
        double motorRPM = RPM * gearRatio;
        double sensorCounts = motorRPM / 60.0;
        return sensorCounts;
    }

    /**
     * @param velocityRPS Falcon Velocity RPS
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon MPS)
     * @return Velocity MPS
     */
    public static double falconToMPS(double velocityRPS, double circumference, double gearRatio){
        double wheelRPM = falconToRPM(velocityRPS, gearRatio);
        double wheelMPS = (wheelRPM * circumference) / 60;
        return wheelMPS;
    }

    /**
     * @param velocity Velocity MPS
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon MPS)
     * @return Falcon Velocity RPS
     */
    public static double MPSToFalcon(double velocity, double circumference, double gearRatio){
        double wheelRPM = ((velocity * 60) / circumference);
        double wheelVelocity = RPMToFalcon(wheelRPM, gearRatio);
        return wheelVelocity;
    }

    /**
     * @param positionRot Falcon Position Rotations
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Wheel
     * @return Meters
     */
    public static double falconToMeters(double positionRot, double circumference, double gearRatio){
        return positionRot * (circumference / gearRatio);
    }

    /**
     * @param meters Meters
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Wheel
     * @return Falcon Position Rotations
     */
    public static double MetersToFalcon(double meters, double circumference, double gearRatio){
        return meters / (circumference / gearRatio);
    }
}