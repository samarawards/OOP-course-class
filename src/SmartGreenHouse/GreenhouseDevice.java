package SmartGreenHouse;

public abstract class GreenhouseDevice {
    protected String deviceId;
    protected String deviceName;
    protected boolean isActive;

    public GreenhouseDevice(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.isActive = false; // Default initial status is powered off
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void turnOn() {
        this.isActive = true;
        System.out.println("[STATUS] Device " + deviceName + " (" + deviceId + ") has been powered ON.");
    }

    public void turnOff() {
        this.isActive = false;
        System.out.println("[STATUS] Device " + deviceName + " (" + deviceId + ") has been powered OFF.");
    }

    public void displayStatus() {
        System.out.println("Device ID    : " + deviceId);
        System.out.println("Device Name  : " + deviceName);
        System.out.println("Power Status : " + (isActive ? "ACTIVE (ON)" : "INACTIVE (OFF)"));
    }

    //abstract methode
    public abstract void operate();
}
