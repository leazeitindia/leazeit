package in.leazeit.service;

import in.leazeit.entity.PropertyAssets;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PropertyAssetsService {

    List<PropertyAssets> getPropertyAssetsByPropertyId(String id);

    PropertyAssets addPropertyAssets(String propertyId, MultipartFile asset, Boolean isDP ) throws IOException;


    PropertyAssets getAssetByAssetId(String id);
}
