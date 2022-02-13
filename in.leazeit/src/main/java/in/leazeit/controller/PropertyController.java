package in.leazeit.controller;

import in.leazeit.entity.Property;
import in.leazeit.exception.CustomHandlerResponse;
import in.leazeit.exception.CustomException;
import in.leazeit.service.PropertyService;
import in.leazeit.payload.AddPropertyRequest;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @Autowired
    private ConstantStatements constantStatements;

    @GetMapping("/listAll")
    public ResponseEntity<?> getAllProperty(){

        try {
            List<Property> response = service.getAllProperty();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode5(), constantStatements.getErrorMessage5(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listId")
    public ResponseEntity<?> getPropertyById(@RequestParam String id){
        try {
            Property response = service.getPropertyById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode5(), constantStatements.getErrorMessage5(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listCity")
    public ResponseEntity<?> getPropertyByCity(@RequestParam String city){
        try {
            List<Property> response = service.getPropertyByCity(city);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode5(), constantStatements.getErrorMessage5(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_OWNER')")
    @PostMapping("add")
    public ResponseEntity<?> addProperty(@Valid @RequestBody AddPropertyRequest request, @RequestHeader String userEmail){
        try {
            Property response = service.addProperty(request, userEmail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode5(), constantStatements.getErrorMessage5(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
//    TODO Update Property
}
