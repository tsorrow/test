package com.tsorrow.junior.qeoquiz;

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question,boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getmQuestion(){
        return mQuestion;
    }

    public void setmQuestion(int question){
        mQuestion = question;
    }

    public boolean ismTrueQuestion(){
        return mTrueQuestion;
    }

    public void setmTrueQuestion(boolean trueQuestion){
        mTrueQuestion = trueQuestion;
    }
}
