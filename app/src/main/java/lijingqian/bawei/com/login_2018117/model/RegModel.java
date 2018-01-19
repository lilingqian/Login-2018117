package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.bean.RegBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/15 20:06
 * introduction:
 */

public class RegModel {
    //http://120.27.23.105/user/reg?mobile=15011179909&password=1234567890
    public void regist(String mobile,String password,final RegModelCallback callback){
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        RetrofitManager.get("user/reg", map, new BaseObserver<RegBean>() {
            @Override
            public void success(RegBean bean) {
                  callback.success(bean);
            }

            @Override
            public void failure(int code) {
                  callback.failure(code);
            }

            @Override
            public void onNext(LoginBean bean) {

            }


        });
    }
}
