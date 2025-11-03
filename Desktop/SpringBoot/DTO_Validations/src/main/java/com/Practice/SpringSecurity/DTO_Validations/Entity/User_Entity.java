package com.Practice.SpringSecurity.DTO_Validations.Entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="DTO_UserTable")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
    private String username;
    private String password;
    private String email;

 /*   // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }    */
}
