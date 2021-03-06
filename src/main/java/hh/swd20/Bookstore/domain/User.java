package hh.swd20.Bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	//getters
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public String getRole() {
		return role;
	}
	//setters
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public void setRole(String role) {
		this.role = role;
	}
	//konstruktori parametreillä
	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}
	//konstruktori parametritön
	public User() {
		super();
	}
	
}
