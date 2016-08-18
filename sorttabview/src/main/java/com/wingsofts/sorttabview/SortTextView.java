package com.wingsofts.sorttabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * SortTabView内的tabs
 * Created by wing on 16/8/18.
 */
public class SortTextView extends FrameLayout {

  private int mState;
  private TextView mTextView;
  private String mText;
  private ImageView mImageView;
  private int mColor;
  public SortTextView(Context context) {
    this(context,null);
  }

  public SortTextView(Context context, AttributeSet attrs) {
    this(context, attrs,0);
  }

  public SortTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    LayoutInflater.from(context).inflate(R.layout.view_sort_text,this);
    mTextView = (TextView) findViewById(R.id.tv_tab_name_sort_tab);
    mImageView = (ImageView) findViewById(R.id.iv_arrow_sort_tab);
    TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.SortTextView,defStyleAttr,0);
    mText = a.getString(R.styleable.SortTextView_android_text);
    mTextView.getPaint().setTextSize(a.getDimensionPixelSize(R.styleable.SortTextView_android_textSize,16));
    mColor = a.getColor(R.styleable.SortTextView_android_textColor,Color.BLACK);
    mTextView.setTextColor(mColor);
    if(mText!=null){
      mTextView.setText(mText);
    }
    a.recycle();
  }

  public void setState(int state,CheckedListener listener) {
    mState = state;
    if (state == SortTabView.STATE_NORMAL) {
      mTextView.setTextColor(Color.BLACK);
    } else {
      mTextView.setTextColor(Color.parseColor("#ED5296"));
      if (null != listener) {

        mImageView.setImageResource(R.drawable.sort_tab_asc);
        listener.onChecked(this,getId());
        listener.onASC(this,getId());
      }
    }
  }

  public int getState() {
    return mState;
  }

  public void toggle(CheckedListener listener) {
    if (mState == SortTabView.STATE_ASC) {
      mState = SortTabView.STATE_DES;
      if (null != listener) {
        mImageView.setImageResource(R.drawable.sort_tab_des);
        listener.onDES(this,getId());
      }
    } else {
      mState = SortTabView.STATE_ASC;
      if (null != listener) {

        mImageView.setImageResource(R.drawable.sort_tab_asc);
        listener.onASC(this,getId());
      }
    }
  }


  public interface CheckedListener {
    void onChecked(SortTextView sortTextView, int tabId);

    void onASC(SortTextView sortTextView, int tabId);

    void onDES(SortTextView sortTextView, int tabId);
  }


  public String getText(){
    return mTextView.getText().toString();
  }
}
