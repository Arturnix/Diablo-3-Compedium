package pl.arturzgodka.datamodel;

import java.util.List;

public class HeroSkillDataModel extends SkillDataModel{
    private final String iconURL;
    private final List<SkillDataModel> skillRunes;

    public HeroSkillDataModel(String name, int level, String description, String icon, List<SkillDataModel> skillRunes) {
        super(name, level, description);
        this.iconURL = icon;
        this.skillRunes = skillRunes;
    }

    public String getIconURL() {
        return iconURL;
    }

    public List<SkillDataModel> getSkillRunes() {
        return skillRunes;
    }

    @Override
    public String toString() {
        return "heroSkillDataModel{" +
                "iconURL='" + iconURL + '\'' +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", description='" + description + '\'' +
                '}';
    }
}
