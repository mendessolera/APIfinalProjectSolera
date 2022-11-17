package com.restapi.assessment.ApiAssessment.services;


import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.assessment.ApiAssessment.models.DCUser;
import com.restapi.assessment.ApiAssessment.repositories.IUserRepository;

@Service
public class UserService {
	
	private IUserRepository userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository){
		this.userRepository = userRepository;
	}
	
		//@Transactional(readOnly = true)
		public List<DCUser> findAll() {
			return userRepository.findAll();
		}
		
		public Optional<DCUser> findById(int userId) {
			
			return userRepository.findById(userId);
		}
		
		public DCUser save(DCUser user) {
			
			return userRepository.save(user);
		}
		
		public void delete(int userId) {
			
			userRepository.deleteById(userId);
		}

}
