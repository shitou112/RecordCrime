package qsf.xidian.recordcrime;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class CrimeListActivity extends SimpleActivity {
    private Fragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_list);

        submitFragment(R.id.fragment_contain,new CrimeListFrament());
        Log.d("CrimeListActivity","create CrimeListActivity");

    }
}
