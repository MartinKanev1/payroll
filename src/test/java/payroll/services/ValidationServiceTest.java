package payroll.services;

import org.junit.jupiter.api.Test;
import payroll.exceptions.*;
import payroll.models.ContractorEmployee;
import payroll.models.HourlyEmployee;
import payroll.models.SalariedEmployee;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationServiceTest {

    @Test
    void shouldThrowExceptionWhenEmployeeIsNull() {
        assertThrows(InvalidEmployeeException.class, () ->
                ValidationService.validateEmployee(null)
        );
    }

    @Test
    void shouldThrowExceptionWhenSalaryIsNegative() {
        SalariedEmployee employee = new SalariedEmployee("Alice", -5000);

        assertThrows(InvalidSalaryException.class, () ->
                ValidationService.validateEmployee(employee)
        );
    }

    @Test
    void shouldThrowExceptionWhenHourlyRateIsNegative() {
        ContractorEmployee employee = new ContractorEmployee("Bob", -50, 160);

        assertThrows(InvalidHourlyRateException.class, () ->
                ValidationService.validateEmployee(employee)
        );
    }

    @Test
    void shouldThrowExceptionWhenHoursWorkedIsNegative() {
        ContractorEmployee employee = new ContractorEmployee("Bob", 50, -10);

        assertThrows(InvalidWorkHoursException.class, () ->
                ValidationService.validateEmployee(employee)
        );
    }

    @Test
    void shouldThrowExceptionWhenTaxRateIsNegative() {
        HourlyEmployee employee = new HourlyEmployee("Diana", 25, 160, -0.10);

        assertThrows(InvalidTaxRateException.class, () ->
                ValidationService.validateEmployee(employee)
        );
    }
}
