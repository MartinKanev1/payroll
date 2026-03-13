package payroll.services;

import payroll.models.ContractorEmployee;
import payroll.models.Employee;
import payroll.models.HourlyEmployee;
import payroll.models.SalariedEmployee;
import payroll.exceptions.*;

public class ValidationService {


    public static void validateEmployee(Employee employee) {

        if (employee == null) {
            throw new InvalidEmployeeException("models.Employee record cannot be null");
        }

        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new PayrollException("models.Employee name is missing");
        }

        if (employee.getType() == null) {
            throw new PayrollException("models.Employee type is null for " + safeName(employee));
        }

        if (employee instanceof SalariedEmployee salariedEmployee) {
            if (salariedEmployee.getMonthlySalary() < 0) {
                throw new InvalidSalaryException("Salary cannot be negative for " + safeName(employee));
            }
        }

        if (employee instanceof ContractorEmployee contractorEmployee) {
            if (contractorEmployee.getHourlyRate() < 0) {
                throw new InvalidHourlyRateException("Hourly rate cannot be negative for " + safeName(employee));
            }

            if (contractorEmployee.getHoursWorked() < 0) {
                throw new InvalidWorkHoursException("Hours worked cannot be negative for " + safeName(employee));
            }
        }

        if (employee instanceof HourlyEmployee hourlyEmployee) {
            if (hourlyEmployee.getHourlyRate() < 0) {
                throw new InvalidHourlyRateException("Hourly rate cannot be negative for " + safeName(employee));
            }

            if (hourlyEmployee.getHoursWorked() < 0) {
                throw new InvalidWorkHoursException("Hours worked cannot be negative for " + safeName(employee));
            }

            if (hourlyEmployee.getTaxRate() < 0) {
                throw new InvalidTaxRateException("Tax rate cannot be negative for " + safeName(employee));
            }
        }
    }

    private static String safeName(Employee employee) {
        if (employee == null || employee.getName() == null || employee.getName().trim().isEmpty()) {
            return "<unknown>";
        }
        return employee.getName();
    }
}