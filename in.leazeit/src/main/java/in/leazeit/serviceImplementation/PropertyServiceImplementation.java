package in.leazeit.serviceImplementation;

import in.leazeit.entity.Property;
import in.leazeit.exception.CustomException;
import in.leazeit.repository.OwnerDetailsRepository;
import in.leazeit.repository.PropertyRepository;
import in.leazeit.payload.AddPropertyRequest;
import in.leazeit.service.PropertyService;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PropertyServiceImplementation implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ConstantStatements constantStatements;

    @Autowired
    private OwnerDetailsRepository ownerDetailsRepository;

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(String id) {
        if (propertyRepository.findById(id).isPresent()) {
            return propertyRepository.findById(id).get();
        }else {
            throw new CustomException(constantStatements.getErrorCode7(), constantStatements.getErrorMessage7(), "Records with this id does not exist");
        }
    }

    @Override
    public List<Property> getPropertyByCity(String city) {
        return propertyRepository.findByCityIgnoreCase(city);
    }

    @Override
    public Property addProperty(AddPropertyRequest request, String userEmail) {

        if(!ownerDetailsRepository.existsById(request.getOwnerEmail())){
            throw new CustomException(constantStatements.getErrorCode10(), constantStatements.getErrorMessage10(), "Could not add the property as the owner does nto exist");
        }

        Property property = new Property();
        property.setUniqueId(UUID.randomUUID().toString());
        property.setIsActive(true);
        property.setCreatedBy(userEmail);
        property.setLastUpdatedBy(userEmail);
        property.setPropertyName(request.getPropertyName());
        property.setShortDescription(request.getShortDescription());
        property.setLongDescription(request.getLongDescription());
        property.setRent(request.getRent());
        property.setArea(request.getArea());
        property.setCapacity(request.getCapacity());
        property.setFacilities(request.getFacilities());
        property.setTenantsAllowed(request.getTenantsAllowed());
        property.setSecurityDepositAmount(request.getSecurityDepositAmount());
        property.setIsAvailable(request.getIsAvailable());
        property.setBookedTill(request.getBookedTill());
        property.setAvailableFrom(request.getAvailableFrom());
        property.setLandmark(request.getLandmark());
        property.setDistanceFromLandmark(request.getDistanceFromLandmark());
        property.setStreetName(request.getStreetName());
        property.setCity(request.getCity());
        property.setState(request.getState());
        property.setPinCode(request.getPinCode());
        property.setOwnerEmail(request.getOwnerEmail());

        return propertyRepository.save(property);
    }

}
