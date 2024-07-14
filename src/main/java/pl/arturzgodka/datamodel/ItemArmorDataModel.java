package pl.arturzgodka.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
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
    //private Map<String, List<String>> attributes; //(key is the primary/secondary attribute, value is list of attributes)
    private Map<String, List<Map<String, String>>> attributes;

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

    public ItemArmorDataModel(String name, int requiredLevel, String armor, Map<String, List<Map<String, String>>> attributes) {
        super(name);
        this.requiredLevel = requiredLevel;
        this.armor = armor;
        this.attributes = attributes;
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

    public List<String> attributesList(String key) {

        if(this.attributes == null) {
            return new ArrayList<>();
        }

        List<String> attributesList = new ArrayList<String>();

        for(int i = 0; i < getAttributesSize(key); i++) {
            attributesList.add(this.attributes.get(key).get(i).get("text"));
        }

        return attributesList;
    }

    public int getAttributesSize(String key) {

        if(this.attributes == null) {
            return 0;
        }

        return this.attributes.get(key).size();
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
