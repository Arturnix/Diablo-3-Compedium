package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="armors")
public class ItemArmorDataModel extends ItemDataModel {

    private String armor;
    private int requiredLevel;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> itemBodyPartSlots;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, List<String>> attributes;

    public ItemArmorDataModel() {
    }

    public ItemArmorDataModel(List<String> itemBodyPartSlots, String id, String name, int requiredLevel, Map<String, List<String>> attributes, String armor) {
        this.armor = armor;
    }

    public String getArmor() {
        return this.armor;
    }

    @Override
    public String toString() {
        return "ItemArmorDataModel{" +
                "itemBodyPartSlots='" + itemBodyPartSlots + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", requiredLevel=" + requiredLevel +
                ", attributes='" + attributes + '\'' +
                ", armor=" + armor +
                '}';
    }
}
