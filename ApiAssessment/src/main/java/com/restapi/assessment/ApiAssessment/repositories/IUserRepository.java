package com.restapi.assessment.ApiAssessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.assessment.ApiAssessment.models.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findAll();
	
	public User findById(int userId);
	
	public User save(User user);
	
	public void deleteById(Long uId);

}
