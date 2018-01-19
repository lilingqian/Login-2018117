package lijingqian.bawei.com.login_2018117.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import lijingqian.bawei.com.login_2018117.R;


/**
 * date:2018/1/16 14:41
 * introduction:
 */

public class AddAndDel extends LinearLayout{
    int mCount=1;
    private EditText etCount;

    public AddAndDel(Context context) {
        super(context);
    }

    public AddAndDel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view= LayoutInflater.from(context).inflate(R.layout.custom_layout,null);
        Button add=view.findViewById(R.id.btn_add);
        Button del=view.findViewById(R.id.btn_del);
        etCount = view.findViewById(R.id.et_count);
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = etCount.getText().toString().trim();
                int count1 = Integer.valueOf(count) + 1;
                mCount=count1;
                etCount.setText(mCount+"");
                if (listener != null) {
                    listener.click(mCount);
                }

            }
        });
        del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = etCount.getText().toString().trim();
                int count2 = Integer.valueOf(count);
                mCount=count2;
                if(count2>1){
                    mCount=count2-1;
                    etCount.setText(mCount+"");
                    if (listener != null) {
                        listener.click(mCount);
                    }
                }
            }
        });

        addView(view);
    }

    public AddAndDel(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setEditText(String count){
        if ( etCount!= null) {
            etCount.setText(count);
        }
    }

    private UpdateListener listener;
    public void setListener(UpdateListener listener){
        this.listener=listener;
    }


    public interface UpdateListener{
        void click(int count);
    }
}
