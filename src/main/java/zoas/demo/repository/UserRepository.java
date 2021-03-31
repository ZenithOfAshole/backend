package zoas.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.User;

import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User,Long> {



   User findUserById(Long userid);

   User findByEmailAndPassword(String useremail, String password);

   User findByEmail(String useremail);




}
