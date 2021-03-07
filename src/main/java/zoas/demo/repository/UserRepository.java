package zoas.demo.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public interface UserRepository extends CrudRepository<User, Long> {



    User findOne(Long id);

  User findByEmail(String email);


}
