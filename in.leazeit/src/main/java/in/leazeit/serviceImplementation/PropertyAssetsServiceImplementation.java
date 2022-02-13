package in.leazeit.serviceImplementation;

import in.leazeit.entity.PropertyAssets;
import in.leazeit.exception.CustomException;
import in.leazeit.repository.PropertyAssetsRepository;
import in.leazeit.service.PropertyAssetsService;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PropertyAssetsServiceImplementation implements PropertyAssetsService {

    @Autowired
    private PropertyAssetsRepository propertyAssetsRepository;

    @Autowired ConstantStatements constantStatements;

    @Override
    public List<PropertyAssets> getPropertyAssetsByPropertyId(String id) {
            return propertyAssetsRepository.findByPropertyId(id);
    }

    @Override
    public PropertyAssets addPropertyAssets(String propertyId, MultipartFile asset, Boolean isDP) {
        try{
            PropertyAssets propertyAssets = new PropertyAssets();
            propertyAssets.setUniqueId(UUID.randomUUID().toString());
            propertyAssets.setPropertyId(propertyId);
            propertyAssets.setAsset(asset.getBytes());
            propertyAssets.setIsDP(isDP);
            propertyAssets.setFileType(asset.getContentType());
            return propertyAssetsRepository.save(propertyAssets);
        } catch (IOException e){
            e.printStackTrace();
            throw new CustomException(constantStatements.getErrorCode7(), constantStatements.getErrorMessage7(), "Error encountered while getting bytes of file");
        }
    }

    @Override
    public PropertyAssets getAssetByAssetId(String id) {
        if(propertyAssetsRepository.findById(id).isPresent()){
            return propertyAssetsRepository.findById(id).get();
        }
        else throw new CustomException(constantStatements.getErrorCode7(), constantStatements.getErrorMessage7(), "Could not find asset with this id");

    }
}
