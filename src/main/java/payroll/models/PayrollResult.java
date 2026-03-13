package payroll.models;

public record PayrollResult(
        double grossPay,
        double tax,
        double netPay
) {
}
