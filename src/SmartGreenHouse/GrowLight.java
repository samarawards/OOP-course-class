package SmartGreenHouse;

// Device for adding light to help the plant in photosyteshis process
public class GrowLight extends GreenhouseDevice implements Schedulable {
    private int lightIntensity; // Percentage (0 - 100%)
    private String scheduleTime;

    public GrowLight(String deviceId, String deviceName, int lightIntensity) {
        super(deviceId, deviceName);
        this.lightIntensity = lightIntensity;
        this.scheduleTime = "Not scheduled";
    }

    public int getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(int lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    @Override
    public void setSchedule(String time) {
        this.scheduleTime = time;
        System.out.println("[SCHEDULE] Automated lighting schedule for " + deviceName + " configured for: " + time);
    }

    @Override
    public void operate() {
        if (!isActive) {
            System.out.println("[OPERATION FAILED] " + deviceName + " (" + deviceId + ") cannot operate! The device is powered off.");
            return;
        }
        System.out.println("[GROW LIGHT OPERATION] " + deviceName + " is emitting full-spectrum light at " + lightIntensity + "% intensity.");
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("System Type  : Grow Light (Photosynthesis)");
        System.out.println("Intensity    : " + lightIntensity + "%");
        System.out.println("Schedule     : " + scheduleTime);
    }
}
