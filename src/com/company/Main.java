package com.company;

import Connecion.ConectionBD;
import Controler.com.company.ControllerEntrada;

public class Main {

    public static void main(String[] args) {
        ConectionBD.openConn();
        new ControllerEntrada();
    }
}
