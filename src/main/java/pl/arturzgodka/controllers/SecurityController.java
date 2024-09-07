package pl.arturzgodka.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
        CharactersForAccountProvider charactersForAccountProvider = new CharactersForAccountProvider();

        user.setCharacters(charactersForAccountProvider.assignUserToCharactersOnProvidedAccount(user));
        dao.saveUser(user);

        return "redirect:" + "index";
    }

  @GetMapping("/profile")
    public String getEmailFromLoginForm(Authentication auth, Model model) {
      UserDao dao = new UserDao();
      String email = auth.getName();
      UserDataModel user = dao.findUserByEmail(email);

      model.addAttribute(user);

        return "security/profile";
    }

}
