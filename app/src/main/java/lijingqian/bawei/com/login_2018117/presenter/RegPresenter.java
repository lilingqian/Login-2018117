package lijingqian.bawei.com.login_2018117.presenter;

import android.util.Log;

import lijingqian.bawei.com.login_2018117.bean.RegBean;
import lijingqian.bawei.com.login_2018117.model.RegModel;
import lijingqian.bawei.com.login_2018117.model.RegModelCallback;
import lijingqian.bawei.com.login_2018117.view.RegView;

import static android.content.ContentValues.TAG;

/**
 * date:2018/1/15 20:30
 * introduction:
 */

public class RegPresenter {
    private RegView view;
    private RegModel model;

    public RegPresenter(RegView view) {
        this.view = view;
        model=new RegModel();
    }

    public void registe(){
        String mobile = view.getMobile();
        String pwd = view.getPwd();
        model.regist(mobile, pwd, new RegModelCallback() {
            @Override
            public void success(RegBean bean) {
               if(bean.getMsg().length()==4){
                   view.success(bean);
               }else{
                   view.failure(bean.getMsg());
               }
            }

            @Override
            public void failure(int code) {
                Log.e(TAG, "failure: "+code );
            }
        });
    }

    public void dettach(){
        this.view=null;
    }
}
