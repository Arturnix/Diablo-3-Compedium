package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "player")
public class UserDataModel {
    @Id
    @GeneratedValue
    private long id;
    @Email
    @NotNull (message = "Email may not be null")
    @NotEmpty (message = "Email may not be empty")
    @NotBlank (message = "Email may not be blank")
    @Column(unique = true)
    private String email;
    @NotNull (message = "Password may not be null")
    @NotEmpty (message = "Password may not be empty")
    @NotBlank (message = "Password may not be blank")
    private String password;
    @OneToMany(mappedBy = "userDataModel", cascade=CascadeType.MERGE) //1 user ma wiele postaci przypisanych do BattleTag - konta.
    private List<CharacterDataModel> characterDataModels;
    @NotNull (message = "BattleTag may not be null")
    @NotEmpty (message = "BattleTag may not be empty")
    @NotBlank (message = "BattleTag may not be blank")
    @Column(unique = true)
    private String battleTag;

    public UserDataModel() {
    }

    public UserDataModel(long id, String email, String password, List<CharacterDataModel> characterDataModels, String battleTag) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.characterDataModels = characterDataModels;
        this.battleTag = battleTag;
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

    public List<CharacterDataModel> getCharacters() {
        return characterDataModels;
    }

    public void setCharacters(List<CharacterDataModel> characterDataModels) {
        this.characterDataModels = characterDataModels;
    }

    public String getBattleTag() {
        return battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", characters=" + characterDataModels +
                ", battleTag='" + battleTag + '\'' +
                '}';
    }
}
