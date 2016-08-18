package com.wingsofts.sorttabview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.wingsofts.sorttabview.R;
/**
 * 具有升降序功能的 Tabs
 * Created by wing on 16/8/18.
 */
public class SortTabView extends FrameLayout {
  private SortTextView[] views;

  //普通状态
  final public static int STATE_NORMAL = 0;

  //升序
  final public static int STATE_ASC = 1;
  //降序
  final public static int STATE_DES = 2;

  //当前选择的id
  private int mCurrentSelected;

  private LinearLayout mLinearLayout;

  private int mTabCount;
  //状态回调
  private SortTextView.CheckedListener mListener;

  public SortTabView(Context context) {
    this(context, null);
  }

  public SortTabView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public SortTabView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);


     LayoutInflater.from(context).inflate(R.layout.view_sort_tab, this);
     mLinearLayout = (LinearLayout) getChildAt(0);
     mCurrentSelected = 0;
     mTabCount = mLinearLayout.getChildCount();
     views = new SortTextView[mTabCount];
  }

  public void setOnCheckedListener(final SortTextView.CheckedListener listener) {

    for (int i = 0; i < mTabCount; i++) {

      final int finalI = i;
      views[i] = (SortTextView) mLinearLayout.getChildAt(i);

      views[i].setOnClickListener(new OnClickListener() {
        @Override public void onClick(View view) {
          if (finalI == mCurrentSelected) views[finalI].toggle(listener);
          else {

            for (int i = 0; i < mTabCount; i++) {
              views[i].setState(STATE_NORMAL, null);
            }
            views[finalI].setState(STATE_ASC, listener);
            mCurrentSelected = finalI;
          }
        }
      });
    }

    views[mCurrentSelected].setState(STATE_ASC,null);
  }
}
