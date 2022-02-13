package in.leazeit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LEAZEIT_NEWSLETTER_SUBSCRIBER_DETAILS")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIQUE_ID")
    private Long id;

    @NotNull(message = "Email cannot be null")
    @Size(min = 5, max = 100, message = "Email Me must be between 5 and 100 characters")
    @Email(message = "Email should be valid")
    @Column(name = "SUBSCRIBER_EMAIL", unique=true)
    private String email;

}
