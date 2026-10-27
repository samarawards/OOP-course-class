package SmartGreenHouse;

// device for automate watering the plants
public class IrrigationSystem extends GreenhouseDevice implements Schedulable {
    private double waterFlowRate; // Liters per minute (L/min)
    private String scheduleTime;

    public IrrigationSystem(String deviceId, String deviceName, double waterFlowRate) {
        super(deviceId, deviceName);
        this.waterFlowRate = waterFlowRate;
        this.scheduleTime = "Not scheduled";
    }

    public double getWaterFlowRate() {
        return waterFlowRate;
    }

    public void setWaterFlowRate(double waterFlowRate) {
        this.waterFlowRate = waterFlowRate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    @Override
    public void setSchedule(String time) {
        this.scheduleTime = time;
        System.out.println("[SCHEDULE] Automated irrigation schedule for " + deviceName + " configured for: " + time);
    }

    @Override
    public void operate() {
        if (!isActive) {
            System.out.println("[OPERATION FAILED] " + deviceName + " (" + deviceId + ") cannot operate! The device is powered off.");
            return;
        }
        System.out.println("[IRRIGATION OPERATION] " + deviceName + " is watering crops at a flow rate of " + waterFlowRate + " L/min.");
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("System Type  : Irrigation System");
        System.out.println("Water Flow   : " + waterFlowRate + " L/min");
        System.out.println("Schedule     : " + scheduleTime);
    }
}
