package payroll.exceptions;

public class InvalidHourlyRateException extends RuntimeException {
    public InvalidHourlyRateException(String message) {
        super(message);
    }
}
