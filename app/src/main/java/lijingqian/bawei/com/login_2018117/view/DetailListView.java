package lijingqian.bawei.com.login_2018117.view;


import lijingqian.bawei.com.login_2018117.bean.DetailsListBean;

/**
 * date:2018/1/16 11:42
 * introduction:
 */

public interface DetailListView {
    void success(DetailsListBean bean);
    void failure(int code);
}
