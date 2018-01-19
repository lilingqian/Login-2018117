package lijingqian.bawei.com.login_2018117.presenter;


import lijingqian.bawei.com.login_2018117.bean.DetailsListBean;
import lijingqian.bawei.com.login_2018117.model.DeltailListModel;
import lijingqian.bawei.com.login_2018117.model.DetailListModelCallback;
import lijingqian.bawei.com.login_2018117.view.DetailListView;

/**
 * date:2018/1/16 11:42
 * introduction:
 */

public class DetailListPresenter {
    private DetailListView view;
    private DeltailListModel model;

    public DetailListPresenter(DetailListView view) {
        this.view = view;
        model = new DeltailListModel();
    }

    public void getDetailsList() {
        model.getDetailList(new DetailListModelCallback() {
            @Override
            public void success(DetailsListBean bean) {
                view.success(bean);
            }

            @Override
            public void failure(int code) {
                view.failure(code);
            }
        });
    }
    /**
     * 解除绑定
     */
     public void dettach(){
         this.view=null;
     }
}
