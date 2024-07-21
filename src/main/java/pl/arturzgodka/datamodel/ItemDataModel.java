package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

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

    public ItemDataModel(String name, int requiredLevel) {
        this.name = name;
        this.requiredLevel = requiredLevel;
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
