package com.reobotdev.HelpDesk2.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.entity.dto.UserDTO;
import com.reobotdev.HelpDesk2.api.repository.UserRepository;
import com.reobotdev.HelpDesk2.api.service.exception.ObjectNotFountException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
		
	public User findByEmail(String email) {
		User obj = userRepository.findByEmail(email);
		if(obj == null) {
			new ObjectNotFountException(
					"Objeto não encontrado! Id: " + email + ", Tipo: " + User.class.getName());
		}
		return obj;	
	}
	
	


	public User find(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepository.findAll(pageRequest);
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return userRepository.save(obj);
	}
	public void delete(Integer id) {
		find(id);
		userRepository.deleteById(id);
	}
	
		
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getEmail(),pe.encode(objDTO.getPassword()), objDTO.getProfile());
	}

}
