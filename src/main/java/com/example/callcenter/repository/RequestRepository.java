package com.example.callcenter.repository;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> getRequestByClient(Long idClient);

     boolean existsByClient(Client client);
}
