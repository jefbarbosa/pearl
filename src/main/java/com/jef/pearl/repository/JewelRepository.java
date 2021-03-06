package com.jef.pearl.repository;

import com.jef.pearl.entity.Customer;
import com.jef.pearl.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository<Jewel, Long> {

}
