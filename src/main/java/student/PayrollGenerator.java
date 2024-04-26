package student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.LinkedList;

/**
 * Main driver for the PayrollGenerator program.
 * 
 * Students, you are free to modify this file as needed, but you need to leave in the parts were we
 * can pass in the employee and payroll files as arguments.
 * 
 * Grading wise, we will both be using unit tests, and running your program with different employee
 * fils. We also will create a separate output file for each.
 * 
 * 
 * To run the program, you can use the following command:
 * 
 * java student.PayrollGenerator -i employees_mine.csv -o pay_stubs_mine.csv or java
 * student.PayrollGenerator The above defaults to using employees.csv as the input file and
 * pay_stubs.csv as the output file.
 **/
public final class PayrollGenerator {
    /** default file name for employees. */
    private static final String DEFAULT_EMPLOYEE_FILE = "resources/employees.csv";
    /** default file name for pay stub output. */
    private static final String DEFAULT_PAYROLL_FILE = "resources/pay_stubs.csv";
    /** default time card file name. */
    private static final String DEFAULT_TIME_CARD_FILE = "resources/time_cards.csv";


    /**
     * private constructor to prevent instantiation.
     */
    private PayrollGenerator() {

    }

    /**
     * Main driver for the program.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Arguments arguments = Arguments.process(args); // leave this, and make sure you use it on
                                                       // reading/writing files!

        // you are free to modify this code, or use it as a basis for your code
        // depends on how you want to implement the program

        List<String> employeeLines = FileUtil.readFileToList(arguments.getEmployeeFile());
        List<String> timeCards = FileUtil.readFileToList(arguments.getTimeCards());


        // Create your driver - you can do it here, or call other methods, or change this
        // main completely minus using the arguments!

        // now save out employees to a new file

        // example of how we saved out files! You don't have to follow, depends
        // on how you want to implement the program
        /*
         * employeeLines = employees.stream().map(IEmployee::toCSV).collect(Collectors.toList());
         * employeeLines.add(0, FileUtil.EMPLOYEE_HEADER);
         * FileUtil.writeFile(arguments.getEmployeeFile(), employeeLines);
         */

        // now save out the pay stubs

    }


    /**
     * This is an internal class. Please leave it as is/do not modify! This design is common for
     * processing arguments if you want to make sure it is unique to the driver.
     */
    private static final class Arguments {
        /** sets the employeeFile argument. */
        private String employeeFile = DEFAULT_EMPLOYEE_FILE;

        /** sets the payrollFile argument. */
        private String payrollFile = DEFAULT_PAYROLL_FILE;

        /** sets the timeCards argument. */
        private String timeCards = DEFAULT_TIME_CARD_FILE;


        /**
         * Constructor for Arguments. Setup as private, so builder has to be used.
         * 
         * @see #process(String[])
         */
        private Arguments() {

        }

        /**
         * Gets the employee file.
         * 
         * @return the name of the employee file
         */
        public String getEmployeeFile() {
            return employeeFile;
        }

        /**
         * Gets the payroll file.
         * 
         * @return the name of the payroll file
         */
        public String getPayrollFile() {
            return payrollFile;
        }

        /**
         * Gets the time card file.
         * 
         * @return the name of the time card file
         */
        public String getTimeCards() {
            return timeCards;
        }

        /**
         * Prints the help message.
         */
        public void printHelp() {
            System.out.println(
                    "Usage: java student.PayrollGenerator [-e employee_file] [-t time_cards_file] [-o payroll_file]");
            System.out.println("Options:");
            System.out.println(
                    "  -e employee_file  Input file containing employee information. Default is employees.csv");
            System.out.println(
                    "  -t time_cards_file  Input file containing time card information. Default is time_cards.csv");
            System.out.println(
                    "  -o payroll_file   Output file containing payroll information. Default is pay_stubs.csv");
            System.out.println("  -h                Print this help message");
        }

        /**
         * Processes the arguments.
         * 
         * @param args the arguments
         * @return an Argument object with file names added
         */
        public static Arguments process(String[] args) {
            Arguments arguments = new Arguments();
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-e")) {
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        arguments.employeeFile = args[i + 1];
                    } else {
                        System.out.println("Missing argument for -i option");
                        arguments.printHelp();
                        System.exit(1);
                    }
                } else if (args[i].equals("-t")) {
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        arguments.timeCards = args[i + 1];
                    } else {
                        System.out.println("Missing argument for -t option");
                        arguments.printHelp();
                        System.exit(1);
                    }
                } else if (args[i].equals("-o")) {
                    if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        arguments.payrollFile = args[i + 1];
                    } else {
                        System.out.println("Missing argument for -o option");
                        arguments.printHelp();
                        System.exit(1);
                    }
                } else if (args[i].equals("-h")) {
                    arguments.printHelp();
                    System.exit(0);
                } else if (args[i].startsWith("-")) {
                    System.out.println("Unknown option: " + args[i]);
                    arguments.printHelp();
                    System.exit(1);
                }
            }
            return arguments;
        }
    }

}
