package com.lhq.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lhq.usermanagement.model.Favorite;

@Repository
public interface FavoriteRepository  extends JpaRepository<Favorite, Long>{
	@Query(value = "SELECT u FROM Favorite u WHERE u.user_id = :user_id")
	public List<Favorite> findByUserId(@Param("user_id") String userId);
}
