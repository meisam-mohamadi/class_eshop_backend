package com.api.eshop.exceptions;

public class ApiExceptionMessageParser {
    public static String getErrorReasonByExceptionMessage(String message) {
        if (message.contains("uniqueUsernameConstraint"))
            return "this email registered";
        else if (message.contains("uniqueMobileNumberConstraint"))
            return "this mobile number registered";
        else
            return "unknown exception";
    }
}
