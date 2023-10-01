package com.ftr.repository;

import com.ftr.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FtrRepository extends JpaRepository<UserProfile, Integer> {

}
