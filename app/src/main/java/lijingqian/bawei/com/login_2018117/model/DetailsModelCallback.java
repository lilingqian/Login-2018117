package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.DetailsBean;

/**
 * date:2018/1/16 13:28
 * introduction:
 */

public interface DetailsModelCallback {
        void success(DetailsBean bean);
        void failure(int code);
}
