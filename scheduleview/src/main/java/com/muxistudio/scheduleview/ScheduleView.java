package com.muxistudio.scheduleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by ybao on 17/1/23.
 */

public class ScheduleView extends FrameLayout{

    private int firstDayOfWeek;
    private int weekTextColor;
    private int normalDateColor;
    private int todyDateColor;
    private int otherMonthDateColor;
    private int selectDateBackground;

    private LinearLayout

    private Context mContext;

    public ScheduleView(Context context) {
        this(context,null);
    }

    public ScheduleView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public ScheduleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.ScheduleView,defStyleAttr,0);
        try {
            firstDayOfWeek = a.getInt(R.styleable.ScheduleView_first_day_of_week,0);
            weekTextColor = a.getColor(R.styleable.ScheduleView_week_text_color, Color.BLACK);
            normalDateColor = a.getColor(R.styleable.ScheduleView_normal_date_color, Color.BLACK);
            todyDateColor = a.getColor(R.styleable.ScheduleView_today_date_color, getAccentColor());
            otherMonthDateColor = a.getColor(R.styleable.ScheduleView_other_month_date_color, Color.parseColor("#757575"));
            selectDateBackground = a.getColor(R.styleable.ScheduleView_select_date_background, getAccentColor());
        }finally {
            a.recycle();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_schedule,this,true);

    }

    /**
     *
     * @param day 0 means Monday
     */
    public void setFirstDayOfWeek(int day){

    }



    private int getAccentColor() {
        TypedValue typedValue = new TypedValue();

        TypedArray a = mContext.obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
        int color = a.getColor(0, 0);

        a.recycle();

        return color;
    }


}
