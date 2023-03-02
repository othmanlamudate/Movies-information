package users.profile.kotlinapi.Model;

import java.util.ArrayList;

public class Shows {
    private ArrayList<Show> listShow;

    public Shows() {
        this.listShow = new ArrayList<>();
    }
    public Boolean addShow(Show show){
        this.listShow.add(show);
        return true;
    }

}
