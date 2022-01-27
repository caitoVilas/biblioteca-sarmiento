package com.caito.sarmientolibrary.constants;

public class ErrorMessageConstant {

    // AUTHOR
    public static final String MSG_AUT_NO_NAME = "El campo nombre es requerido!";
    public static final String MSG_AUT_NO_LASTNAME = "El campo apellido es requerido!";
    public static final String MSG_AUT_NO_FOUND = "No se encuentra el autor con id: ";
    public static final String MSG_AUT_NO_CHANGES = "No hay cambios para aplicar al Autor!";

    //CATEGORY
    public static final String MSG_CTG_NO_NAME = "El campo nombre es requerido!";
    public static final String MSG_CTG_NO_FOUND = "No se encuentra la categoria con id: ";
    public static final String MSG_CTG_NO_CHANGES = "No hay cambios para aplicar a la Categoria!";

    //PARTNER
    public static final String MSG_PRT_DNI_EXIST = "El DNI ya esta registrado!";
    public static final String MSG_PRT_EMAIL_EXIST = "El email ya esta registrado!";
    public static final String MSG_PRT_NO_DNI = "El DNI es requerido!";
    public static final String MSG_PRT_NO_EMAIL = "El email es requerido!";
    public static final String MSG_PRT_NO_ADDRESS = "El Domicilio es requerido!";
    public static final String MSG_PRT_NO_PHONE = "El telefono es requerido!";
    public static final String MSG_PRT_NO_FOUND = "No se encuentra el Socio con el id: ";
    public static final String MSG_PRT_NO_FOUND_DNI = "No se encuentra el Socio con el DNI: ";

    //BOOKS
    public static final String MSG_BOK_NO_TITLE = "El titulo es requerido!";
    public static final String MSG_BOK_NO_AUT_ID = "El Id del Autor es requerido!";
    public static final String MSG_BOK_NO_CTG_ID = "El Id de la categoria es requerido!";
    public static final String MSG_BOK_NO_PAGES = "El numero de paginas es requerido!";
    public static final String MSG_BOK_NO_FOUND = "No se encuentra el Libro con id: ";
    public static final String MSG_BOX_NO_CRITERION = "No se especifico parametro de busqueda!";
    public static final String MSG_BOX_CRITERION_ERROR = "El criterio de busqueda no existe";
    public static final String MSG_BOX_NO_EDT_ID = "El id de la editorial es requerido!";

    //EDITORIAL
    public static final String MSG_EDT_NO_NAME = "El nombre es requerido!";
    public static final String MSG_EDT_NAME_EXISTS = "El nombre de la Editorial ya existe!";
    public static final String MSG_EDT_NO_FOUND = "No se encuentra la editorial con id: ";
}
