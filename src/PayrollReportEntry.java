public record PayrollReportEntry(
        String employeeName,
        EmployeeType employmentType,
        double grossPay,
        double tax,
        double netPay
) {
}
