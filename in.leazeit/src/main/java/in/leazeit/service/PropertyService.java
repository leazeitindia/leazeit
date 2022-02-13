package in.leazeit.service;

import in.leazeit.entity.Property;
import in.leazeit.payload.AddPropertyRequest;

import java.util.List;

public interface PropertyService {
    List<Property> getAllProperty();
    Property getPropertyById(String id);
    List<Property> getPropertyByCity(String city);
    Property addProperty(AddPropertyRequest addPropertyRequest, String userEmail);

}
