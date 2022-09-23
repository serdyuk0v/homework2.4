package org.example;

import org.example.exception.WrongLoginException;
import org.example.exception.WrongPasswordException;

public class CheckFormRegister {

    public static boolean outCheck(String login,
                                   String password,
                                   String confirmPassword) {
        try {
            checkWritingForm(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void checkWritingForm(String login,
                                        String password,
                                        String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login.length() >= 20 || login == null)
            throw new WrongLoginException("Длина логина не соответствует!");
        if (!login.matches("[A-z0-9_]"))
            throw new WrongLoginException("Введён не корректный логин!");
        if (password.length() > 20 || password == null)
            throw new WrongPasswordException("Длина пароля не соответствует!");
        if (!password.matches("\\w"))
            throw new WrongPasswordException("Введён не корректный пароль!");
        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Пароли не совпадают!");

    }
}
