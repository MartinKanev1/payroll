package models;

import java.util.ArrayList;
import java.util.List;

public class PayrollReport {

    private final List<PayrollReportEntry> entries = new ArrayList<>();
    private double totalGross;
    private double totalTax;
    private double totalNet;

    public void addEntry(PayrollReportEntry entry) {
        entries.add(entry);
        totalGross += entry.grossPay();
        totalTax += entry.tax();
        totalNet += entry.netPay();
    }

    public List<PayrollReportEntry> getEntries() {
        return entries;
    }

    public double getTotalGross() {
        return totalGross;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getTotalNet() {
        return totalNet;
    }
}