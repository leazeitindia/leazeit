package in.leazeit.serviceImplementation;

import in.leazeit.entity.Subscription;
import in.leazeit.exception.CustomException;
import in.leazeit.repository.SubscriptionRepository;
import in.leazeit.service.SubscriptionService;
import in.leazeit.utils.ConstantStatements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubscriptionServiceImplementation implements SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    @Autowired
    private ConstantStatements constantStatements;

    @Override
    public List<Subscription> getAllEmailSubscribers() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(constantStatements.getErrorCode4(),constantStatements.getErrorMessage4(),e.getMessage());
        }
    }

    @Override
    public Subscription addEmailSubscriber(Subscription subscriptionRequest) {
        if(repository.existsByEmail(subscriptionRequest.getEmail())){
            throw new CustomException(constantStatements.getErrorCode1(),constantStatements.getErrorMessage1(), "Email already exists");
        }
        if(subscriptionRequest.getId() != null){
            throw new CustomException(constantStatements.getErrorCode1(),constantStatements.getErrorMessage1(), "Please do not send the ID in request body");
        }
        try{
            return repository.save(subscriptionRequest);
        } catch(IllegalArgumentException e){
            throw new CustomException(constantStatements.getErrorCode3(),constantStatements.getErrorMessage3(),e.getMessage());
        }catch(Exception e){
            throw new CustomException(constantStatements.getErrorCode4(),constantStatements.getErrorMessage4(),e.getMessage());
        }
    }
}
