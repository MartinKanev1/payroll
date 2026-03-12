public class SalariedEmployee extends Employee implements Payable {

    private double monthlySalary;

    public SalariedEmployee(String name, double monthlySalary) {
        super(name, EmployeeType.SALARIED);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public PayrollResult calculatePay() {
        double gross = monthlySalary;
        double tax = gross * PayrollProcessor.TAX_RATE;
        double net = gross - tax;
        return new PayrollResult(gross, tax, net);
    }
}