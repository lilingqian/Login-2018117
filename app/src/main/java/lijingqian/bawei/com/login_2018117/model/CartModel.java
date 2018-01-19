package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.CartBean;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/16 14:10
 * introduction:
 */

public class CartModel {

    //http://120.27.23.105/product/getCarts?uid=100&source=android
    public void getCartData(String uid,final CartModelCallback callback){
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        RetrofitManager.get("product/getCarts", map, new BaseObserver<CartBean>() {
            @Override
            public void success(CartBean bean) {
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
