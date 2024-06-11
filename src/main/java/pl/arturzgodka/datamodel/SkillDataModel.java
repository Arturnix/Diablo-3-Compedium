package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="skills")
public class SkillDataModel {

    @Id
    @GeneratedValue
    @NotNull(message = "Skill id may not be null")
    @Column(unique = true)
    private long skillId;
    @NotNull(message = "Skill type may not be null")
    @NotEmpty(message = "Skill type may not be empty")
    @NotBlank(message = "Skill type may not be blank")
    private String type;
    @NotNull(message = "Skill slug may not be null")
    @NotEmpty(message = "Skill slug may not be empty")
    @NotBlank(message = "Skill slug may not be blank")
    private String slug;
    @NotNull(message = "Skill name may not be null")
    @NotEmpty(message = "Skill name may not be empty")
    @NotBlank(message = "Skill name may not be blank")
    private String name;
    @NotNull(message = "Skill level may not be null")
    private int level;
    //@Lob //pozwala na zapis ciagu znakow > 255 znakow. Zapisuje jako obiekt w bazie danych
    @Column(length = 1000)
    private String description;
    @ManyToOne(fetch= FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "character_id") //join column jest zawsze tam gdzie adnotacja many to one
    private CharacterDataModel characterDataModel;

    public SkillDataModel() {
    }

    public SkillDataModel(String type, String slug, String name, int level, String description) {
        this.type = type;
        this.slug = slug;
        this.name = name;
        this.level = level;
        this.description = description;
    }

    public CharacterDataModel getCharacterDataModel() {
        return characterDataModel;
    }

    public void setCharacterDataModel(CharacterDataModel characterDataModel) {
        this.characterDataModel = characterDataModel;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "SkillDataModel{" +
                "type='" + type + '\'' +
                ", slug='" + slug + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", description='" + description + '\'' +
                '}';
    }
}
