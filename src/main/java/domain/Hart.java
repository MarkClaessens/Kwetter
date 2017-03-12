package domain;

import javax.persistence.*;

/**
 * Created by Slashy on 4-3-2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "hart.all", query = "SELECT h FROM Hart h"),
        @NamedQuery(name = "hart.findbykweet", query = "SELECT h FROM Hart h WHERE h.kweet = :kweet"),
        @NamedQuery(name = "hart.findbyuser", query = "SELECT h FROM Hart h WHERE h.user = :user")
})
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
