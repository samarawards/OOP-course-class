package SmartGreenHouse;

import java.util.ArrayList;

public class GreenhouseApp {
    public static void main(String[] args) {
        System.out.println("=================================================================");
        System.out.println("         SMART GREENHOUSE AUTOMATION SYSTEM SIMULATION           ");
        System.out.println("=================================================================\n");

        // Instantiate device objects with unique IDs and attributes
        System.out.println(">>> INITIALIZING GREENHOUSE DEVICES");
        IrrigationSystem irrigation = new IrrigationSystem("DEV-IRR01", "Drip Irrigation Zone A", 12.5);
        VentilationSystem ventilation = new VentilationSystem("DEV-VNT01", "Exhaust Fan Greenhouse 1", 1400);
        GrowLight growLight = new GrowLight("DEV-LGT01", "Full-Spectrum LED Array", 80);

        // Store all devices into an ArrayList (Polymorphism via Collection)
        ArrayList<GreenhouseDevice> devices = new ArrayList<>();
        devices.add(irrigation);
        devices.add(ventilation);
        devices.add(growLight);

        System.out.println("Devices successfully created:\n");
        for (GreenhouseDevice greenhouseDevice : devices) {
            System.out.println("- " + greenhouseDevice.getDeviceName() + "\n");
        }
        // Configure operational schedule via Schedulable interface (Interface Polymorphism)
        System.out.println(">>> CONFIGURING SCHEDULES (SCHEDULABLE INTERFACE CONTRACT)");
        Schedulable[] schedulableDevices = { irrigation, ventilation, growLight };
        schedulableDevices[0].setSchedule("06:00 AM & 05:00 PM");
        schedulableDevices[1].setSchedule("11:30 AM");
        schedulableDevices[2].setSchedule("06:00 PM");
        System.out.println();

        // Power on devices using turnOn() method
        System.out.println(">>> ACTIVATING DEVICES");
        irrigation.turnOn();
        ventilation.turnOn();
        growLight.turnOn();
        System.out.println();

        // Execute displayStatus() and operate() using a polymorphic loop
        System.out.println(">>> MONITORING AND OPERATING DEVICES (POLYMORPHISM VIA ARRAYLIST)");
        for (GreenhouseDevice device : devices) {
            System.out.println("-----------------------------------------------------------------");
            device.displayStatus();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            device.operate();
        }
        System.out.println("-----------------------------------------------------------------\n");

        // Test business logic: Inactive devices must NOT be allowed to operate
        System.out.println(">>> TESTING BUSINESS LOGIC: INACTIVE DEVICE CANNOT OPERATE");
        System.out.println("Powering off irrigation system...");
        irrigation.turnOff();
        System.out.println("Attempting to operate powered-off irrigation system:");
        irrigation.operate(); // Expected: failure/warning message displayed
        System.out.println();

        // Environmental Temperature Sensor Automation
        System.out.println(">>> [BONUS] ENVIRONMENTAL TEMPERATURE SENSOR AUTOMATION");
        // Power off ventilation first to verify if high temperature triggers automatic power-on
        ventilation.turnOff();
        
        TemperatureSensor sensor1 = new TemperatureSensor("SNS-TMP01", 28.0);
        TemperatureSensor sensor2 = new TemperatureSensor("SNS-TMP02", 33.5);
        TemperatureSensor sensor3 = new TemperatureSensor("SNS-TMP03", 20.0);

        // Scenario: Normal temperature
        System.out.println("\n[Scenario: Normal Temperature]");
        sensor1.checkAndAutomate(ventilation);

        // Scenario: Overheating temperature
        System.out.println("\n[Scenario: Overheating Temperature (> 30.0°C)]");
        sensor2.checkAndAutomate(ventilation);

        // Scenario: excessive cold temperature 
        System.out.println("\n[Scenario: Excessive Cold Temperature (<= 25.0°C)]");
        sensor3.checkAndAutomate(ventilation);

        System.out.println("\n=================================================================");
        System.out.println("               SIMULATION COMPLETED SUCCESSFULLY                 ");
        System.out.println("=================================================================");
    }
}
