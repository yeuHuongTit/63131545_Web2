package tridm.StudentManagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")

public class User {
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
}
