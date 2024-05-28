package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tridm.StudentManagement.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}