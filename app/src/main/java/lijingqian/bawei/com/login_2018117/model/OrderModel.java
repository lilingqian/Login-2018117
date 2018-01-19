package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.bean.OrderBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/16 19:22
 * introduction:
 */

public class OrderModel {
    //http://120.27.23.105/product/getOrders?uid=71
    public void getOrderData(String status,final OrderModelCallback callback){
        Map<String,String> map=new HashMap<>();
        map.put("uid","100");
        map.put("status",status);
        RetrofitManager.get("product/getOrders", map, new BaseObserver<OrderBean>() {
            @Override
            public void success(OrderBean bean) {
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
