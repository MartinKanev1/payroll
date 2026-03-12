public class PayrollSummary {

    private int salariedCount;
    private int contractorCount;
    private int hourlyCount;
    private int unknownCount;
    private int employeeCount;

    private double totalGross;
    private double totalTax;
    private double totalNet;

    public void record(Employee employee, PayrollResult result) {
        employeeCount++;
        totalGross += result.grossPay();
        totalTax += result.tax();
        totalNet += result.netPay();

        if (employee instanceof SalariedEmployee) {
            salariedCount++;
        } else if (employee instanceof ContractorEmployee) {
            contractorCount++;
        } else if (employee instanceof HourlyEmployee) {
            hourlyCount++;
        } else {
            unknownCount++;
        }
    }

    public void recordUnknown() {
        unknownCount++;
        employeeCount++;
    }

    public int getSalariedCount() {
        return salariedCount;
    }

    public int getContractorCount() {
        return contractorCount;
    }

    public int getHourlyCount() {
        return hourlyCount;
    }

    public int getUnknownCount() {
        return unknownCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public double getTotalGross() {
        return totalGross;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalNet() {
        return totalNet;
    }
}
