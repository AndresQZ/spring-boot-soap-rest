package io.github.andresqz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

//@ComponentScan({
//        "io.github.andresqz.config.*",
//        "io.github.andresqz.endpoint.*",
//})

//@ComponentScan({"io.github.andresqz.repository.*"})
public class SpringBootSoapRestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapRestApp.class, args);
    }

}
