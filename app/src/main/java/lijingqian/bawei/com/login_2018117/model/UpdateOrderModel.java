package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.bean.UpdateOrderBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/17 16:00
 * introduction:
 */

public class UpdateOrderModel {
    //https://www.zhaoapi.cn/product/updateOrder?uid=100&status=2&orderId=5037
    public void updateOrder(String status, String orderId,final UpdateOrderCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("uid","100");
        map.put("status",status);
        map.put("orderId",orderId);
        RetrofitManager.get("product/updateOrder", map, new BaseObserver<UpdateOrderBean>() {
            @Override
            public void success(UpdateOrderBean bean) {
                callback.success(bean);
            }

            @Override
            public void failure(int code) {

            }

            @Override
            public void onNext(LoginBean bean) {

            }

        });
    }


}
