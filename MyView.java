package top.com.testdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;

/**
 * Created by lihaitao on 2018/4/18.
 */
public class MyView extends FrameLayout {
    private Context mContext;
    private ViewStub mError;
    private ViewStub mEmpty;
    private FrameLayout mMContentLayout;
    private int mLayout;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray t = mContext.obtainStyledAttributes(attrs, R.styleable.MyView);
        mLayout = t.getResourceId(R.styleable.MyView_includelayout, 0);
        t.recycle();
        inflate(context,R.layout.error_empty_switch_pager,this);
        initeView();
    }
    private void initeView() {
        mMContentLayout = (FrameLayout) findViewById(R.id.layout_content);
        View childView = LayoutInflater.from(mContext).inflate(mLayout, mMContentLayout);
        mError = ((ViewStub) findViewById(R.id.layout_error));
        mEmpty = ((ViewStub) findViewById(R.id.layout_null));
    }


    public void setError() {
        mError.inflate();
        mMContentLayout.setVisibility(View.GONE);
    }

    public void setEmpty() {
        mEmpty.inflate();
        mMContentLayout.setVisibility(View.GONE);
    }

    public void setView() {
        mMContentLayout.setVisibility(View.VISIBLE);
    }
}
