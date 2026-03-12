public abstract class Employee {

    private String name;
    private EmployeeType type;

    protected Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public EmployeeType getType() {
        return type;
    }
}