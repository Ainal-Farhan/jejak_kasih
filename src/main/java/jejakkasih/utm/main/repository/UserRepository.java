package jejakkasih.utm.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import jejakkasih.utm.main.model.User;
  
@Repository
public interface UserRepository
    extends MongoRepository<User, Integer> {
}
