package ru.diasoft.micro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sms_verification")
public class SmsVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sms_verification_seq_verification_id")
    @SequenceGenerator(name = "sms_verification_seq_verification_id")
    @Column(name = "verification_id")
    private Long id;

    @Column(name = "process_guid")
    private String processGUID;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "secret_code")
    private String secretCode;

    @Column(name = "status")
    private String status;
}
