package com.lhq.landservice.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lhq.landservice.model.Land;

@Repository
public interface LandRepository  extends JpaRepository<Land, Long> {
	@Query(value = "SELECT max(land_id) FROM Land" )
	public int max();
	
	//@Query(value = "SELECT u FROM Land u WHERE u.post_id = :post_id")
	//public Land findByPostId(@Param("post_id") int postId);
	
	//Land findByPostsId(int post_id);
}
