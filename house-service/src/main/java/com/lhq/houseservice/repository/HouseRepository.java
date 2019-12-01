package com.lhq.houseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lhq.houseservice.model.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long>{
	
	
	@Query(value = "SELECT max(house_id) FROM House" )
	public int max();
	
	
	@Query(value = "SELECT u FROM House u WHERE u.user_id = :user_id")
	public List<House> findPersonalHouse(@Param("user_id") String user_id);
}
