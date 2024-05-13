package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="skills")
public class SkillDataModel {

    private String type;
    private String slug;
    @Id
    private String name;
    private int level;
    private String description;

    public SkillDataModel() {
    }

    public SkillDataModel(String type, String slug, String name, int level, String description) {
        this.type = type;
        this.slug = slug;
        this.name = name;
        this.level = level;
        this.description = description;
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
