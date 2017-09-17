package com.ktx.common.condition;

import com.ktx.Exception.MyBadRequestException;
import com.ktx.Exception.MyConflictException;
import com.ktx.Exception.MyResourceNotFoundException;

public class RestPreConditions {

    public static <T> T checkRequestElementNotNull(final T value) {
        return checkRequestElementNotNull(value, null);
    }

    public static <T> T checkRequestElementNotNull(final T value, String message) {
        if (value == null)
            throw new MyBadRequestException(message);
        else
            return value;
    }

    public static void checkRequestState(final boolean expression) {
        checkRequestState(expression, null);
    }

    public static void checkRequestState(final boolean expression, final String message) {
        if (!expression) {
            throw new MyConflictException(message);
        }
    }

    public static <T> T checkNotNull(final T reference) {
        return checkNotNull(reference, null);

    }

    public static <T> T checkNotNull(final T reference, final String message) {
        if (reference == null) {
            throw new MyResourceNotFoundException(message);
        }
        return reference;
    }
}
