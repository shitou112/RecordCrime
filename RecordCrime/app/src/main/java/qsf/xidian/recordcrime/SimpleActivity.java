package qsf.xidian.recordcrime;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Qian Shaofeng on 2016/9/14.
 */
public class SimpleActivity extends AppCompatActivity{


    public void submitFragment(int resourceId,Fragment fragment){
        Fragment mfragment;
        FragmentManager fm = getSupportFragmentManager();
        mfragment = fm.findFragmentById(resourceId);
        if(mfragment == null){
            mfragment = fragment;
            fm.beginTransaction().add(resourceId,mfragment).commit();
        }
    }
}
