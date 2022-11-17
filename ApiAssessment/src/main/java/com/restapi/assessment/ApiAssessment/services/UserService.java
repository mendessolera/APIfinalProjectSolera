package com.restapi.assessment.ApiAssessment.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.assessment.ApiAssessment.models.User;
import com.restapi.assessment.ApiAssessment.repositories.IUserRepository;

@Service
public class UserService {
	
	private IUserRepository userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository){
		this.userRepository = userRepository;
	}
	
		//@Transactional(readOnly = true)
		public List<User> findAll() {
			return userRepository.findAll();
		}
		
		public User findById(int userId) {
			
			return userRepository.findById(userId);
		}
		
		public User save(User user) {
			
			return userRepository.save(user);
		}
		
		public void delete(int userId) {
			
			userRepository.deleteById(userId);
		}

}
