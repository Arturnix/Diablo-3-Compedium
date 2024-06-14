package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //na jaki rodzaj zapytania ma byc zwracany ten index
    @RequestMapping("/") //jakiekolwiek zapytanie, które przyjedzie od usera będzie odpowiadalo ta strona index. W () podaje jaka sciezke ma to obslugiwac. Daje "/" czyli domyslny adres strony internetowej
    public String getMainPage() { //przekierowanie usera na moj zasob index kiedy wchodzi na domylsna strone internetowa czyli "/"
        return "index"; //dlatego, że widok index.html mam w domylsnym do tego calu katalogu czyli resources to nie musze podawac tutaj sciezki do tego zasobu tylko jego nazwe
    }
}
