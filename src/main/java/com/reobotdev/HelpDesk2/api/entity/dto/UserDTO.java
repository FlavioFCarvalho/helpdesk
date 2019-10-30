package com.reobotdev.HelpDesk2.api.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.reobotdev.HelpDesk2.api.entity.User;
import com.reobotdev.HelpDesk2.api.enums.ProfileEnum;

public class UserDTO implements Serializable{

   private static final long serialVersionUID = 1L;
   
	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message= "Email inválido!")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=6, max=80, message="O tamanho deve ser entre 6 e 80 caracteres")
	private String password;
	
	private ProfileEnum profile;
	
	public UserDTO(){
		
	}

	public UserDTO(User obj) {
		id = obj.getId();
		email = obj.getEmail();
		password = obj.getPassword();
		profile = obj.getProfile();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
}
