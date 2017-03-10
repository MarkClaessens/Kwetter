package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Slashy on 4-3-2017.
 */
@Entity
public class Hart {

    @Id
    @GeneratedValue
    private int ID;
    @OneToOne
    private Kweet kweet;
    @OneToOne
    private User user;

    public Hart(){}

    public Hart(Kweet kweet, User user){
        this.kweet = kweet;
        this.user = user;
    }
    public Kweet getKweet() {
        return kweet;
    }

    public User getUser() {
        return user;
    }
}
