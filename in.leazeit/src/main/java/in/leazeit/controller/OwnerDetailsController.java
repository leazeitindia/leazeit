package in.leazeit.controller;

import in.leazeit.entity.OwnerDetails;
import in.leazeit.exception.CustomException;
import in.leazeit.exception.CustomHandlerResponse;
import in.leazeit.payload.AddNewOwnerRequest;
import in.leazeit.payload.GetOwnerDetailsRequest;
import in.leazeit.service.OwnerDetailsService;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/owner-details")
@CrossOrigin(origins = "*")

public class OwnerDetailsController {

    @Autowired
    private OwnerDetailsService ownerDetailsService;

    @Autowired
    private ConstantStatements constantStatements;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_OWNER')")
    @PostMapping("/getDetails")
    public ResponseEntity<?> getOwnerDetails(@Valid @RequestBody GetOwnerDetailsRequest request){
        try {
            OwnerDetails response = ownerDetailsService.getOwnerDetails(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode8(), constantStatements.getErrorMessage8(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_OWNER')")
    @PostMapping("/addDetails")
    public ResponseEntity<?> addNewOwnerDetails(@Valid @RequestBody AddNewOwnerRequest request){
        try {
            OwnerDetails response = ownerDetailsService.addNewOwnerDetails(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode8(), constantStatements.getErrorMessage8(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

//    TODO Update Owner Details

}
