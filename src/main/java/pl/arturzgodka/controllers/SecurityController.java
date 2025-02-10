package pl.arturzgodka.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.arturzgodka.databaseutils.CharacterDao;
import pl.arturzgodka.databaseutils.UserDao;
import pl.arturzgodka.datamodel.*;

import java.util.List;
import java.util.Map;


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

      model.addAttribute("user", user);

        return "security/profile";
    }

    @GetMapping("profile/{battleTag}/character/{characterId}")
    public String getCharacter(@PathVariable("battleTag") String battleTag, @PathVariable("characterId") int characterId, Model model) {
        CharacterDao dao = new CharacterDao();
        CharacterDataModel selectedCharacter = dao.findCharacterById(characterId);
        Map<String, Integer> stats = selectedCharacter.getStats();
        List<ItemDataModel> items = selectedCharacter.getItems().stream().filter(item -> item.getFollowerDataModel() == null).toList();
        List<FollowerDataModel> followers = selectedCharacter.getFollowers();

        model.addAttribute("battleTag", battleTag);
        model.addAttribute("character", selectedCharacter);
        model.addAttribute("stats", stats);
        model.addAttribute("items", items);
        model.addAttribute("followers", followers);

        return "security/character";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:" + "index";
    }
}
