# Object-Oriented Programming (OOP) Course Repository

This repository contains practical assignment projects for the **Object-Oriented Programming (OOP)** college course, organized into separate packages corresponding to weekly topics and assignments.

> **Note:** This `README.md` is actively maintained and will be continuously updated alongside new coursework, topics, and assignments throughout the semester.

---

## Packages & Assignment Modules Overview

| Package | Core OOP Topic | Description |
| :--- | :--- | :--- |
| **`BiodataForm`** | **Java GUI (Swing & Event Handling)** | Student biodata registration GUI demonstrating Top-Level Containers (`JFrame`, `JOptionPane`), Intermediate Containers (`JPanel`), Atomic Components (`JLabel`, `JTextField`, `JButton`), Layout Managers (`GridLayout`, `FlowLayout`), and Event Handling via `ActionListener`. |
| **`SmartGreenHouse`** | **Abstract Class & Interface** | Smart greenhouse automation system simulating irrigation, ventilation, grow lighting, and temperature sensors using abstract classes, interfaces, inheritance, and polymorphism. |
| **`BankSystem`** | **Array & ArrayList of Objects** | Bank customer and account management using fixed-size arrays and dynamic list manipulation (`ArrayList`). |
| **`Shapes`** | **Encapsulation, Inheritance, & Polymorphism** | 2D and 3D geometric shape hierarchy implementing the three fundamental pillars of OOP. |
| **`BangunDatar`** | **Class, Constructor Overloading, & Methods** | 2D shape perimeter and area calculations with overloaded constructors. |
| **`HouseTax`** | **Object Relationships (Composition/Aggregation)** | Entity association (`Father` has a `House`) for property tax (PBB) calculation. |
| **`CalculateBMI`** | **Class & Basic Encapsulation** | Human biological data processing (`Human`) and body mass index (BMI) status determination. |

---

## 1. Package `BiodataForm` (Topic: Java GUI Swing Components & Event Handling)

This package implements an interactive **Student Biodata Registration Form** built using **Java Swing** and **AWT** in [`BiodataForm.java`](src/BiodataForm/BiodataForm.java). It serves as an exploration of the fundamental architecture of Java Graphical User Interface (GUI) applications, specifically covering all 5 required parts:
1. **Top-Level Container Class** (`JFrame`, `JOptionPane`)
2. **Intermediate Container Class** (`JPanel`)
3. **Atomic Component Class** (`JLabel`, `JTextField`, `JButton`)
4. **Layout Classes** (`GridLayout`, `FlowLayout` — minimum 2 Layout Classes)
5. **Event Listener** (`ActionListener` interface method overriding via functional lambda)

```mermaid
graph TD
    subgraph TopLevelContainer ["1. Top-Level Container (JFrame) - GridLayout(3, 1)"]
        subgraph HeaderPanel ["2. Intermediate Container (header) - FlowLayout"]
            L1["3. Atomic: JLabel ('Student Biodata')"]
        end

        subgraph FormPanel ["2. Intermediate Container (form) - GridLayout(4, 2)"]
            L2["3. Atomic: JLabel ('First Name: ')"]
            T1["3. Atomic: JTextField (txtFirstName)"]
            L3["3. Atomic: JLabel ('Last Name: ')"]
            T2["3. Atomic: JTextField (txtLastName)"]
            L4["3. Atomic: JLabel ('Birth Date: ')"]
            T3["3. Atomic: JTextField (txtBirthDate)"]
            L5["3. Atomic: JLabel ('Gender: ')"]
            T4["3. Atomic: JTextField (txtGender)"]
        end

        subgraph ButtonPanel ["2. Intermediate Container (button) - FlowLayout"]
            B1["3. Atomic: JButton ('Submit')"]
            B2["3. Atomic: JButton ('Exit')"]
        end
    end

    subgraph EventListeners ["5. Event Listener (ActionListener Interface)"]
        B1 -->|Click: addActionListener| E1["actionPerformed(ActionEvent e) via Lambda<br>-> Validates inputs & triggers JOptionPane"]
        B2 -->|Click: addActionListener| E2["actionPerformed(ActionEvent e) via Lambda<br>-> Shows exit confirmation & exits"]
    end
```

