package tridm.StudentManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tridm.StudentManagement.models.*;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
