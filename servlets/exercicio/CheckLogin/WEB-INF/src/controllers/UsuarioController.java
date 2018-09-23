package controllers;

import utils.Security;
import exceptions.UnauthorizedUserException;

public class UsuarioControle {
    public boolean validatePassword (String providedPassword) throws UnauthorizedUserException{
        Security sec = new Security();
        currentPassword = sec.hashPassword(providedPassword);
    }
}