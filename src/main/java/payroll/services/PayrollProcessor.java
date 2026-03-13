package payroll.services;

import payroll.exceptions.InvalidEmployeeException;
import payroll.helper.CurrencyFormatter;
import payroll.logging.AuditLogger;
import payroll.models.*;

import java.util.ArrayList;
import java.util.List;

public class PayrollProcessor {

    private static final List<Employee> employees = new ArrayList<>();

    public static final double TAX_RATE = 0.2;

    public static void addEmployee(Employee e) {

        if(e == null) {
            throw new InvalidEmployeeException("Employee cannot be null");
        }

        employees.add(e);
        AuditLogger.logEmployeeAdded(e);
    }


    public static PayrollReport processPayroll() {
        PayrollReport report = new PayrollReport();

        AuditLogger.logPayrollStart(employees.size());

        for (Employee e : employees) {
            ValidationService.validateEmployee(e);

            if (!(e instanceof Payable payable)) {
                AuditLogger.logUnknownType(e);
                continue;
            }

            PayrollResult result = payable.calculatePay();

            PayrollReportEntry entry = new PayrollReportEntry(
                    e.getName(),
                    e.getType(),
                    result.grossPay(),
                    result.tax(),
                    result.netPay()
            );

            report.addEntry(entry);
            AuditLogger.logPayComputed(e, result.netPay());
        }
        AuditLogger.logPayrollEnd(report);

        return report;
    }




    public static void printReport(PayrollReport report) {
        System.out.println("Payroll Report");

        for (PayrollReportEntry entry : report.getEntries()) {
            System.out.println(entry.employeeName() + " (" + entry.employmentType() + ") -> " + "gross: " + CurrencyFormatter.format(entry.grossPay()) + ", tax: " + CurrencyFormatter.format(entry.tax()) + ", net: " + CurrencyFormatter.format(entry.netPay()));
        }

        System.out.println("Total gross: " + CurrencyFormatter.format(report.getTotalGross()));
        System.out.println("Total tax: " + CurrencyFormatter.format(report.getTotalTax()));
        System.out.println("Total net: " + CurrencyFormatter.format(report.getTotalNet()));
    }

    private static double calculateUnusedBonus(Employee e) {
        if (e instanceof Payable payable) {
            return 0.05 * payable.calculatePay().grossPay();
        }
        return 0;
    }

    public static void clearEmployees() {
        employees.clear();
    }
}