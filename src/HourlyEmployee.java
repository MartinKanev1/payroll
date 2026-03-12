public class HourlyEmployee extends Employee  implements Payable {

    private double hourlyRate;
    private int hoursWorked;
    private double taxRate;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked, double taxRate) {
        super(name, EmployeeType.HOURLY);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.taxRate = taxRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public PayrollResult calculatePay() {
        double gross = hourlyRate * hoursWorked;
        double tax = gross * taxRate;
        double net = gross - tax;
        return new PayrollResult(gross, tax, net);
    }
}
