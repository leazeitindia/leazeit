package in.leazeit.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomHandlerResponse {
    private String errorCode;
    private String errorMessage;
    private String errorDetails;
}
