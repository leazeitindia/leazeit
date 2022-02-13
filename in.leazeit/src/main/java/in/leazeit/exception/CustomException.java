package in.leazeit.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
    private String errorDetails;
}
