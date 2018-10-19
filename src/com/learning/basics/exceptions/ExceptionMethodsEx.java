package com.learning.basics.exceptions;


/*
 * Exception Handling in Java – Useful Methods
Java Exception and all of it’s subclasses doesn’t provide any specific methods and all of the methods are defined in the base class Throwable.
 The exception classes are created to specify different kind of exception scenarios so that we can easily identify the root cause and handle the exception according to it’s type.
  Throwable class implements Serializable interface for interoperability.

Some of the useful methods of Throwable class are;


public String getMessage() – This method returns the message String of Throwable and the message can be provided while creating the exception through it’s constructor.
public String getLocalizedMessage() – This method is provided so that subclasses can override it to provide locale specific message to the calling program.
 Throwable class implementation of this method simply use getMessage() method to return the exception message.
public synchronized Throwable getCause() – This method returns the cause of the exception or null id the cause is unknown.
public String toString() – This method returns the information about Throwable in String format, the returned String contains the name of Throwable class and localized message.
public void printStackTrace() – This method prints the stack trace information to the standard error stream,
 this method is overloaded and we can pass PrintStream or PrintWriter as argument to write the stack trace information to the file or stream.
 */
public class ExceptionMethodsEx {

}
