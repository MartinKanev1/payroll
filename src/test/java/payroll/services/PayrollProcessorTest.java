package payroll.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payroll.models.ContractorEmployee;
import payroll.models.Employee;
import payroll.models.HourlyEmployee;
import payroll.models.SalariedEmployee;
import payroll.models.PayrollReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollProcessorTest {

    @BeforeEach
    void setUp() {
        PayrollProcessor.clearEmployees();
    }

    @Test
    void shouldGeneratePayrollReportWithCorrectTotals() {
        Employee e1 = new SalariedEmployee("Alice", 5000);
        Employee e2 = new ContractorEmployee("Bob", 50, 170);
        Employee e3 = new ContractorEmployee("Charlie", 60, 0);
        Employee e4 = new HourlyEmployee("Diana", 25, 170, 0.10);

        PayrollProcessor.addEmployee(e1);
        PayrollProcessor.addEmployee(e2);
        PayrollProcessor.addEmployee(e3);
        PayrollProcessor.addEmployee(e4);

        PayrollReport report = PayrollProcessor.processPayroll();

        assertEquals(4, report.getEntries().size());
        assertEquals(18125.0, report.getTotalGross(), 0.001);
        assertEquals(1437.5, report.getTotalTax(), 0.001);
        assertEquals(16687.5, report.getTotalNet(), 0.001);
    }
}