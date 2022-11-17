package com.restapi.assessment.ApiAssessment.repositories;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.assessment.ApiAssessment.models.DCUser;

@Repository
public interface IUserRepository extends JpaRepository<DCUser, Integer> {
	
	public List<DCUser> findAll();
	
	public Optional<DCUser> findById(int userId);
	
	public DCUser save(DCUser user);
	
	//public void deleteById(Long uId);

}
