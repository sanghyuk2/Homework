package week2.Kiosk.Util;

import week2.Kiosk.domain.Category;

import java.util.regex.Pattern;

public class Validator {
    private final static String PATTERN = "([ㄱ-ㅎ가-힣]*(,)){2}[1-9]([0-9]*)$";
    private final static String PATTERN_ERROR = "형식에 맞게 입력해주세요. ex)음식,팟타이,25000";
    public static void validateUpload(String str) {
        if (!Pattern.matches(PATTERN, str)) {
            throw new IllegalArgumentException(PATTERN_ERROR);
        }

        String[] info = str.split(",");
        Category.from(info[0]);
    }
}
