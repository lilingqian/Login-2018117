package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/15 17:47
 * introduction:
 */

public class LoginModel {
    public void getData(String mobile,String password,final LoginModelCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        RetrofitManager.get("user/login", map, new BaseObserver<LoginBean>() {
            @Override
            public void success(LoginBean bean) {
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
