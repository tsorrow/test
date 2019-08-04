package com.tsorrow.junior.senior.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.tsorrow.junior.senior.R;
import com.tsorrow.junior.senior.adapter.CalendarGridAdapter;
import com.tsorrow.junior.senior.calendar.Constant;
import com.tsorrow.junior.senior.util.DateUtil;

public class CalendarFragment extends Fragment {
    private static final String TAG = "CalendarFragment";
    private View mView;
    private Context mContext;
    private int m_month = 0;
    private GridView gv_calendar;

    private CalendarGridAdapter calV = null;
    private static int jumpMonth = 0;
    private static int jumpYear = 0;
    private int year_c = 0;
    private int month_c = 0;
    private int day_c = 0;

    public static CalendarFragment newInstance(int seq) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putInt("month",seq);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        if (getArguments() != null){
            m_month = getArguments().getInt("month",1);
        }
        mView = inflater.inflate(R.layout.fragment_calendar,container,false);
        gv_calendar = (GridView)mView.findViewById(R.id.gv_calendar);
        return mView;
    }

    @Override
    public void onResume(){
        super.onResume();
        initDate();
    }

    private void initDate() {
        String currentDate = DateUtil.getNowDate();
        year_c = Integer.parseInt(currentDate.split("-")[0]);
        month_c = Integer.parseInt(currentDate.split("-")[1]);
        day_c = Integer.parseInt(currentDate.split("-")[2]);
        jumpMonth = m_month - month_c;
        calV = new CalendarGridAdapter(mContext,jumpMonth,jumpYear,year_c,month_c,day_c);
        gv_calendar.setAdapter(calV);
    }
}
