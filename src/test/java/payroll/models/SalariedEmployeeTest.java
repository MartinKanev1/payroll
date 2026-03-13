package payroll.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalariedEmployeeTest {

    @Test
    void shouldCalculateSalariedEmployeePay() {
        SalariedEmployee employee = new SalariedEmployee("Alice", 5000);

        PayrollResult result = employee.calculatePay();

        assertEquals(5000.0, result.grossPay(), 0.001);
        assertEquals(1000.0, result.tax(), 0.001);
        assertEquals(4000.0, result.netPay(), 0.001);
    }
}
