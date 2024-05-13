package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
