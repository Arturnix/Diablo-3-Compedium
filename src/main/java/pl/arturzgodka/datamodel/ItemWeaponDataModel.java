package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name="weapons")
public class ItemWeaponDataModel extends ItemDataModel {
    private String minDamage;
    private String maxDamage;
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

   /* public ItemWeaponDataModel(String name, int requiredLevel, String minDamage, String maxDamage, Map<String, List<String>> attributes) {
        super(name);
        this.requiredLevel = requiredLevel;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.attributes = attributes;
    } */

    public ItemWeaponDataModel(String name, int requiredLevel, String minDamage, String maxDamage, Map<String, List<String>> attributes) {
        super(name, requiredLevel);
        this.requiredLevel = requiredLevel;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.attributes = attributes;
    }

    public String getName() {
        return super.getName();
    }

    public String getMinDamage() {
        return this.minDamage;
    }

    public String getMaxDamage() {
        return this.maxDamage;
    }

    public Map<String, List<String>> attributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "ItemWeaponDataModel{" +
                "itemBodyPartSlots='" + itemBodyPartSlots + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attributes='" + attributes + '\'' +
                ", minDamage='" + minDamage + '\'' +
                ", maxDamage='" + maxDamage + '\'' +
                '}';
    }
}
