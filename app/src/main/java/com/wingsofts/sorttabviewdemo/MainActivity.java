package com.wingsofts.sorttabviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.wingsofts.sorttabview.SortTabView;
import com.wingsofts.sorttabview.SortTextView;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  private SortTabView mSortTabView;
  private TextView mTextView;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mTextView = (TextView) findViewById(R.id.text);
    mSortTabView = (SortTabView) findViewById(R.id.sortTabView);
    mSortTabView.setOnCheckedListener(new SortTextView.CheckedListener() {
      @Override public void onChecked(SortTextView sortTextView, int tabId) {

      }

      @Override public void onASC(SortTextView sortTextView, int tabId) {
        mTextView.setText(sortTextView.getText()+"升序↑");
        RotateAnimation ra = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(1000);
        ra.setInterpolator(new MyInterpolator());
        mTextView.startAnimation(ra);
      }

      @Override public void onDES(SortTextView sortTextView, int tabId) {

        mTextView.setText(sortTextView.getText()+"降序↓");
        RotateAnimation ra = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(1000);
        ra.setInterpolator(new MyInterpolator());
        mTextView.startAnimation(ra);
      }
    });
  }
}
