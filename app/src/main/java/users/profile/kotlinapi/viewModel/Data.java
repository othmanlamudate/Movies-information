package users.profile.kotlinapi.viewModel;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import users.profile.kotlinapi.Model.Show;

public class Data {
    private MutableLiveData<ArrayList<Show>> livedata=new MutableLiveData<>();

    public Data(MutableLiveData<ArrayList<Show>> livedata) {
        this.livedata = livedata;
    }

    public MutableLiveData<ArrayList<Show>> getLivedata() {
        return livedata;
    }

    public void setLivedata(MutableLiveData<ArrayList<Show>> livedata) {
        this.livedata = livedata;
    }
}