### Exploration Requirements: 5 GUI Components / Parts Breakdown

#### A. Top-Level Container Class
Top-level containers provide the native OS window frame and heavy-weight display canvas required to host intermediate containers and visual components:
* **`JFrame` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L10-L12)):**
  - Serves as the master window frame titled `"Student Biodata Form"`.
  - Configured with `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)`, initial dimensions `setSize(500, 500)`, and rendered visible via `frame.setVisible(true)`.
* **`JOptionPane` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L58-L92)):**
  - Dialog-based top-level popup containers for interactive modal alerts:
    - `JOptionPane.showMessageDialog` with `WARNING_MESSAGE` when input fields are empty.
    - `JOptionPane.showMessageDialog` with `INFORMATION_MESSAGE` displaying submitted biodata.
    - `JOptionPane.showConfirmDialog` with `OK_CANCEL_OPTION` when prompting confirmation before exiting.

#### B. Intermediate Container Class
Intermediate containers are lightweight components whose role is to group, structure, and partition UI components into organized blocks before adding them to the top-level container:
* **`JPanel` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L14,L17,L37)):**
  - `header` panel: Holds the header title label using `FlowLayout`.
  - `form` panel: Holds the 4 pairs of labels and text input fields using `GridLayout(4, 2)`.
  - `button` panel: Holds the `Submit` and `Exit` buttons using `FlowLayout`.

#### C. Atomic Component Class
Atomic components are individual, non-container UI controls that interact directly with the user or display content:
* **`JLabel` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L15,L25,L28,L31,L34)):**
  - Displays non-editable descriptive text (`"Student Biodata"`, `"First Name: "`, `"Last Name: "`, `"Birth Date: "`, `"Gender: "`).
* **`JTextField` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L20-L23)):**
  - Provides editable single-line input boxes allowing users to type personal biodata (`txtFirstName`, `txtLastName`, `txtBirthDate`, `txtGender`).
* **`JButton` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L39-L40)):**
  - Clickable action triggers (`btnSubmit` to validate and submit data; `btnExit` to prompt for program exit).

#### D. Layout Classes (Minimum 2 Layout Classes)
Layout managers govern the spatial positioning, sizing, and arrangement of components inside containers. The code implements **two (2)** distinct layout classes:
1. **`FlowLayout` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L14,L37)):**
   - Applied to `header` panel (`new FlowLayout()`) and `button` panel (`new FlowLayout()`) to arrange elements sequentially in a centered row.
