package com.aishwarya.productservicesept.exceptions;

/*
1. Compile / Checked exceptions = needs to be handled
Root class is Exception
2. Runtime / Unchecked exceptions
Throwable inherited by
Exception inherited by
RuntimeException
 */

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
