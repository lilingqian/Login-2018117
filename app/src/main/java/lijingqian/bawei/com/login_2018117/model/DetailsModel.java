package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.DetailsBean;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/16 13:28
 * introduction:
 */

public class DetailsModel {
    public void getDetailsData(String pid,final DetailsModelCallback callback){

        //http://120.27.23.105/product/getProductDetail?pid=4
        Map<String,String> map=new HashMap<>();
        map.put("pid",pid);
        RetrofitManager.get("product/getProductDetail", map, new BaseObserver<DetailsBean>() {
            @Override
            public void success(DetailsBean bean) {
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
