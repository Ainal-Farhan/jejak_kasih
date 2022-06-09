package jejakkasih.utm.main.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import jejakkasih.utm.main.model.Expense;
  
@Repository
public interface ExpenseRepository extends MongoRepository<Expense, Integer> {
    @Query("{ 'id' : ?0 }")
    Expense findExpenseById(Integer id);

    List<Expense> findByUserId(Integer userId);

    @Query(value = "{ 'userId' : ?0 }", delete = true)
    void deleteByUserId(Integer userId);
}
