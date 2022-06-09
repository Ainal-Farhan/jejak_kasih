package jejakkasih.utm.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jejakkasih.utm.main.model.Expense;
import jejakkasih.utm.main.repository.ExpenseRepository;
import jejakkasih.utm.main.repository.UserRepository;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseRepository repo;

    @Autowired
    private UserRepository userRepo;
  
    @PostMapping("/expenses/add")
    public String saveExpense(@RequestBody Expense expense){
        try {
            if(userRepo.existsById(expense.getUserId())) {
                repo.save(expense);
                return "Added Successfully";
            }
            else {
                return "No such user found based on userId";
            }
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping("/expenses/update")
    public String updateExpense(@RequestBody Expense expense) {
        try {
            Expense existingExpense = repo.findExpenseById(expense.getId());
        
            if(expense.getTitle() != null) {
                existingExpense.setTitle(expense.getTitle());
            }

            if(expense.getDescription() != null) {
                existingExpense.setDescription(expense.getDescription());
            }

            if(expense.getDatetime() != null) {
                existingExpense.setDatetime(expense.getDatetime());
            }

            if(expense.getPrice() != null) {
                existingExpense.setPrice(expense.getPrice());
            }

            if(expense.getUserId() != null) {
                existingExpense.setUserId(expense.getUserId());
            }

            repo.save(existingExpense);

            return "Successfully update expense";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
  
    @GetMapping("/expenses/findAll")
    public List<Expense> getExpenses() {
        return repo.findAll();
    }

    @GetMapping("/expenses/find/{id}")
    public Expense getExpenses(@PathVariable Integer id) {
        return repo.findExpenseById(id);
    }

    @GetMapping("/expenses/findByUserId/{id}")
    public List<Expense> getAllExpensesBasedOnUserId(@PathVariable Integer id) {
        System.out.println(id);
        return repo.findByUserId(id);
    }
  
    @DeleteMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Integer id){
        repo.deleteById(id);
        
        return "Deleted Successfully";
    }

    @DeleteMapping("/expenses/deleteByUserId/{id}")
    public String deleteExpensesByUserId(@PathVariable Integer id){
        repo.deleteByUserId(id);
        
        return "Deleted Successfully";
    }
}
