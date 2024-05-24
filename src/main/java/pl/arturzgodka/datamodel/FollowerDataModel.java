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
    @JdbcTypeCode(SqlTypes.JSON)
    private List<ItemDataModel> items;
    @SuppressWarnings("JpaAttributeTypeInspection") //niweluje warning
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Integer> stats;

    /*@ManyToOne(fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "character_id")
    private CharacterDataModel characterDataModel;*/

    public FollowerDataModel() {
    }

    public FollowerDataModel(String name, int level, List<ItemDataModel> items, Map<String, Integer> stats) {
        this.name = name;
        this.level = level;
        this.items = items;
        this.stats = stats;
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
