# Payroll Generator Homework Instructions

Payroll is a tedious but important task for companies. It is also a very complex task as companies grow and expand often to multiple regions in the world. Adding to the complexity is the ability to work remotely, so then systems need to be able to track a series of differences given employee type, benefits, roles, taxes, regionals laws, etc. 

When computers first came out, one of their first business applications was focused on accounting and accurately calculating payroll. At the time most of the payroll systems were custom applications writing in [FORTRAN](https://en.wikipedia.org/wiki/Fortran) due to its strength in accurate math calculations. Another popular language for early applications was [COBOL](https://en.wikipedia.org/wiki/COBOL) due to its ability to handle large amounts of data. It was one of the first compiled languages developed by [Admiral Grace Murray-Hopper](https://en.wikipedia.org/wiki/Grace_Hopper)'s team in the 1950s.

The languages used and design of payroll applications have changed over time, but the need for accurate payroll calculations has not.

In this assignment, you will be building a simple payroll generator that reads in employee information and time cards, and then generates pay stubs for each employee.


> [!NOTE]
> If you are curious about the popularity of languages, here is a nice data visualization of the [most popular programming languages](https://www.youtube.com/watch?v=qQXXI5QFUfw) over time. In the end, a language is just a tool, and the most important thing is to understand the concepts behind the language. Also, there is some misleading data, as typescript is a  javascript replacement, so as it grows, javascript shrinks. Same with Kotlin for Java.

## Table of Contents
- [Payroll Generator Homework Instructions](#payroll-generator-homework-instructions)
  - [Table of Contents](#table-of-contents)
  - [Learning Objectives](#learning-objectives)
  - [Instructions](#instructions)
  - [Submission](#submission)
  - [📝 Grading Rubric](#-grading-rubric)
    - [Submission Reminder 🚨](#submission-reminder-)
    - [Autograder Limitation](#autograder-limitation)
  - [Resources](#resources)
    - [String Splitting](#string-splitting)
    - [Rouding to 2 Decimal Places](#rouding-to-2-decimal-places)
    - [Reading Files](#reading-files)
    - [Streams](#streams)
    - [Testing File Contents](#testing-file-contents)


## Learning Objectives
* Designing with inheritance and polymorphism in java
* Practicing Test Driven Development
* Implementing a class hierarchy in Java
* Implementing junit tests for all methods
* Making use of java collections/lists
* Explore the use of streams in Java
* Practice reading and writing files in Java


## Instructions

> [!IMPORTANT]
> This is a two week assignment, spanning multiple modules. It is best to break up the work over those weeks, and not try to do it all in one week. We suggest week one, you focus on design, and the inheritance hierarchy, and then week two you focus on reading/writing files, the main driver method, and your final report.


## Submission

When you are completed, you need to submit your code to gradescope. Go back to Canvas, and click through the link that takes you to the Gradescope assignment. When you submit, you will actually need to pull from your github repository in the dialog that appears. It only pulls the most recent submission, and if you make an update to the repository after you submit, you will need to resubmit to get the latest version in gradescope. 


## 📝 Grading Rubric

1. Learning (AG)
   * Code compiles without issue
   * Code passes all tests both provided and additionally added Greeter.java
2. Approaching (AG)
   * Passes the style check.  
3. Meets (MG)
   * README.md is filled out (name, github repo, etc) 
     * With out the link to your repo, the TAs won't grade the rest!
   * 
4. Exceeds (MG)
   * 

Legend:
* AG - Auto-graded
* MG - Manually graded

### Submission Reminder 🚨
For manually graded elements, we only guarantee time to submit for a regrade IF you submit by the DUE DATE. Submitting late may mean it isn't possible for the MG to be graded before the AVAILABLE BY DATE, removing any windows for you to resubmit in time. While it will be graded, it is always best to submit by the due date, so you have full opportunity to improve your grade.

If you need a reminder about the grading policy, please review the syllabus and the canvas page on 'formative/summative' grading. This class uses a unique grading system that will allow you to be flexible with due dates and multiple resubmissions (if you submit with time for TAs to give feedback), but we also ask that you continue to work on the assignment until you get a full grade.


### Autograder Limitation
Currently the autograder is limited in how it can test. As such, when it comes across an error it just stops. This means that if you have multiple errors in your code, you may only see the first one. We are working on improving this, but for now, you will need to fix the first error, and then rerun the tests to see the next error. Eventually, if every test passes, you will get the single point. It also may give you points for valid style, while errors exist in the code - so really assume the first 2 points are done together. 


## Resources

Different resources that may help you out. Don't forget to check the course [Resources](https://github.com/CS5004-khoury-lionelle/Resources) page for reminders on markdown, git, and other resources.


### String Splitting
* [String Split - W3Schools](https://www.w3schools.com/java/ref_string_split.asp)
* [String Split Examples - Geeks4Geeks](https://www.geeksforgeeks.org/split-string-java-examples/)
* [Java String Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html)
* [String Split Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/String.html#split(java.lang.String))

### Rouding to 2 Decimal Places
* [Big Decimal Example](https://www.baeldung.com/java-round-decimal-number#rounding-doubles-with-bigdecimal)
* [Big Decimal Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/math/BigDecimal.html)
* [Number Formatting in Java](https://www.baeldung.com/java-number-formatting)

### Reading Files
* [Reading Files in Java](https://www.geeksforgeeks.org/different-ways-reading-text-file-java/)
* [Files Javadoc](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html)

### Streams
* [Streams Tutorial (more advanced)](https://www.baeldung.com/java-8-streams)
* Make sure you go back to Team Activity 04 for a refresher on Streams

### Testing File Contents

* [JUnit @TempDir Example (more advanced)](https://www.baeldung.com/junit-5-temporary-directory)


The more common way in JUnit to test files is to make use of the @TempDir, it can be easy to test the contents of a file by reading it in and comparing it to a string. Here is an example of how you might do that:

```java
    @TempDir
    static Path tempDir;

    @Test
    public void testFinalPayStub() throws IOException {
        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", 
                "resources/time_cards.csv",
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);


        // you could also read lines and compared the lists


    }
```

Remember when you test files, it is good to have multiple input/output files to test against! This requires setting a series of resources to help you out, and often manually calculating the expected output. 
