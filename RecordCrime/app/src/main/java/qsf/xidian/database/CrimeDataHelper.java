package qsf.xidian.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Qian Shaofeng on 2016/9/14.
 */
public class CrimeDataHelper extends SQLiteOpenHelper {
    private final String CREATE_TABLE = "create table Crimes("
            +"id integer primary key autoincrement,"
            +"uuid text,"
            +"title text,"
            +"date text,"
            +"solve integer)";
    public CrimeDataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
