package domain;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Slashy on 4-3-2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "kweet.all", query = "SELECT k FROM Kweet k"),
        @NamedQuery(name = "kweet.getKweet", query = "SELECT k FROM Kweet  k WHERE k.ID = :id")
})
public class Kweet {

    @Id
    @GeneratedValue
    private int ID;
    private String message;
    @OneToMany
    private List<User> mentions;
    private Date date;

    public Kweet(){}
    public Kweet(String message, List<User> mentions, Date date){
        this.message = message;
        this.mentions = mentions;
        this.date = date;
        if(mentions == null){
            this.mentions = new ArrayList<>();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getMentions() {
        return mentions;
    }

    public void setMentions(List<User> mentions) {
        this.mentions = mentions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
