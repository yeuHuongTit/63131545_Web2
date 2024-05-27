package tridm.StudentManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}