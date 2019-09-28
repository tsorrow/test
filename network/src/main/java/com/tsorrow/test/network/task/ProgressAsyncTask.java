package com.tsorrow.test.network.task;

import android.os.AsyncTask;

public class ProgressAsyncTask extends AsyncTask<String,Integer,String> {
    private String mBook;
    public ProgressAsyncTask(String title){
        super();
        mBook = title;
    }

    @Override
    protected String doInBackground(String... strings) {
        int ratio = 0;
        for (;ratio <= 100;ratio+=5){
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(ratio);
        }
        return strings[0];
    }

    @Override
    protected void onPreExecute() {
        mListener.onBegin(mBook);
    }

    @Override
    protected void onPostExecute(String s) {
        mListener.onFinish(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mListener.onUpdate(mBook,values[0],0);
    }

    @Override
    protected void onCancelled(String s) {
        mListener.onCancel(s);
    }

    public static interface OnProgressListener{
        public abstract void onBegin(String request);
        public abstract void onUpdate(String request,int progress,int sub_progress);
        public abstract void onFinish(String result);
        public abstract void onCancel(String result);
    }

    private OnProgressListener mListener;
    public void setOnProgressListener(OnProgressListener listener){
        mListener = listener;
    }
}
