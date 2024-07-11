package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="weapons")
public class ItemWeaponDataModel extends ItemDataModel {
    private String minDamage;
    private String maxDamage;
    private int requiredLevel;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> itemBodyPartSlots;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, List<String>> attributes;

    public ItemWeaponDataModel() {
    }

    public ItemWeaponDataModel(List<String> itemBodyPartSlots, String id, String name, int requiredLevel, Map<String, List<String>> attributes, String minDamage, String maxDamage) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public ItemWeaponDataModel(String name, int requiredLevel, String minDamage, String maxDamage) {
        super(name);
        this.requiredLevel = requiredLevel;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return super.getName();
    }

    public int getRequiredLevel() {
        return this.requiredLevel;
    }

    public String getMinDamage() {
        return this.minDamage;
    }

    public String getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public String toString() {
        return "ItemWeaponDataModel{" +
                "itemBodyPartSlots='" + itemBodyPartSlots + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", requiredLevel=" + requiredLevel +
                ", attributes='" + attributes + '\'' +
                ", minDamage='" + minDamage + '\'' +
                ", maxDamage='" + maxDamage + '\'' +
                '}';
    }
}
