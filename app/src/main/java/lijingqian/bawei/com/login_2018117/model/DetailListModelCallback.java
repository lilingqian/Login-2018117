package lijingqian.bawei.com.login_2018117.model;


import lijingqian.bawei.com.login_2018117.bean.DetailsListBean;

/**
 * date:2018/1/16 11:36
 * introduction:
 */

public interface DetailListModelCallback {
    void success(DetailsListBean bean);
    void failure(int code);
}
