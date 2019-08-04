package com.tsorrow.junior.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public UUID getmId(){
        return mId;
    }

    public String getmTitle(){
        return mTitle;
    }

    public void setmTitle(String title){
        mTitle = title;
    }

    public Date getmDate(){
        return mDate;
    }

    public void setmDate(Date date){
        mDate = date;
    }

    public boolean ismSolved(){
        return mSolved;
    }

    public void setmSolved(boolean solved){
        mSolved = solved;
    }
}
