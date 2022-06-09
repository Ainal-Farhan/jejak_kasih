package jejakkasih.utm.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jejakkasih.utm.main.model.User;
import jejakkasih.utm.main.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository repo;
  
    @PostMapping("/users/add")
    public String saveUser(@RequestBody User user){
        try {
            repo.save(user);
            return "Added Successfully";
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
  
    @GetMapping("/users/findAll")
    public List<User> getUsers() {
        return repo.findAll();
    }
  
    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        repo.deleteById(id);
        
        return "Deleted Successfully";
    }
}
