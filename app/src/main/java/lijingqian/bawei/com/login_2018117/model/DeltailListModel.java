package lijingqian.bawei.com.login_2018117.model;


import java.util.HashMap;
import java.util.Map;

import lijingqian.bawei.com.login_2018117.bean.DetailsListBean;
import lijingqian.bawei.com.login_2018117.bean.LoginBean;
import lijingqian.bawei.com.login_2018117.retrofit.BaseObserver;
import lijingqian.bawei.com.login_2018117.retrofit.RetrofitManager;

/**
 * date:2018/1/16 11:35
 * introduction:
 */

public class DeltailListModel {

    //http://120.27.23.105/product/getProducts?pscid=39
    public void getDetailList(final DetailListModelCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("pscid", "39");

        RetrofitManager.get("product/getProducts", map, new BaseObserver<DetailsListBean>() {
            @Override
            public void success(DetailsListBean bean) {
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
