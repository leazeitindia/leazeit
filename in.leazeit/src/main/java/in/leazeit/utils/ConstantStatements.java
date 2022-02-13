package in.leazeit.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ConstantStatements {
    private final String errorCode1 = "601";
    private final String errorMessage1 = "Validation Error";
    private final String errorCode2 = "602";
    private final String errorMessage2 = "Unhandled Exception occurred in SubscriptionController";
    private final String errorCode3 = "603";
    private final String errorMessage3 = "Illegal Arguments Exception";
    private final String errorCode4 = "604";
    private final String errorMessage4 = "Unhandled Exception occurred in SubscriptionService";
    private final String errorCode5 = "605";
    private final String errorMessage5 = "Unhandled Exception occurred in PropertyController";
    private final String errorCode6 = "606";
    private final String errorMessage6 = "Unhandled Exception occurred in PropertyService";
    private final String errorCode7 = "607";
    private final String errorMessage7 = "No Such Records found";
    private final String errorCode8 = "608";
    private final String errorMessage8 = "Unhandled Exception occurred in OwnerDetailsController";
    private final String errorCode9 = "609";
    private final String errorMessage9 = "Unhandled Exception occurred in OwnerDetailsService";
    private final String errorCode10 = "610";
    private final String errorMessage10 = "No owner with this email id exists";
}
