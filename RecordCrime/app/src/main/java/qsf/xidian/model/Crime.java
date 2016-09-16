package qsf.xidian.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Qian Shaofeng on 2016/9/14.
 */
public class Crime implements Serializable{
    private UUID mUUID;
    private String mtitle;
    private String mDate;
    private boolean mSolved;

    public Crime(){
        mUUID = UUID.randomUUID();
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID id){
        mUUID=id;
    }
    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
