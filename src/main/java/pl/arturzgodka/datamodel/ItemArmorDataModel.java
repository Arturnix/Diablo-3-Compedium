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

    //TODO move fields below to ItemDataModel class since these fields and shareable among child classes of ItemDataModel class.

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
 //TODO czy te wszystkie konstruktory sa wykorzystywane??? Część jest w testach aby twrzoyć uproszczone instancje tej klasy.
    public ItemArmorDataModel(String bodyPart, String id, String name, String armor) {
        super(bodyPart, id, name);
        this.armor = armor;
    }

    public ItemArmorDataModel(String name, int requiredLevel, String typeName, String description, List<String> randomAffixes, String setName, String setDescription, String iconURL, String armor, Map<String, List<String>> attributes) {
        super(name, requiredLevel, typeName, description, randomAffixes, setName, setDescription, iconURL);
        this.armor = armor;
        this.attributes = attributes;
    }

    public String getArmor() {
        return this.armor;
    }

    public String getName() {
        return super.getName();
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
        return "ItemArmorDataModel{" +
                "armor='" + armor + '\'' +
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
