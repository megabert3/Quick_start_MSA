package ru.diasoft.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.diasoft.micro.domain.SmsVerification;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface SmsVerificationRepository extends JpaRepository<SmsVerification, Long> {

    Optional<SmsVerification> findByProcessGUID_AndSecretCodeAndStatus(String processGUID, String secretCode, String status);

    @Transactional
    @Modifying
    @Query("UPDATE SmsVerification v SET status = ?1 WHERE process_guid = ?2")
    int updateStatusByProcessGuid(String status, String process_guid);
}