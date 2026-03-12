public class ValidationService {

    public static void validateEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("[warn] employee record is null");
            return;
        }

        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            System.out.println("[warn] employee name is missing");
        }

        if (employee.getType() == null) {
            System.out.println("[warn] employee type is null for " + safeName(employee));
        }

        if (employee instanceof SalariedEmployee salariedEmployee) {
            if (salariedEmployee.getMonthlySalary() < 0) {
                System.out.println("[warn] negative monthly salary for " + safeName(employee));
            }
        }

        if (employee instanceof ContractorEmployee contractorEmployee) {
            if (contractorEmployee.getHourlyRate() < 0) {
                System.out.println("[warn] negative hourly rate for " + safeName(employee));
            }

            if (contractorEmployee.getHoursWorked() < 0) {
                System.out.println("[warn] negative hours worked for " + safeName(employee));
            }
        }

        if (employee instanceof HourlyEmployee hourlyEmployee) {
            if (hourlyEmployee.getHourlyRate() < 0) {
                System.out.println("[warn] negative hourly rate for " + safeName(employee));
            }

            if (hourlyEmployee.getHoursWorked() < 0) {
                System.out.println("[warn] negative hours worked for " + safeName(employee));
            }

            if (hourlyEmployee.getTaxRate() < 0) {
                System.out.println("[warn] negative tax rate for " + safeName(employee));
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