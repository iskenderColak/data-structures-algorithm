package com.icolak.tasks.string_tasks;

public class S2_String_PassWordValidation {

    public static void main(String[] args) {

        System.out.println(isValidPassword("Abc1@"));

    }

    public static boolean isValidPassword(String password) {

        boolean hasLowerCaseChar = password.matches("(.*[a-z].*)"),
                hasUpperCaseChar = password.matches("(.*[A-Z].*)"),
                hasDigits = password.matches("(.*[0-9].*)"),
                hasSpecialChar = password.matches("(.*[ -/, :-@].*)");

        if (password.length() >= 6 && !password.contains(" ")) {
            if (hasLowerCaseChar && hasUpperCaseChar && hasDigits && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }
}

/*
        Write a function that can verify if a password is valid or not. requirements:
                1. Password MUST be at least have 6 characters and should not contain space
                2. PassWord should at least contain one upper case letter
                3. PassWord should at least contain one lowercase letter
                4. Password should at least contain one special characters
                5. Password should at least contain a digit

        if all requirements above are met, the method returns true, otherwise returns false
     */
