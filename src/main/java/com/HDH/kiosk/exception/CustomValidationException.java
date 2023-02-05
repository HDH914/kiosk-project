package com.HDH.kiosk.exception;

import java.util.Map;

public class CustomValidationException {
    private Map<String, String> errorMap;

    public CustomValidationException(String message, Map<String, String> errorMap) {
//        super(message);
        this.errorMap = errorMap;
    }
}
