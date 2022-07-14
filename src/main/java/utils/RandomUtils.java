package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    public static String getAccountRandomName() {
        return "Account_" + RandomStringUtils.randomNumeric(12);
    }
}
