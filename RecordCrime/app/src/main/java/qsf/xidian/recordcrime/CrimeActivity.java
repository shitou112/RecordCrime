package qsf.xidian.recordcrime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import java.util.Date;

public class CrimeActivity extends SimpleActivity {
    private String mDate ;
    public String getDate(){
        return mDate;
    }
    public void setDate(String date){
        mDate = date;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        Log.d("CrimeActivity","create");
        submitFragment(R.id.fragment_crime_container,new CrimeFragment());



    }
}
