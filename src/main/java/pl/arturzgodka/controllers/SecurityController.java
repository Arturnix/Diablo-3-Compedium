package pl.arturzgodka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SecurityController {

    @GetMapping("/")
    public String getLoginPage() {
        return "index";
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new UserDataModel());
        return "security/register";
    }

    @PostMapping("/register")
    public String registerUser(UserDataModel user) {
        UserDao dao = new UserDao();
        List<CharacterDataModel> emptyCharactersListForNewUser = new ArrayList<>();

        //user.setCharacters(charactersForAccountProvider.assignUserToCharactersOnProvidedAccount(user));
        user.setCharacters(emptyCharactersListForNewUser);
        dao.saveUser(user);

        return "index";
    }

}
