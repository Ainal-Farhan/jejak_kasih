package jejakkasih.utm.main.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Expense")
public class Expense {
    @Id 
    private Integer id;
    private String title;
    private String description;
    private String datetime;
    private String price;
    private Integer userId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public String getPrice() {
        return this.price;
    }

    public Integer getUserId() {
        return this.userId;
    }
}
