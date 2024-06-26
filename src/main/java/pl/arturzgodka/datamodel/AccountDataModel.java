package pl.arturzgodka.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "account")
public class AccountDataModel {

    @Id
    @NotNull(message = "BattleTag may not be null")
    @NotEmpty(message = "BattleTag not be empty")
    @NotBlank(message = "BattleTag not be blank")
    @Column(unique = true)
    private String battleTag;
    @NotNull(message = "Paragon level may not be null")
    private int paragonLevel;
    private String guildName;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<CharacterDataModel> heroes;
    private int highestHardcoreLevel;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Integer> kills;

    public AccountDataModel() {
    }

    public AccountDataModel(String battleTag, int paragonLevel, String guildName, List<CharacterDataModel> heroes, int highestHardcoreLevel, Map<String, Integer> kills) {
        this.battleTag = battleTag;
        this.paragonLevel = paragonLevel;
        this.guildName = guildName;
        this.heroes = heroes;
        this.highestHardcoreLevel = highestHardcoreLevel;
        this.kills = kills;
    }

    public String getBattleTag() {
        return this.battleTag;
    }

    public void setBattleTag(String battleTag) {
        this.battleTag = battleTag;
    }

    public int getParagonLevel() {
        return this.paragonLevel;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public List<CharacterDataModel> getHeroes() {
        return this.heroes;
    }

    public int getHighestHardcoreLevel() {
        return this.highestHardcoreLevel;
    }

    public Map<String, Integer> getKills() {
        return this.kills;
    }

    @Override
    public String toString() {
        return "AccountDataModel{" +
                "battleTag='" + battleTag + '\'' +
                ", paragonLevel=" + paragonLevel +
                ", guildName='" + guildName + '\'' +
                ", heroes=" + heroes +
                ", highestHardcoreLevel=" + highestHardcoreLevel +
                ", kills=" + kills +
                '}';
    }
}
