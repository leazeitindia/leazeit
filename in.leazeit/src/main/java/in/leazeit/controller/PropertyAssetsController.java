package in.leazeit.controller;

import in.leazeit.entity.PropertyAssets;
import in.leazeit.service.PropertyAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/property")
@CrossOrigin(origins = "*")
public class PropertyAssetsController {

    @Autowired
    private PropertyAssetsService propertyAssetsService;

    @GetMapping("/getAllAssetsByPropertyId")
    public ResponseEntity<?> getPropertyAssetsByPropertyId(@RequestParam("propId") String id){
        List<PropertyAssets> propertyAssets =  propertyAssetsService.getPropertyAssetsByPropertyId(id);
        return new ResponseEntity<>(propertyAssets, HttpStatus.OK);
    }

    @GetMapping("getAssetByAssetId")
    public ResponseEntity<?> getAssetByAssetId(@RequestParam("assetId") String id){
        PropertyAssets propertyAsset =  propertyAssetsService.getAssetByAssetId(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(propertyAsset.getFileType()))
                .body(new ByteArrayResource(propertyAsset.getAsset()));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_OWNER')")
    @PostMapping(value = "/addAssets", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addPropertyAssets(@RequestPart("propertyId") String propertyId , @RequestPart("asset") MultipartFile asset) throws IOException {
        try{
            propertyAssetsService.addPropertyAssets(propertyId, asset, false);
            return "successful";
        } catch (Exception e){
            return e.getMessage();
        }
    }

//    TODO Update assets
}
