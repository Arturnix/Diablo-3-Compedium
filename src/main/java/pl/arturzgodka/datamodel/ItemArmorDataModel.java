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
    private Map<String, List<String>> attributes; //(key is the primary/secondary attribute, value is list of attributes)

    public ItemArmorDataModel() {
    }

    public ItemArmorDataModel(List<String> itemBodyPartSlots, String id, String name, int requiredLevel, Map<String, List<String>> attributes, String armor) {
        this.requiredLevel = requiredLevel;
        this.armor = armor;
    }
 //czy te wszystkie konstruktory sa wykorzystywane???
    public ItemArmorDataModel(String bodyPart, String id, String name, String armor) {
        super(bodyPart, id, name);
        this.armor = armor;
    }

    public ItemArmorDataModel(String name, int requiredLevel, String armor) {
        super(name);
        this.requiredLevel = requiredLevel;
        this.armor = armor;
    }

    public String getArmor() {
        return this.armor;
    }

    public int getRequiredLevel() {
        return this.requiredLevel;
    }

    public String getName() {
        return super.getName();
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
