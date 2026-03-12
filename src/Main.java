public class Main {

    public static void main(String[] args) {

        Employee e1 = new ContractorEmployee("Bob", 50, 170);
        Employee e2 = new HourlyEmployee("Diana", 25, 170, 0.10);
        Employee e3 = new ContractorEmployee("Charlie", 60, 0);
        Employee e4 = new HourlyEmployee("Diana", 25, 160, 0.10);

        PayrollProcessor.addEmployee(e1);
        PayrollProcessor.addEmployee(e2);
        PayrollProcessor.addEmployee(e3);
        PayrollProcessor.addEmployee(e4);

        PayrollProcessor.processPayroll();
    }
}