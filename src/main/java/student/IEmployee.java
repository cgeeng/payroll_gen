package student;

/**
 * An interface for the concept of the employee.
 * 
 * DO NOT MODIFY THIS FILE! (unless you are cleaning up comments/style changes)
 * 
 * This file is provided, and we will be grading every function implemented in as a unit test for
 * both SalaryEmployee and HourlyEmployee.
 */
public interface IEmployee {

    /**
     * Gets the employee's name.
     * 
     * @return the name of the employee
     */
    String getName();

    /**
     * Gets the employee's ID.
     * 
     * @return the ID of the employee
     */
    String getID();

    /**
     * Gets the employee's pay rate.
     * 
     * @return the pay rate of the employee
     */
    double getPayRate();



    /**
     * Gets the YTD earnings of the employee.
     * 
     * @return the YTD earnings of the employee
     */
    double getYTDEarnings();

    /**
     * Gets the YTD taxes paid by the employee.
     * 
     * @return the YTD taxes paid by the employee
     */
    double getYTDTaxesPaid();

    /**
     * Gets pretax deductions for the employee. Yes, on a normal paycheck this varies as either set
     * amounts or percents, and often more than one type of deduction.
     * 
     * For now, you can just assume a single pretax deduction as a whole dollar amount.
     * 
     * @return the pretax deductions for the employee
     */
    double getPretaxDeductions();


    /**
     * Runs the employee's payroll.
     * 
     * This will calculate the pay for the current pay, update the YTD earnings, and update the
     * taxes paid YTD.
     * 
     * taxes are calculated as 1.45% for medicare, 6.2% for social security, and 15% for
     * withholding. or 22.65% total. They are calculated on the net pay (after pretax deductions).
     * 
     * @param hoursWorked the hours worked for the pay period
     * 
     * @return the pay stub for the current pay period
     * 
     */
    IPayStub runPayroll(double hoursWorked);


    /**
     * Converts the employee to a CSV string.
     * 
     * Format of the String s as follows:
     * 
     * employee_type,name,ID,payRate,pretaxDeductions,YTDEarnings,YTDTaxesPaid
     * 
     * employee_type has the options for HOURLY or SALARY.
     * 
     * You do not have to worry about commas in the name or any other field.
     * 
     * @return the employee as a CSV string
     */
    String toCSV();

}
