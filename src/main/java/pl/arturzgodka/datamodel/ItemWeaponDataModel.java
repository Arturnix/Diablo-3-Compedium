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

    //TODO move fields below to ItemDataModel class since these fields and shareable among child classes of ItemDataModel class.

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

    public ItemWeaponDataModel(String name, int requiredLevel, String typeName, String description, List<String> randomAffixes, String setName, String setDescription, String iconURL, String minDamage, String maxDamage, Map<String, List<String>> attributes) {
        super(name, requiredLevel, typeName, description, randomAffixes, setName, setDescription, iconURL);
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

    public String getTypeName() {
        return super.getTypeName();
    }

    public List<String> randomAffixes() {
        return super.getRandomAffixes();
    }

    public Map<String, List<String>> attributes() {
        return attributes;
    }

    @Override
    public String toString() {
        return "ItemWeaponDataModel{" +
                "minDamage='" + minDamage + '\'' +
                ", maxDamage='" + maxDamage + '\'' +
                ", itemBodyPartSlots=" + itemBodyPartSlots +
                ", attributes=" + attributes +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", requiredLevel=" + requiredLevel +
                ", typeName='" + typeName + '\'' +
                ", description='" + description + '\'' +
                ", randomAffixes=" + randomAffixes +
                ", setName='" + setName + '\'' +
                ", setDescription='" + setDescription + '\'' +
                '}';
    }
}
