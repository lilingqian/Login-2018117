package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.CreatOrderBean;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/17 14:07
 * introduction:
 */

public class CreateOrderModel {
    public void createOrder(String price,final CreateOrderCallback callback){
        //http://120.27.23.105/product/createOrder?uid=100&price=1
        Map<String,String> map=new HashMap<>();
        map.put("uid","100");
        map.put("price",price);
        RetrofitManager.get("product/createOrder", map, new BaseObserver<CreatOrderBean>() {
            @Override
            public void success(CreatOrderBean bean) {
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
