package payroll.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContractorEmployeeTest {

    @Test
    void shouldCalculateContractorPayWithoutOvertime() {
        ContractorEmployee employee = new ContractorEmployee("Bob", 50, 160);

        PayrollResult result = employee.calculatePay();

        assertEquals(8000.0, result.grossPay(), 0.001);
        assertEquals(0.0, result.tax(), 0.001);
        assertEquals(8000.0, result.netPay(), 0.001);
    }

    @Test
    void shouldCalculateContractorPayWithOvertime() {
        ContractorEmployee employee = new ContractorEmployee("Bob", 50, 170);

        PayrollResult result = employee.calculatePay();

        assertEquals(8750.0, result.grossPay(), 0.001);
        assertEquals(0.0, result.tax(), 0.001);
        assertEquals(8750.0, result.netPay(), 0.001);
    }
}
