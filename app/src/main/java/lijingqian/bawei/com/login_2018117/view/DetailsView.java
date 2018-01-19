package lijingqian.bawei.com.login_2018117.view;


import lijingqian.bawei.com.login_2018117.bean.DetailsBean;

/**
 * date:2018/1/16 13:35
 * introduction:
 */

public interface DetailsView {
    void success(DetailsBean bean);
    void failure(int code);
}
