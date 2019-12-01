package com.lhq.roomservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lhq.roomservice.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

	@Query(value = "SELECT u FROM Room u WHERE u.house_id = :house_id")
	public List<Room> findByHouseId(@Param("house_id") int house_id);
}
