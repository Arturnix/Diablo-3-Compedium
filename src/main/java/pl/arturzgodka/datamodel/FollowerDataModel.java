package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="followers")
public class FollowerDataModel {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int level;
    @SuppressWarnings("JpaAttributeTypeInspection")
    //@JdbcTypeCode(SqlTypes.JSON)
    @OneToMany(mappedBy = "followerDataModel", cascade= jakarta.persistence.CascadeType.ALL/*MERGE*/)
    private List<ItemDataModel> items;
    @SuppressWarnings("JpaAttributeTypeInspection") //niweluje warning
    @ElementCollection
    @CollectionTable(name = "stats_follower",
            joinColumns = {@JoinColumn(name = "follower_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "type")
    @Column(name = "value")
    private Map<String, Integer> stats;

    @ManyToOne(fetch= FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "character_id") //join column jest zawsze tam gdzie adnotacja many to one
    private CharacterDataModel characterDataModel;

    public FollowerDataModel() {
    }

    public FollowerDataModel(String name, int level, List<ItemDataModel> items, Map<String, Integer> stats) {
        this.name = name;
        this.level = level;
        this.items = items;
        this.stats = stats;
    }

    public CharacterDataModel getCharacterDataModel() {
        return characterDataModel;
    }

    public List<ItemDataModel> getItems() {
        return items;
    }

    public void setItems(List<ItemDataModel> items) {
        this.items = items;
    }

    public void setCharacterDataModel(CharacterDataModel characterDataModel) {
        this.characterDataModel = characterDataModel;


    }

    @Override
    public String toString() {
        return "FollowerDataModel{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", items=" + items +
                ", stats=" + stats +
                '}';
    }
}
