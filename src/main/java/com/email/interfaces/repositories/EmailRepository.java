package com.email.interfaces.repositories;

import com.email.interfaces.entities.Email;
import com.emails.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email,String> {

    List<Email> findAllBySender(String sender);

    List<Email> findAllByReceiver(String sender);

}
