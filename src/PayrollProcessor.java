import helper.CurrencyFormatter;

import java.util.ArrayList;
import java.util.List;

public class PayrollProcessor {

    private static final List<Employee> employees = new ArrayList<>();

    public static final double TAX_RATE = 0.2;

    public static void addEmployee(Employee e) {

        if(e == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        employees.add(e);
        AuditLogger.logEmployeeAdded(e);
    }

    public static void processPayroll() {
        double total = 0;
        PayrollSummary summary = new PayrollSummary();

        AuditLogger.logPayrollStart(employees.size());

        for (Employee e : employees) {
            ValidationService.validateEmployee(e);

            if (!(e instanceof Payable payable)) {
                System.out.println("Unknown employee type: " + (e == null ? "<null>" : e.getType()));
                summary.recordUnknown();
                AuditLogger.logUnknownType(e);
                continue;
            }

            PayrollResult result = payable.calculatePay();
            total += result.netPay();
            summary.record(e, result);

            System.out.println("Pay for " + (e == null ? "<unknown>" : e.getName()) + ": "
                    + CurrencyFormatter.format(result.netPay()));
            AuditLogger.logPayComputed(e, result.netPay());
        }

        System.out.println("Total payroll: " + CurrencyFormatter.format(total));
        printSummary(summary);
        AuditLogger.logPayrollEnd(summary);
    }

    private static void printSummary(PayrollSummary summary) {
        System.out.println("Payroll summary:");
        System.out.println("  salaried count: " + summary.getSalariedCount());
        System.out.println("  contractor count: " + summary.getContractorCount());
        System.out.println("  hourly count: " + summary.getHourlyCount());
        System.out.println("  unknown count: " + summary.getUnknownCount());
        System.out.println("  total gross: " + CurrencyFormatter.format(summary.getTotalGross()));
        System.out.println("  total tax: " + CurrencyFormatter.format(summary.getTotalTax()));
        System.out.println("  total net: " + CurrencyFormatter.format(summary.getTotalNet()));
    }

    private static double calculateUnusedBonus(Employee e) {
        if (e instanceof Payable payable) {
            return 0.05 * payable.calculatePay().grossPay();
        }
        return 0;
    }
}