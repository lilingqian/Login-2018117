package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.AddCartBean;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/16 13:52
 * introduction:
 */

public class AddCartModel {
    public void AddIntoCart(String pid, String uid, final AddCartModelCallback callback) {
        //http://120.27.23.105/product/addCart?uid=1&pid=1&source=android
        Map<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("uid", uid);

        RetrofitManager.get("product/addCart", map, new BaseObserver<AddCartBean>() {
            @Override
            public void success(AddCartBean bean) {
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
