package com.website.site.Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.site.Login.entity.AuthTable;
@Repository
public interface AuthRepository extends JpaRepository<AuthTable,Integer>{

    
}
