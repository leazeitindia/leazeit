package in.leazeit.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.ElementCollection;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class AddPropertyRequest {

    @NotEmpty(message = "PropertyName has to be provided")
    @Size(min = 1, max = 100, message = "PropertyName can have min 1 and max 100 characters")
    @NotBlank(message = "PropertyName cannot be just blank spaces")
    private String propertyName;

    @NotEmpty(message = "ShortDescription has to be provided")
    @Size(min = 1, max = 250, message = "ShortDescription can have min 1 and max 250 characters")
    @NotBlank(message = "ShortDescription cannot be just blank spaces")
    private String shortDescription;

    @Size(max = 500, message = "LongDescription can have max 500 characters")
    private String longDescription;

    @DecimalMin(value = "100.00", message = "Rent cannot be less than Rs 100.00")
    @NotNull(message = "Rent has to be provided")
    private Double rent;

    @DecimalMin(value = "0.1", message = "Area cannot be less than 0.1 sq ft.")
    @NotNull(message = "Area has to be provided")
    private Double area;

    @Range(min = 1, message = "Capacity cannot be less than 1")
    @NotNull(message = "Capacity has to be provided")
    private Integer capacity;

    @NotNull(message = "Facilities array can be empty but not null. You have to provide an empty array.")
    private List<String> facilities;

    @NotEmpty(message = "TenantsAllowed cannot be empty")
    @Size(min = 3, max = 15, message = "TenantsAllowed can be between 3 to 15 characters")
    @NotBlank(message = "TenantsAllowed cannot be just blank spaces")
    private String tenantsAllowed;

    @DecimalMin(value = "0.00", message = "SecurityDepositAmount cannot be less than Rs 0.00")
    @NotNull(message = "SecurityDepositAmount has to be provided")
    private Double securityDepositAmount;

    @NotNull(message = "true/false value has to be provided for IsAvailable")
    private Boolean isAvailable;

    @FutureOrPresent(message = "bookedTill cannot be past date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar bookedTill;

    @FutureOrPresent(message = "availableFrom cannot be past date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar availableFrom;

    @NotEmpty(message = "Landmark has to be provided")
    @Size(min = 1, max = 100, message = "Landmark can have min 1 and max 100 characters")
    private String landmark;

    @DecimalMin(value = "0.01", message = "DistanceFromLandmark cannot be less than 0.00 KM")
    private Double distanceFromLandmark;

    @Size(min = 1, max = 100, message = "StreetName can have min 1 and max 100 characters")
    private String streetName;

    @NotEmpty(message = "City has to be provided")
    @Size(min = 1, max = 100, message = "City can have min 1 and max 100 characters")
    @NotBlank(message = "City cannot be just blank spaces")
    private String city;

    @NotEmpty(message = "State has to be provided")
    @Size(min = 1, max = 100, message = "State can have min 1 and max 100 characters")
    @NotBlank(message = "State cannot be just blank spaces")
    private String state;

    @Min(value = 100000, message = "Minimum value for PinCode is 100000")
    @NotNull(message = "PinCode has to be provided")
    private Long pinCode;

    @Email(message = "OwnerEmail is not valid")
    private String ownerEmail;
}
