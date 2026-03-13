## How to Run the Project

### Requirements

* **Java JDK 16 or newer**
* Git


## To Run the Tests

### Windows

```bash
mvnw.cmd test
```

### macOS / Linux

```bash
./mvnw test
```
Or from the maven top right panel: Maven - Lifecycle - tests
---

## To Run the Application

### Windows

```bash
mvnw.cmd exec:java
```

### macOS / Linux

```bash
./mvnw exec:java
```

Or simply click the run button in the Main class
---

## Build the Project

To build the project and generate the `.jar` file:

### Windows

```bash
mvnw.cmd clean package
```

### macOS / Linux

```bash
./mvnw clean package
```

The compiled JAR will appear in:

```
target/payroll-1.0-SNAPSHOT.jar
```

---

## Running in IntelliJ IDEA

1. Open the project folder in IntelliJ.
2. IntelliJ should detect the `pom.xml` and import the project as **Maven**.
3. Run the application by running the `Main` class.

**Note:**
If IntelliJ shows incorrect compile errors, reimport the project as Maven and enable **“Delegate IDE build/run actions to Maven”** in:

```
File → Settings → Build, Execution, Deployment → Build Tools → Maven → Runner
```
