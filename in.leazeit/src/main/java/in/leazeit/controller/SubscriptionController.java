package in.leazeit.controller;

import in.leazeit.entity.Subscription;
import in.leazeit.exception.CustomHandlerResponse;
import in.leazeit.exception.CustomException;
import in.leazeit.service.SubscriptionService;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "*")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private ConstantStatements constantStatements;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/get")
    public ResponseEntity<?> getAllEmailSubscribers(){
        try {
            List<Subscription> response = subscriptionService.getAllEmailSubscribers();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e){
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode2(), constantStatements.getErrorMessage2(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmailSubscriber(@Valid @RequestBody Subscription subscriptionRequest){
        try{
            Subscription response = subscriptionService.addEmailSubscriber(subscriptionRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (CustomException e){
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(e.getErrorCode(), e.getErrorMessage(), e.getErrorDetails());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            CustomHandlerResponse response = new CustomHandlerResponse(constantStatements.getErrorCode2(), constantStatements.getErrorMessage2(), e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
