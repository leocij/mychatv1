package lemelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lemelo.entity.Authorities;

public interface AuthorityRepository extends JpaRepository<Authorities, String> {

}
