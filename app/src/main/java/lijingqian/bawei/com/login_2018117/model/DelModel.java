package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.DeleteBean;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/17 13:43
 * introduction:
 */

public class DelModel {
    public void deletCart(String pid,final DelModelCallback callback){
        //http://120.27.23.105/product/deleteCart?uid=72&pid=1
        Map<String,String> map=new HashMap<>();
        map.put("uid","100");
        map.put("pid",pid);
        RetrofitManager.get("product/deleteCart", map, new BaseObserver<DeleteBean>() {
            @Override
            public void success(DeleteBean bean) {
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
