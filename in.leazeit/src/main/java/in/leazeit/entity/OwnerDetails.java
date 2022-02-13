package in.leazeit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEAZEIT_OWNER_DETAILS")
public class OwnerDetails {

    @Id
    @Column(length = 100)
    private String ownerEmail;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String ownerPhone;

    @Column(nullable = false)
    private Long ownerBankAccountNo;

    @Column(nullable = false)
    private String ownerBankAssociatedPhone;

    @Column(nullable = false)
    private String ownerNameInBankAccount;

    @Column(nullable = false)
    private String bankName;

    @Column(nullable = false)
    private String ifscCode;
}
