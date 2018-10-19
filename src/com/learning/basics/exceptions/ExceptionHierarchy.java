package com.learning.basics.exceptions;

/*
 * As stated earlier, when any exception is raised an exception object is getting created.
 *  Java Exceptions are hierarchical and inheritance is used to categorize different types of exceptions. 
 *  Throwable is the parent class of Java Exceptions Hierarchy and it has two child objects – Error and Exception.
 *   Exceptions are further divided into checked exceptions and runtime exception.
 */

/*
 * 1.Errors: Errors are exceptional scenarios that are out of scope of application and it’s not possible to anticipate and recover from them,
 *  for example hardware failure, JVM crash or out of memory error. That’s why we have a separate hierarchy of errors and we should not try to handle these situations.
 *  Some of the common Errors are OutOfMemoryError and StackOverflowError.
 *  
 * 2. Checked Exceptions: Checked Exceptions are exceptional scenarios that we can anticipate in a program and try to recover from it, for example FileNotFoundException.
 *  We should catch this exception and provide useful message to user and log it properly for debugging purpose.
 *   Exception is the parent class of all Checked Exceptions and if we are throwing a checked exception, 
 *   we must catch it in the same method or we have to propagate it to the caller using throws keyword.
 *   
 * 3.Runtime Exception: Runtime Exceptions are cause by bad programming, for example trying to retrieve an element from the Array.
 *  We should check the length of array first before trying to retrieve the element otherwise it might throw ArrayIndexOutOfBoundException at runtime. 
 *  RuntimeException is the parent class of all runtime exceptions.
 *   If we are throwing any runtime exception in a method, it’s not required to specify them in the method signature throws clause.
 *    Runtime exceptions can be avoided with better programming.     
 */

/*
 * Difference between Checked and Unchecked Exceptions
1) Checked Exception
The classes which directly inherit Throwable class except RuntimeException and Error are known as checked exceptions e.g. IOException, SQLException etc.
 Checked exceptions are checked at compile-time.

2) Unchecked Exception
The classes which inherit RuntimeException are known as unchecked exceptions e.g. ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc.
 Unchecked exceptions are not checked at compile-time, but they are checked at runtime.

3) Error
Error is irrecoverable e.g. OutOfMemoryError, VirtualMachineError, AssertionError etc.
 */
public class ExceptionHierarchy {

}
