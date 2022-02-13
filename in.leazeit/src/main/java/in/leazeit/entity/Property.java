package in.leazeit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEAZEIT_PROPERTY_DETAILS")
public class Property {

    @Id
    @Column(name = "UNIQUE_ID")
    private String uniqueId;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false, updatable = false)
    private String createdBy;

    @CreationTimestamp
    @PastOrPresent(message = "CreatedOn cannot be future date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdOn;

    @Column(nullable = false)
    private String lastUpdatedBy;

    @UpdateTimestamp
    @PastOrPresent(message = "lastUpdatedOn cannot be future date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Kolkata")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastUpdatedOn;

    @Column(nullable = false)
    private String propertyName;

    @Column(nullable = false)
    private String shortDescription;

    @Column(nullable = false)
    private String longDescription;

    @Column(nullable = false)
    private Double rent;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private Integer capacity;

    @ElementCollection(targetClass=String.class)
    private List<String> facilities;

    @Column(nullable = false)
    private String tenantsAllowed;

    @Column(nullable = false)
    private Double securityDepositAmount;

    @Column(nullable = false)
    private Boolean isAvailable;

    @FutureOrPresent(message = "bookedTill cannot be past date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar bookedTill;

    @FutureOrPresent(message = "availableFrom cannot be past date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar availableFrom;

    @Column(nullable = false)
    private String landmark;

    private Double distanceFromLandmark;

    private String streetName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Long pinCode;

    @Column(nullable = false, updatable = false)
    private String ownerEmail;
}
