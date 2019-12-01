package com.lhq.postmanagermentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lhq.postmanagermentservice.model.PostCata;

@Repository
public interface PostCataRepository  extends JpaRepository<PostCata, Long>{
	@Query(value = "SELECT u FROM PostCata u WHERE u.user_id = :user_id")
	public List<PostCata> findByUserId(@Param("user_id") String userId);
	
	@Query(value = "SELECT u FROM PostCata u WHERE u.catalog = :catalog1 or u.catalog = :catalog2")
	public List<PostCata> findByCatalog(@Param("catalog1") String catalog1, @Param("catalog2") String catalog2);
	
	@Query(value = "SELECT u FROM PostCata u WHERE u.catalog = :catalog")
	public List<PostCata> findRentByCatalog(@Param("catalog") String catalog);
	
	@Query(value = "SELECT u FROM PostCata u WHERE u.post_id = :post_id")
	public PostCata findByPostId(@Param("post_id") Long post_id);

	public List<PostCata> findByCity(String city);

	public List<PostCata> findPostCataByCityAndDistrict(String city, String district);
	
	
}
