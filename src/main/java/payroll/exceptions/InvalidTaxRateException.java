package payroll.exceptions;

public class InvalidTaxRateException extends RuntimeException {
    public InvalidTaxRateException(String message) {
        super(message);
    }
}
