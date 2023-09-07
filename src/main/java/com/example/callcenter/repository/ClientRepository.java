package com.example.callcenter.repository;

import com.example.callcenter.entity.Client;
import com.example.callcenter.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
