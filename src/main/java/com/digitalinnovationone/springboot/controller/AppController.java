package com.digitalinnovationone.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:NENHUMA}") // caso não tenha nenhuma ele assume o valor NENHUMA
    private String dbEnvironmentVariable;

    @GetMapping("/") // serve para fazer a exibição direta no brownser
    public String getAppMessage(){
        return appMessage;
    }

    //fazer exibição no browser
    @GetMapping("/envVariable")
    public String getDbEnvironmentVariable(){
        return "A seguinte variável de ambiente foi passada:  " + dbEnvironmentVariable;
    }
}
