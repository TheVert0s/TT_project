package com.kacper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    // zarzadzanie rolami i uprawnieniami
    // kazdy z userow ma role i kazda z rol moze miec wiele uprawnien

    /*
        Operacje:
            przypisanie uprawnien do rol
            przypisanie rol do uzytkownika
     */

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
