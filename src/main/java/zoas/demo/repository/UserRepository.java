package zoas.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.User;

import java.util.Optional;

@Repository
public interface  UserRepository extends CrudRepository<User,Long> {



   Optional<User> findById(Long userid);

   User findByEmailAndPassword(String useremail, String password);

   User findByEmail(String useremail);




}
