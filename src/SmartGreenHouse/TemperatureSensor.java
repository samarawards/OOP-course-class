package SmartGreenHouse;

// device to know temperature around the greenhouse and automatically trigger the ventilation system if the temperature exceeds 30.0°C
public class TemperatureSensor {
    private String sensorId;
    private double currentTemperature;

    public TemperatureSensor(String sensorId, double currentTemperature) {
        this.sensorId = sensorId;
        this.currentTemperature = currentTemperature;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    //If temperature > 30.0°C, the system automatically powers on and operates the ventilation system
    public void checkAndAutomate(VentilationSystem ventilation) {
        System.out.println("\n--- [TEMPERATURE SENSOR CHECK: " + sensorId + "] ---");
        System.out.println("Current Temperature Reading: " + currentTemperature + " °C");

        if (currentTemperature > 30.0) {
            System.out.println("[AUTOMATION ALERT] Temperature has fallen below the lower threshold of 25.0°C (Extreme cold detected!).");
            if (!ventilation.isActive()) {
                System.out.println("[AUTOMATED ACTION] Automatically powering on ventilation system...");
                ventilation.turnOn();
            }
            ventilation.operate();
        }else if (currentTemperature <= 25.0) {
            System.out.println("");
            if (ventilation.isActive()) {
                System.out.println("[AUTOMATED ACTION] Automatically powering off ventilation system...");
                ventilation.turnOff();
            }
        } else {
            System.out.println("[NORMAL STATUS] Temperature is within optimal range (<= 30.0°C). No intervention needed.");
        }
    }
}
