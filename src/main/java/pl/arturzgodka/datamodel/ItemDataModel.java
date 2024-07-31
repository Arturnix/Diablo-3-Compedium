package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name="items")
public class ItemDataModel {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private long itemId;

    protected String bodyPart;
    protected String id;
    protected String name;
    protected int requiredLevel;
    protected String typeName;
    protected String description;
    @Transient //skip saving it, otherwise warning occurs
    protected List<String> randomAffixes;

    protected String setName;

    protected String setDescription;

    protected String iconURL;

    @ManyToOne(fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "character_id") //join column jest zawsze tam gdzie adnotacja many to one
    private CharacterDataModel characterDataModel;

    @ManyToOne(fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "follower_id") //join column jest zawsze tam gdzie adnotacja many to one
    private FollowerDataModel followerDataModel;

    public ItemDataModel() {
    }

    public ItemDataModel(String name, int requiredLevel, String typeName, String description, List<String> randomAffixes, String setName, String setDescription, String iconURL) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.typeName = typeName;
        this.description = description;
        this.randomAffixes = randomAffixes;
        this.setName = setName;
        this.setDescription = setDescription;
        this.iconURL = iconURL;
    }

    public ItemDataModel(String bodyPart, String id, String name) {
        this.bodyPart = bodyPart;
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getRequiredLevel() {
        return this.requiredLevel;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getRandomAffixes() {
        return randomAffixes;
    }

    public String getSetName() {
        return setName;
    }

    public String getSetDescription() {
        return setDescription;
    }

    public String getIconURL() {
        return iconURL;
    }

    public CharacterDataModel getCharacterDataModel() {
        return characterDataModel;
    }

    public void setCharacterDataModel(CharacterDataModel characterDataModel) {
        this.characterDataModel = characterDataModel;
    }

    public FollowerDataModel getFollowerDataModel() {
        return followerDataModel;
    }

    public void setFollowerDataModel(FollowerDataModel followerDataModel) {
        this.followerDataModel = followerDataModel;
    }

    @Override
    public String toString() { //ItemDataModel pobrany przez CharacterHandlerApi
        return "ItemDataModel{" +
                "bodyPart='" + bodyPart + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", requiredLevel=" + requiredLevel +
                '}';
    }
}
