* You must fork this repository. 
* We expect you to send us a link to your forked repository with your solution. 
* Create HOWTORUN.md explaining how to run the code.
* You have 5 days to complete the assignment.

---

# Payroll System Extension Assignment

You are given an internal payroll system.  
It works but has design issues and missing functionality.

Your task is to extend and improve it.

## Part 1 - Add Hourly Employees

Add support for a new employee type: `hourly`.

Hourly employees:

- hourlyRate
- hoursWorked
- taxRate

formulas:

`grossPay = hourlyRate * hoursWorked`

`tax = grossPay * taxRate`

`netPay = grossPay - tax`


## Part 2 - Overtime Rules

Add overtime rules:

If hoursWorked > 160:

- Extra hours are paid at 1.5× hourly rate

Applies to:

- contractors
- hourly employees

Does **NOT** apply to salaried employees

## Part 3 - Generate Structured Payroll Report

Instead of printing directly inside payroll logic:

- Separate calculation from output  
- Generate a structured report object that contains:

    For each employee:
    - models.Employee name  
    - Employment Type  
    - Gross pay  
    - Tax  
    - Net pay

    Overall totals:

    - Total gross of all employees
    - Total tax of all employees 
    - Total net of all employees

## Part 4 - Improve the codebase

You are free to refactor and improve the codebase as you see fit.

## Part 5 - Add Unit Tests
