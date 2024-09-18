package pl.arturzgodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan( basePackages = {"pl.arturzgodka.datamodel.ItemDataModel"} ) // entities package name
public class Diablo3CompediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(Diablo3CompediumApplication.class, args);
    }
}
