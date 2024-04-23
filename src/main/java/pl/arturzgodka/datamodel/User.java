package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Email
    @NotNull (message = "Email may not be null")
    @NotEmpty (message = "Email may not be empty")
    @NotBlank (message = "Email may not be blank")
    private String email;
    @NotNull (message = "Password may not be null")
    @NotEmpty (message = "Password may not be empty")
    @NotBlank (message = "Password may not be blank")
    private String password;
    @OneToMany //1 user ma wiele postaci przypisanych do BattleTag - konta.
    private List<Character> characters;
    @NotNull (message = "BattleTag may not be null")
    @NotEmpty (message = "BattleTag may not be empty")
    @NotBlank (message = "BattleTag may not be blank")
    private String battleTag;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }
}
