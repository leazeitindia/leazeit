package in.leazeit.service;

import in.leazeit.entity.OwnerDetails;
import in.leazeit.payload.AddNewOwnerRequest;
import in.leazeit.payload.GetOwnerDetailsRequest;

public interface OwnerDetailsService {
    OwnerDetails getOwnerDetails(GetOwnerDetailsRequest request);
    OwnerDetails addNewOwnerDetails(AddNewOwnerRequest request);
}
