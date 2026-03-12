public class ContractorEmployee extends Employee implements Payable {

    private double hourlyRate;
    private int hoursWorked;

    public ContractorEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name, EmployeeType.CONTRACTOR);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public PayrollResult calculatePay() {
        double gross = hourlyRate * hoursWorked;
        double tax = 0;
        double net = gross;
        return new PayrollResult(gross, tax, net);
    }
}
