package qsf.xidian.model;

import android.content.Context;

import java.util.List;


import qsf.xidian.database.ManagerDB;

/**
 * Created by Qian Shaofeng on 2016/9/15.
 */
public class CrimeLabel {

    public List<Crime> getCrimes(Context context){
        ManagerDB managerDB =ManagerDB.getManagerDB();
        managerDB.getDatabase(context,0);
        return managerDB.queryCrimes();
    }
}
