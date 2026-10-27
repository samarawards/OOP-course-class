package SmartGreenHouse;

//Device to manages air circulation and temperature regulation inside the greenhouse.
public class VentilationSystem extends GreenhouseDevice implements Schedulable {
    private int fanSpeed; // RPM
    private String scheduleTime;

    public VentilationSystem(String deviceId, String deviceName, int fanSpeed) {
        super(deviceId, deviceName);
        this.fanSpeed = fanSpeed;
        this.scheduleTime = "Not scheduled";
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    @Override
    public void setSchedule(String time) {
        this.scheduleTime = time;
        System.out.println("[SCHEDULE] Automated ventilation schedule for " + deviceName + " configured for: " + time);
    }

    @Override
    public void operate() {
        if (!isActive) {
            System.out.println("[OPERATION FAILED] " + deviceName + " (" + deviceId + ") cannot operate! The device is powered off.");
            return;
        }
        System.out.println("[VENTILATION OPERATION] " + deviceName + " is circulating air at a fan speed of " + fanSpeed + " RPM.");
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("System Type  : Ventilation System");
        System.out.println("Fan Speed    : " + fanSpeed + " RPM");
        System.out.println("Schedule     : " + scheduleTime);
    }
}
