package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="skills")
public class SkillDataModel {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private long skillId;
    private String type;
    private String slug;
    //@Id
    private String name;
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
