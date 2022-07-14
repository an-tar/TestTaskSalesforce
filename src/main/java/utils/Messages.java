package utils;

import lombok.Getter;

public enum Messages {

    ACCOUNT_CREATED("Account \"%s\" was created."),
    ACCOUNT_UPDATED("Account \"%s\" was saved.");

    @Getter
    private final String message;

    Messages(String message) {
        this.message = message;
    }
}
