package com.digitalinnovationone.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource") //pegue tudo que está definido com prefixo e vamos mapear todos este conjuntos de propriedades
@Getter
@Setter
public class DBConfiguration {

    private String driverClassName; // padrão CamelCase
    private String url;
    private String password;

    // fazer o mapeamento das propriedades para dentro do sistema
    @Profile("dev") // pegar todas as prop de configuração. Injeta um profile de um ambiente na criação de um Bean
    @Bean // instanciar o método como Bean para mostrar tudo conteúdo sendo mapeado na "subida" do sistema
    public String testDatabaseConnection(){
        System.out.println("DB connection for DEV-H2");
        System.out.println(driverClassName);
        System.out.println(url);

        return "DB connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection(){
        System.out.println("DB connection for production - MySQL");
        System.out.println(driverClassName);
        System.out.println(url);

        return "DB Connection to MySQL_PROD - Production instance";
    }
}
