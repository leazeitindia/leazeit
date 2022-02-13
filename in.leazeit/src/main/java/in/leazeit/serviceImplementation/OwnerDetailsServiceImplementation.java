package in.leazeit.serviceImplementation;

import in.leazeit.entity.OwnerDetails;
import in.leazeit.exception.CustomException;
import in.leazeit.payload.AddNewOwnerRequest;
import in.leazeit.payload.GetOwnerDetailsRequest;
import in.leazeit.repository.OwnerDetailsRepository;
import in.leazeit.service.OwnerDetailsService;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerDetailsServiceImplementation implements OwnerDetailsService {

    @Autowired
    private OwnerDetailsRepository ownerDetailsRepository;

    @Autowired
    private ConstantStatements constantStatements;

    @Override
    public OwnerDetails getOwnerDetails(GetOwnerDetailsRequest request) {
        if (ownerDetailsRepository.findById(request.getOwnerEmail()).isPresent()) {
            return ownerDetailsRepository.findById(request.getOwnerEmail()).get();
        }else {
            throw new CustomException(constantStatements.getErrorCode7(), constantStatements.getErrorMessage7(), "Records with this id does not exist");
        }
    }

    @Override
    public OwnerDetails addNewOwnerDetails(AddNewOwnerRequest request) {
        OwnerDetails ownerDetails = new OwnerDetails();
        ownerDetails.setOwnerEmail(request.getOwnerEmail());
        ownerDetails.setOwnerName(request.getOwnerName());
        ownerDetails.setOwnerPhone(request.getOwnerPhone());
        ownerDetails.setOwnerBankAccountNo(request.getOwnerBankAccountNo());
        ownerDetails.setOwnerBankAssociatedPhone(request.getOwnerBankAssociatedPhone());
        ownerDetails.setOwnerNameInBankAccount(request.getOwnerNameInBankAccount());
        ownerDetails.setBankName(request.getBankName());
        ownerDetails.setIfscCode(request.getIfscCode());

        return ownerDetailsRepository.save(ownerDetails);
    }
}
