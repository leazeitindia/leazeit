package in.leazeit.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddNewOwnerRequest {

    private String ownerEmail;

    private String ownerName;

    private String ownerPhone;

    private Long ownerBankAccountNo;

    private String ownerBankAssociatedPhone;

    private String ownerNameInBankAccount;

    private String bankName;

    private String ifscCode;
}
