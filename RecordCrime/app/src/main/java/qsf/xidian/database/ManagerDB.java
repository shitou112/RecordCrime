package qsf.xidian.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import qsf.xidian.model.Crime;

/**
 * Created by Qian Shaofeng on 2016/9/15.
 */
public class ManagerDB {
    private static ManagerDB mManagerDB;
    private CrimeDataHelper mCrimeDataHelper;
    private SQLiteDatabase db;
    private ManagerDB(){

    }
    public static ManagerDB getManagerDB(){
        if(mManagerDB==null){
            mManagerDB = new ManagerDB();
        }
        return mManagerDB;
    }
    public SQLiteDatabase getDatabase(Context context,  int version){
        mCrimeDataHelper = new CrimeDataHelper(context,"CrimeRecord.db",null,version);
        db = mCrimeDataHelper.getWritableDatabase();
        return db;
    }


    public void insert(String[] args){
        db.execSQL("insert into Crimes(uuid,title,date,solve) values(?,?,?,?)",args);
    }
    public void update(String[] args){
        db.execSQL("update Crimes set title=?，date = ?,solve=? where uuid=?",args);
    }
    public List<Crime> queryCrimes(){
        List<Crime> list =new ArrayList<Crime>();
        Cursor cursor=db.rawQuery("select * from Crimes",null);

        if (cursor.moveToNext()){
            Crime crime = new Crime();
            Log.d("ManagerDb","找到一个对应的Crime");
            String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
            crime.setUUID(UUID.fromString(uuid));
            crime.setMtitle(cursor.getString(cursor.getColumnIndex("title")));
            crime.setDate(cursor.getString(cursor.getColumnIndex("date")));


            int solve = cursor.getInt(cursor.getColumnIndex("solve"));
            crime.setSolved(solve==1);
            list.add(crime);
        }
        return list;
    }
}
