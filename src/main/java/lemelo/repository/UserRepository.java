package lemelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lemelo.entity.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}
