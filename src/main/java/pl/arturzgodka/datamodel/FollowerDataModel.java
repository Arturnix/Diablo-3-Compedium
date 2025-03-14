package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="followers")
public class FollowerDataModel {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private long id;
    @NotNull(message = "Follower name may not be null")
    @NotEmpty(message = "Follower name may not be empty")
    @NotBlank(message = "Follower name may not be blank")
    private String name;
    @NotNull(message = "Follower level may not be null")
    private int level;
    @SuppressWarnings("JpaAttributeTypeInspection")
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Map<String, Integer> getStats() {
        return stats;
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
