package in.leazeit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEAZEIT_PROPERTY_ASSETS")
public class PropertyAssets {

    @Id
    private String uniqueId;

    private String propertyId;

    @Lob
    private byte[] asset;

    private Boolean isDP;

    private String fileType;




}
