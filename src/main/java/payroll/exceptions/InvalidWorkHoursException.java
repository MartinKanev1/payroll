package payroll.exceptions;

public class InvalidWorkHoursException extends RuntimeException {
    public InvalidWorkHoursException(String message) {
        super(message);
    }
}
