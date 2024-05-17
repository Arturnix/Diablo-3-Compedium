package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity(name="Characters")
@Table(name="heroes")
public class CharacterDataModel {

    @Id
   /* @NotNull(message = "Id may not be null")
    @NotEmpty(message = "Id may not be empty")
    @NotBlank(message = "Id may not be blank")*/
    @Column(unique = true)
    private int id; //lub int
    /*@NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    @NotBlank(message = "Name may not be blank")*/
    private String name;
    /*@NotNull(message = "Hero class may not be null")
    @NotEmpty(message = "Hero class may not be empty")
    @NotBlank(message = "Hero class may not be blank")*/
    private String classHero;
    /*@NotNull(message = "Email may not be null")
    @NotEmpty(message = "Email may not be empty")
    @NotBlank(message = "Email may not be blank")*/
    private int level;
    /*@NotNull(message = "Email may not be null")
    @NotEmpty(message = "Email may not be empty")
    @NotBlank(message = "Email may not be blank")*/
    private int paragonLevel;
    /*@NotNull(message = "Email may not be null")
    @NotEmpty(message = "Email may not be empty")
    @NotBlank(message = "Email may not be blank")*/
    private boolean hardcore;
   /* @NotNull(message = "Email may not be null")
    @NotEmpty(message = "Email may not be empty")
    @NotBlank(message = "Email may not be blank")*/
    private boolean seasonal;
    private boolean dead;
    @SuppressWarnings("JpaAttributeTypeInspection") //niweluje warning
    @JdbcTypeCode(SqlTypes.JSON)
    private HashMap<String, Integer> kills;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<SkillDataModel> skills;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<ItemDataModel> items;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<FollowerDataModel> followers;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private HashMap<String, Integer> stats;

    @ManyToOne(fetch=FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "user_id") //join column jest zawsze tam gdzie adnotacja many to one
    private UserDataModel userDataModel;

    public CharacterDataModel() {
    }

    public CharacterDataModel(int id, String name, String classHero, int level) {
        this.id = id;
        this.name = name;
        this.classHero = classHero;
        this.level = level;
    }

   public CharacterDataModel(int id, String name, String classHero, int level, int paragonLevel,
                             boolean hardcore, boolean seasonal, boolean dead,
                             HashMap<String, Integer> kills, List<SkillDataModel> skills,
                             List<ItemDataModel> items, List<FollowerDataModel> followers, HashMap<String, Integer> stats) {
        this.id = id;
        this.name = name;
        this.classHero = classHero;
        this.level = level;
        this.paragonLevel = paragonLevel;
        this.hardcore = hardcore;
        this.seasonal = seasonal;
        this.dead = dead;
        this.kills = kills;
        this.skills = skills;
        this.items = items;
        this.followers = followers;
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getClassHero() {
        return this.classHero;
    }

    public int getLevel() {
        return this.level;
    }

    public Map<String, Integer> getKills() {
        return this.kills;
    }

    public List<SkillDataModel> getSkills() {
        return this.skills;
    }

    public List<ItemDataModel> getItems() {
        return this.items;
    }

    public List<FollowerDataModel> getFollowers() {
        return this.followers;
    }

    public Map<String, Integer> getStats() {
        return this.stats;
    }

    public UserDataModel getUser() {
        return userDataModel;
    }

    public boolean isHardcore() {
        return hardcore;
    }

    public void setUser(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setParagonLevel(int paragonLevel) {
        this.paragonLevel = paragonLevel;
    }

    public void setSeasonal(boolean seasonal) {
        this.seasonal = seasonal;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setKills(HashMap<String, Integer> kills) {
        this.kills = kills;
    }

    public void setSkills(List<SkillDataModel> skills) {
        this.skills = skills;
    }

    public void setItems(List<ItemDataModel> items) {
        this.items = items;
    }

    public void setFollowers(List<FollowerDataModel> followers) {
        this.followers = followers;
    }

    public void setStats(HashMap<String, Integer> stats) {
        this.stats = stats;
    }

    public static void showHeroesListForSpecificAccount(List<CharacterDataModel> charactersOnProvidedAccount) {

        for (CharacterDataModel characterDataModel : charactersOnProvidedAccount) {
            StringBuilder str = new StringBuilder();
            str.append("Hero id: ").append(characterDataModel.getId());
            str.append(", name: ").append(characterDataModel.getName());
            str.append(", class: ").append(characterDataModel.getClassHero());
            str.append(", level: ").append(characterDataModel.getLevel());
            System.out.println(str.toString() + '\n');
        }
    }

    @Override
    public String toString() {

        if(getStats() == null) {
            return "HeroDataModel{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", classHero='" + classHero + '\'' +
                    ", level=" + level +
                    '}';
        } else {
        return "HeroDataModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classHero='" + classHero + '\'' +
                ", level=" + level +
                ", paragonLevel=" + paragonLevel +
                ", hardcore=" + hardcore +
                ", seasonal=" + seasonal +
                ", dead=" + dead +
                ", kills=" + kills +
                ", skills=" + skills +
                ", items=" + items +
                ", followers=" + followers +
                ", stats=" + stats +
                '}';
        }
    }
}
