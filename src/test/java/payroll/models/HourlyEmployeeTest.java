package payroll.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HourlyEmployeeTest {

    @Test
    void shouldCalculateHourlyPayWithoutOvertime() {
        HourlyEmployee employee = new HourlyEmployee("Diana", 25, 160, 0.10);

        PayrollResult result = employee.calculatePay();

        assertEquals(4000.0, result.grossPay(), 0.001);
        assertEquals(400.0, result.tax(), 0.001);
        assertEquals(3600.0, result.netPay(), 0.001);
    }

    @Test
    void shouldCalculateHourlyPayWithOvertime() {
        HourlyEmployee employee = new HourlyEmployee("Diana", 25, 170, 0.10);

        PayrollResult result = employee.calculatePay();

        assertEquals(4375.0, result.grossPay(), 0.001);
        assertEquals(437.5, result.tax(), 0.001);
        assertEquals(3937.5, result.netPay(), 0.001);
    }
}
