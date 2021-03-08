package zoas.demo.repository;

import org.springframework.data.repository.CrudRepository;
import zoas.demo.domian.Token;

public interface  TokenRepository extends CrudRepository<Token, String> {

    Token findByTokenValue(String tokenValue);
}
