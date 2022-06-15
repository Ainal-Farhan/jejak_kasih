package jejakkasih.utm.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
  
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {
    @Id
    private Integer id;

    @Indexed(unique = true, background = true)
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
