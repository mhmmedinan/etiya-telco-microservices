package com.customerservice.repositories;

import com.customerservice.entities.concretes.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}
