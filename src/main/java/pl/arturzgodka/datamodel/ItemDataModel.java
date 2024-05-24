package pl.arturzgodka.datamodel;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="items")
public class ItemDataModel {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private long itemId;

    protected String bodyPart;
    protected String id;
    protected String name;
    @ManyToOne(fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "character_id") //join column jest zawsze tam gdzie adnotacja many to one
    private CharacterDataModel characterDataModel;

    /*protected int requiredLevel;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    protected List<String> itemBodyPartSlots;
    @SuppressWarnings("JpaAttributeTypeInspection")
    @JdbcTypeCode(SqlTypes.JSON)
    protected Map<String, List<String>> attributes;*/ //(key is the primary/secondary attribute, value is list of attributes)

    public ItemDataModel() {
    }

    public ItemDataModel(String bodyPart, String id, String name) {
        this.bodyPart = bodyPart;
        this.id = id;
        this.name = name;
    }

    /*public ItemDataModel(List<String> itemBodyPartSlots, String id, String name, int requiredLevel, Map<String, List<String>> attributes) {
        this.itemBodyPartSlots = itemBodyPartSlots;
        this.id = id;
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.attributes = attributes;
    }*/

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public CharacterDataModel getCharacterDataModel() {
        return characterDataModel;
    }

    public void setCharacterDataModel(CharacterDataModel characterDataModel) {
        this.characterDataModel = characterDataModel;
    }

    @Override
    public String toString() { //ItemDataModel pobrany przez CharacterHandlerApi
        return "ItemDataModel{" +
                "bodyPart='" + bodyPart + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /*public List<String> getItemBodyPartSlots() {
        return this.itemBodyPartSlots;
    }*/

    /*@Override
    public String toString() {
        if(attributes == null) { //ItemDataModel pobrany przez CharacterHandlerApi
            return "ItemDataModel{" +
                    "bodyPart='" + bodyPart + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        } else {
            return "ItemDataModel{" + //ItemDataModel pobrany przez ItemHandlerApi. usunac jesli tych pol juz nie ma w klasie
                    "bodyPart='" + bodyPart + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", requiredLevel='" + requiredLevel + '\'' +
                    ", attributes='" + attributes + '\'' +
                    '}';
        }
    }*/
}