2. **`GridLayout` ([`src/BiodataForm/BiodataForm.java`](src/BiodataForm/BiodataForm.java#L17,L100)):**
   - Applied to `form` panel (`new GridLayout(4, 2)`) to arrange labels and text fields in a strict 4-row by 2-column tabular grid.
   - Applied to the main `frame` (`new GridLayout(3, 1)`) to vertically divide the window into 3 equal rows for `header`, `form`, and `button` panels.

#### E. Event Listener (Event Method Override from Event Listener Interface)
Event handling links visual components to program actions:
* **Event Listener Interface (`ActionListener`):**
  - Registered on `btnSubmit` ([line 46](src/BiodataForm/BiodataForm.java#L46)) and `btnExit` ([line 84](src/BiodataForm/BiodataForm.java#L84)) via `.addActionListener(...)`.
  - In Java 8+, the lambda expression `e -> { ... }` implements the `ActionListener` Functional Interface (Single Abstract Method) and overrides its abstract method `void actionPerformed(ActionEvent e)`:
    - **`btnSubmit` Action Logic:** Retrieves trimmed text from all `JTextField`s, checks for empty values, displays a warning dialog if invalid, or displays an information dialog with the submitted biodata and clears the fields.
    - **`btnExit` Action Logic:** Displays a confirmation dialog (`JOptionPane.showConfirmDialog`) and invokes `System.exit(0)` if confirmed.

---

## 2. Package `SmartGreenHouse` (Topic: Abstract Class & Interface)

This package models a **Smart Greenhouse Automation System** designed to monitor and automate environmental control devices (irrigation, ventilation, grow lighting, and temperature sensing). It serves as a comprehensive study case demonstrating the proper design and utilization of **Abstract Classes**, **Interfaces**, **Inheritance**, and **Runtime Polymorphism**.

```mermaid
classDiagram
    class Schedulable {
        <<interface>>
        +setSchedule(String time)* void
    }

    class GreenhouseDevice {
        <<abstract>>
        #deviceId : String
        #deviceName : String
        #isActive : boolean
        +GreenhouseDevice(deviceId, deviceName)
        +getDeviceId() String
        +getDeviceName() String
        +isActive() boolean
        +turnOn() void
        +turnOff() void
        +displayStatus() void
        +operate()* void
    }

    class IrrigationSystem {
        -waterFlowRate : double
        -scheduleTime : String
        +IrrigationSystem(deviceId, deviceName, waterFlowRate)
        +getWaterFlowRate() double
        +setWaterFlowRate(rate) void
        +setSchedule(time) void
        +operate() void
        +displayStatus() void
    }

    class VentilationSystem {
        -fanSpeed : int
        -scheduleTime : String
        +VentilationSystem(deviceId, deviceName, fanSpeed)
        +getFanSpeed() int
        +setFanSpeed(speed) void
        +setSchedule(time) void
        +operate() void
        +displayStatus() void
    }

    class GrowLight {
        -lightIntensity : int
        -scheduleTime : String
        +GrowLight(deviceId, deviceName, lightIntensity)
        +getLightIntensity() int
        +setLightIntensity(intensity) void
        +setSchedule(time) void
        +operate() void
        +displayStatus() void
    }

    class TemperatureSensor {
        -sensorId : String
        -currentTemperature : double
        +TemperatureSensor(sensorId, currentTemperature)
        +getCurrentTemperature() double
        +setCurrentTemperature(temp) void
        +checkAndAutomate(ventilation) void
    }

    GreenhouseDevice <|-- IrrigationSystem : extends
    GreenhouseDevice <|-- VentilationSystem : extends
    GreenhouseDevice <|-- GrowLight : extends

    Schedulable <|.. IrrigationSystem : implements
    Schedulable <|.. VentilationSystem : implements
    Schedulable <|.. GrowLight : implements

    TemperatureSensor ..> VentilationSystem : controls / triggers
```

### A. Abstract Class (`GreenhouseDevice`)
An abstract class serves as an incomplete template that defines common state and behavior while leaving operational details to concrete subclasses:
1. **Cannot be Instantiated Directly:**
   - Attempting `new GreenhouseDevice(...)` produces a compiler error. It only exists to be extended by concrete devices.
2. **Shared State & Concrete Methods:**
   - Common fields (`deviceId`, `deviceName`, `isActive`) and power control methods (`turnOn()`, `turnOff()`, and `displayStatus()`) are written once in the superclass, eliminating redundant code.
3. **Enforcing Operational Contracts (`abstract void operate()`):**
   - Declares the abstract method `public abstract void operate();`, mandating that every concrete subclass must provide its own specific operational logic.

---

### B. Interface (`Schedulable`)
An interface defines a pure behavioral contract representing a capability that classes can choose to fulfill:
1. **Decoupled Capability:**
   - The [`Schedulable`](src/SmartGreenHouse/Schedulable.java) interface defines `void setSchedule(String time);`. It guarantees that any class implementing it can receive automated operation timing.
2. **Multiple Type Conformance:**
   - All three devices (`IrrigationSystem`, `VentilationSystem`, `GrowLight`) implement `Schedulable`, allowing them to be treated uniformly by scheduling controllers regardless of their hardware hierarchy.

---

### C. Inheritance & Subclass Specialization
1. **Specialized Attributes:**
   - [`IrrigationSystem`](src/SmartGreenHouse/IrrigationSystem.java) manages `waterFlowRate` (L/min).
   - [`VentilationSystem`](src/SmartGreenHouse/VentilationSystem.java) manages `fanSpeed` (RPM).
   - [`GrowLight`](src/SmartGreenHouse/GrowLight.java) manages `lightIntensity` (%).
2. **Constructor Chaining:**
   - Each subclass constructor invokes `super(deviceId, deviceName)` to initialize the inherited superclass state.

---

### D. Polymorphism & Business Logic
1. **Polymorphic Arrays (`GreenhouseDevice[]` & `Schedulable[]`):**
   - Heterogeneous device objects are stored within a single `GreenhouseDevice[]` array. Calling `device.displayStatus()` and `device.operate()` inside a loop dynamically dispatches to the runtime object's implementation.
   - The same objects are also handled as `Schedulable[]` to configure operational schedules polymorphically.
2. **Business Rule Enforcement:**
   - An inactive device (`isActive == false`) cannot operate. In `operate()`, each subclass validates that power is active before executing, displaying an operation failure warning if powered off.
3. **Automated Feedback Loop (Bonus: `TemperatureSensor`):**
   - [`TemperatureSensor`](src/SmartGreenHouse/TemperatureSensor.java) reads simulated temperature data. If the temperature exceeds the 30.0°C threshold, it automatically activates and operates the ventilation system to cool down the greenhouse.

---

## 3. Package `BankSystem` (Topic: Array & ArrayList)

This package demonstrates how to store, manage, and manipulate collections of objects (*Array of Objects*) using both fixed-size primitive arrays and dynamic collections (`ArrayList`).

### A. Fixed-Size Array (`Array of Objects`)

1. **Customer Array in [`Bank.java`](src/BankSystem/Bank.java):**
   - **Declaration & Allocation:**
     ```java
     private Customer[] customers = new Customer[100]; // Fixed array with a capacity of 100 Customer objects
     private static int numberOfCustomers = 0;
     ```
   - **Adding Elements to the Array:**
     New elements are inserted using `numberOfCustomers` as an index tracker:
     ```java
     public void addCustomer(String f, String l) {
         Customer newCustomer = new Customer(f, l);
         customers[numberOfCustomers] = newCustomer; // Store object into array slot
         numberOfCustomers++;
     }
     ```
   - **Accessing Array Elements:**
     Objects are retrieved by index (`id`):
     ```java
     public Customer getCustomer(int id) {
         return customers[id];
     }
     ```

2. **Accounts Array in [`Customer.java`](src/BankSystem/Customer.java):**
   - Each customer can hold up to 5 bank accounts:
     ```java
     private Account[] accounts = new Account[5]; // Fixed limit of 5 accounts per customer
     private int numberOfAccounts = 0;
     ```
   - **Capacity Bounds Checking:**
     ```java
     public void setAccount(Account acct) {
         if (numberOfAccounts < 5) {
             accounts[numberOfAccounts++] = acct;
         }
     }
     ```

---

### B. Dynamic Collections (`ArrayList`)

In [`BankAccountArrayBeraksi.java`](src/BankSystem/BankAccountArrayBeraksi.java), objects are managed dynamically without pre-allocated size constraints:
- **Declaration & Initialization:**
  ```java
  ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
  ```
- **Insertion Operations (`add`):**
  - Append to the end of the list: `accounts.add(new BankAccount(1001));`
  - Insert at a specific index: `accounts.add(1, new BankAccount(1008));`
- **Deletion Operation (`remove`):**
  - Remove an element by its index: `accounts.remove(0);`
- **Inspection (`size`) & Retrieval (`get`):**
  - Access the first element: `accounts.get(0);`
  - Dynamically access the last element: `accounts.get(accounts.size() - 1);`

---

## 4. Package `Shapes` (Topic: Encapsulation, Inheritance, Polymorphism)

This package models a geometric shape hierarchy based on the class diagram to demonstrate the three core pillars of OOP.

```mermaid
classDiagram
    class Shape {
        #color : String
        +Shape(color)
        +getColor() String
        +setColor(color) void
        +printInfo() void
    }

    class Square {
        -side : double
        +Square(side, color)
        +getSide() double
        +setSide(side) void
        +area() double
        +printInfo() void
    }

    class Circle {
        #radius : double
        +PI : static final double
        +Circle(radius, color)
        +getRadius() double
        +setRadius(radius) void
        +area() double
        +printInfo() void
    }

    class Cylinder {
        -height : double
        +Cylinder(height, radius, color)
        +getHeight() double
        +setHeight(height) void
        +volume() double
        +printInfo() void
    }

    Shape <|-- Square : extends
    Shape <|-- Circle : extends
    Circle <|-- Cylinder : extends
```

### A. Encapsulation
Encapsulation protects object state (*data hiding*) by preventing unauthorized direct access and mediating field interactions via public methods:
1. **Access Modifiers:**
   - The `side` field in [`Square.java`](src/Shapes/Square.java) and `height` in [`Cylinder.java`](src/Shapes/Cylinder.java) are marked `private` to disallow direct external mutation.
   - The `color` field in [`Shape.java`](src/Shapes/Shape.java) and `radius` in [`Circle.java`](src/Shapes/Circle.java) are marked `protected` so derived classes have controlled access while blocking outside packages.
2. **Getters & Setters:**
   - Controlled access is provided through explicit methods such as `getColor()`, `setColor(String color)`, `getSide()`, `setSide(double side)`, `getRadius()`, `setRadius(double radius)`, `getHeight()`, and `setHeight(double height)`.
3. **Logic Encapsulation:**
   - Formula logic for computing area (`area()`) and volume (`volume()`) is encapsulated internally within the respective classes.

---

### B. Inheritance
Inheritance enables a subclass to acquire attributes and methods from a superclass, fostering high code reusability and establishing natural relationships:
1. **Single Inheritance:**
   - `Square extends Shape`: The `Square` class inherits the `color` attribute and methods from `Shape`.
   - `Circle extends Shape`: The `Circle` class inherits common shape characteristics from `Shape`.
2. **Multilevel Inheritance:**
   - `Cylinder extends Circle` (where `Circle` extends `Shape`): The `Cylinder` class inherits the `radius` field and `area()` method from `Circle`, and transitively inherits the `color` attribute from `Shape`.
3. **Constructor Chaining (`super` Keyword):**
   - Subclass constructors pass arguments up to their parent constructors:
     - `Square`: `super(color);`
     - `Circle`: `super(color);`
     - `Cylinder`: `super(radius, color);`

---

### C. Polymorphism
Polymorphism allows methods to exhibit different behaviors depending on the actual runtime object executing them:
1. **Method Overriding (Runtime Polymorphism):**
   - The `printInfo()` method declared in superclass `Shape` is overridden in each subclass to satisfy its specific output format:
     - `Square`: `"Square colored " + color + ", area = " + area()`
     - `Circle`: `"Circle " + color + ", area = " + area()`
     - `Cylinder`: `"Cylinder " + color + ", volume = " + volume()`
2. **Dynamic Method Reuse:**
   - The `volume()` method in `Cylinder` dynamically delegates the base area calculation to `Circle.area()`:
     ```java
     public double volume() {
         return area() * height; // Calls inherited area() implementation from Circle
     }
     ```
3. **Polymorphic Reference (Dynamic Method Dispatch):**
   - Objects of type `Square`, `Circle`, and `Cylinder` can be held in a `Shape` reference (e.g. `Shape[] shapes`). Invoking `printInfo()` executes the specific subclass implementation dynamically at runtime.

---

## 5. Library Information & Build Instructions

* **External Dependencies:** **No third-party libraries or dependencies** are required.
* **Standard Library:** The entire codebase is implemented in pure Java SE / JDK standard library (`java.lang.*`, `javax.swing.*`, `java.awt.*`). No Maven or Gradle configurations or extra `.jar` files are needed.

### Compilation and Execution:

Run the following commands from the root directory of the workspace:

```bash
# Compile and run BiodataForm (Java Swing GUI)
javac -d bin src/BiodataForm/*.java
java -cp bin BiodataForm.BiodataForm

# Compile and run SmartGreenHouse (Abstract Class & Interface)
javac -d bin src/SmartGreenHouse/*.java
java -cp bin SmartGreenHouse.GreenhouseApp

# Compile and run BankSystem
javac -d bin src/BankSystem/*.java
java -cp bin BankSystem.Main

# Compile and run Shapes
javac -d bin src/Shapes/*.java
java -cp bin Shapes.Main
```

### Expected Output for `SmartGreenHouse.GreenhouseApp`:
```text
=================================================================
         SMART GREENHOUSE AUTOMATION SYSTEM SIMULATION           
=================================================================

>>> 1. INITIALIZING GREENHOUSE DEVICES
Devices successfully created: Drip Irrigation Zone A, Exhaust Fan Greenhouse 1, Full-Spectrum LED Array

>>> 2. CONFIGURING SCHEDULES (SCHEDULABLE INTERFACE CONTRACT)
[SCHEDULE] Automated irrigation schedule for Drip Irrigation Zone A configured for: 06:00 AM & 05:00 PM
[SCHEDULE] Automated ventilation schedule for Exhaust Fan Greenhouse 1 configured for: 11:30 AM
[SCHEDULE] Automated lighting schedule for Full-Spectrum LED Array configured for: 06:00 PM

>>> 3. ACTIVATING DEVICES
[STATUS] Device Drip Irrigation Zone A (DEV-IRR01) has been powered ON.
[STATUS] Device Exhaust Fan Greenhouse 1 (DEV-VNT01) has been powered ON.
[STATUS] Device Full-Spectrum LED Array (DEV-LGT01) has been powered ON.

>>> 4. MONITORING AND OPERATING DEVICES (POLYMORPHISM VIA ARRAY)
-----------------------------------------------------------------
Device ID    : DEV-IRR01
Device Name  : Drip Irrigation Zone A
Power Status : ACTIVE (ON)
System Type  : Irrigation System
Water Flow   : 12.5 L/min
Schedule     : 06:00 AM & 05:00 PM
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
[IRRIGATION OPERATION] Drip Irrigation Zone A is watering crops at a flow rate of 12.5 L/min.
-----------------------------------------------------------------
Device ID    : DEV-VNT01
Device Name  : Exhaust Fan Greenhouse 1
Power Status : ACTIVE (ON)
System Type  : Ventilation System
Fan Speed    : 1400 RPM
Schedule     : 11:30 AM
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
[VENTILATION OPERATION] Exhaust Fan Greenhouse 1 is circulating air at a fan speed of 1400 RPM.
-----------------------------------------------------------------
Device ID    : DEV-LGT01
Device Name  : Full-Spectrum LED Array
Power Status : ACTIVE (ON)
System Type  : Grow Light (Photosynthesis)
Intensity    : 80%
Schedule     : 06:00 PM
- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
[GROW LIGHT OPERATION] Full-Spectrum LED Array is emitting full-spectrum light at 80% intensity.
-----------------------------------------------------------------

>>> 5. TESTING BUSINESS LOGIC: INACTIVE DEVICE CANNOT OPERATE
Powering off irrigation system...
[STATUS] Device Drip Irrigation Zone A (DEV-IRR01) has been powered OFF.
Attempting to operate powered-off irrigation system:
[OPERATION FAILED] Drip Irrigation Zone A (DEV-IRR01) cannot operate! The device is powered off.

>>> 6. [BONUS] ENVIRONMENTAL TEMPERATURE SENSOR AUTOMATION
[STATUS] Device Exhaust Fan Greenhouse 1 (DEV-VNT01) has been powered OFF.

[Scenario 1: Normal Temperature]

--- [TEMPERATURE SENSOR CHECK: SNS-TMP01] ---
Current Temperature Reading: 28.0 °C
[NORMAL STATUS] Temperature is within optimal range (<= 30.0°C). No intervention needed.

[Scenario 2: Overheating Temperature (> 30.0°C)]

--- [TEMPERATURE SENSOR CHECK: SNS-TMP02] ---
Current Temperature Reading: 33.5 °C
[AUTOMATION ALERT] Temperature exceeds threshold limit of 30.0°C (High heat detected!).
[AUTOMATED ACTION] Automatically powering on ventilation system...
[STATUS] Device Exhaust Fan Greenhouse 1 (DEV-VNT01) has been powered ON.
[VENTILATION OPERATION] Exhaust Fan Greenhouse 1 is circulating air at a fan speed of 1400 RPM.

=================================================================
               SIMULATION COMPLETED SUCCESSFULLY                 
=================================================================
```

---

## 6. Program Execution Screenshots

### A. BiodataForm GUI Application Flow

#### 1. Main Student Biodata Form Interface
Demonstrates the main GUI window rendered inside a `JFrame` with three `JPanel` intermediate containers (`header`, `form`, `button`) arranged via `GridLayout(3, 1)` on the frame, `GridLayout(4, 2)` on the form, and `FlowLayout` on the header and button panels:

![Biodata Form Main Window](screenshots/biodata_form_main.png)

#### 2. Input Validation (Empty Fields Warning Dialog)
Demonstrates event-triggered input validation via `JOptionPane.showMessageDialog` (`WARNING_MESSAGE`) when any field is left empty:

![Empty Fields Warning](screenshots/biodata_form_empty_warning.png)

#### 3. Successful Data Submission Dialog
Demonstrates event handling on `btnSubmit` overriding `actionPerformed(ActionEvent e)` via lambda to read `JTextField` values, reset inputs, and present a formatted confirmation dialog:

![Submission Success](screenshots/biodata_form_success.png)

#### 4. Exit Confirmation Dialog
Demonstrates an exit confirmation modal dialog (`JOptionPane.showConfirmDialog`) triggered when clicking the `Exit` button:

![Exit Confirmation Dialog](screenshots/biodata_form_exit_dialog.png)

---

### B. BankSystem Interactive ATM Flow

#### 1. Adding a New Customer & Viewing Customer List (Menu 2 & Menu 1)
Demonstrates dynamically adding a customer into the `Bank.customers` array and displaying all registered customers:

![Add Customer & View List](screenshots/bank_tambah_dan_daftar_nasabah.png)

#### 2. Opening a New Account for Customer (Menu 3)
Demonstrates creating a new `Account` object and assigning it to a customer's `accounts[]` array:

![Open New Account](screenshots/bank_buka_rekening.png)

#### 3. Deposit Transaction (Menu 5)
Demonstrates calling the `deposit()` method on an `Account` object to increase balance:

![Cash Deposit](screenshots/bank_setor_tunai.png)

#### 4. Withdrawal Transaction (Menu 6)
Demonstrates calling the `withdraw()` method on an `Account` object with balance validation:

![Cash Withdrawal](screenshots/bank_tarik_tunai.png)

