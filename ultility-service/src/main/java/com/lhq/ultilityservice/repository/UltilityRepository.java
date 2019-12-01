package com.lhq.ultilityservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lhq.ultilityservice.model.Ultility;

@Repository
public interface UltilityRepository  extends JpaRepository<Ultility, Long>{
	@Query(value = "SELECT u FROM Ultility u WHERE u.house_id = :house_id")
	public List<Ultility> findByHouseId(@Param("house_id") int house_id);
}
