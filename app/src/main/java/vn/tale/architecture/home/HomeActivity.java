package vn.tale.architecture.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.OrientationHelper;
import android.widget.Toast;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentInfo;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.RecyclerBinder;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;
import vn.tale.architecture.App;
import vn.tale.architecture.R;
import vn.tale.architecture.common.base.RvvmActivity;
import vn.tale.architecture.common.dagger.DaggerComponentFactory;
import vn.tale.architecture.common.redux.Store;
import vn.tale.architecture.home.action.HomeAction;
import vn.tale.architecture.home.component.HomeListComponent;
import vn.tale.architecture.home.component.ProductComponent;
import vn.tale.architecture.home.component.ProductSlideComponent;
import vn.tale.architecture.home.component.SingleBannerComponent;
import vn.tale.architecture.home.component.TripleBannersComponent;
import vn.tale.architecture.model.HomeSection;
import vn.tale.architecture.model.Product;
import vn.tale.architecture.model.ProductSlideSection;
import vn.tale.architecture.model.SingleBannerSection;
import vn.tale.architecture.model.TripleBannerSection;

public class HomeActivity extends RvvmActivity<HomeComponent, HomeState> {

    @Inject
    Store<HomeState> store;

    @Inject
    HomeViewModel viewModel;

    @BindView(R.id.ltView)
    LithoView ltView;

    @BindView(R.id.sRefresh)
    SwipeRefreshLayout sRefresh;

    private Snackbar errorSnackbar;
    private RecyclerBinder recyclerBinder;
    private ComponentContext componentContext;

    @Override
    protected DaggerComponentFactory<HomeComponent> daggerComponentFactory() {
        return () -> App.get(this).getAppComponent().plus(new HomeModule());
    }

    @Override
    protected void injectDependencies() {
        daggerComponent().inject(this);
    }

    @Override
    protected Store<HomeState> store() {
        return store;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        bindViews(this);
        componentContext = new ComponentContext(this);
        recyclerBinder = new RecyclerBinder(
                componentContext, 4.0f, new LinearLayoutInfo(this, OrientationHelper.VERTICAL, false));
        sRefresh.setOnRefreshListener(() -> store.dispatch(HomeAction.REFRESH));
    }

    @Override
    protected void onStart() {
        super.onStart();
        store.dispatch(HomeAction.LOAD);

        disposeOnStop(viewModel.loading$().subscribe(ignored -> renderLoading()));
        disposeOnStop(viewModel.refreshing$().subscribe(ignored -> renderRefreshing()));
        disposeOnStop(viewModel.loadingMore$().subscribe(ignored -> renderLoadingMore()));
        disposeOnStop(viewModel.loadError$().subscribe(this::renderLoadError));
        disposeOnStop(viewModel.loadMoreError$().subscribe(this::renderLoadMoreError));
        disposeOnStop(viewModel.refreshError$().subscribe(this::renderRefreshError));
        disposeOnStop(viewModel.content$().subscribe(this::renderContent));
    }

    private void renderLoadMoreError(Throwable error) {
        sRefresh.setRefreshing(false);
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void renderRefreshError(Throwable error) {
        sRefresh.setRefreshing(false);
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void renderRefreshing() {
        sRefresh.setRefreshing(true);
        if (errorSnackbar != null) {
            errorSnackbar.dismiss();
        }
    }

    private void renderLoadingMore() {
        Timber.d("renderLoadingMore");
    }

    private void renderContent(List<HomeSection> sections) {
        sRefresh.setRefreshing(false);
        ComponentInfo.Builder componentInfoBuilder;

        for (HomeSection section : sections) {

            componentInfoBuilder = ComponentInfo.create();

            if (section instanceof SingleBannerSection) {
                componentInfoBuilder
                        .component(
                                SingleBannerComponent
                                        .create(componentContext)
                                        .payload((SingleBannerSection) section)
                                        .key(((SingleBannerSection) section).title())
                                        .build()
                        );
            } else if (section instanceof TripleBannerSection) {

                componentInfoBuilder
                        .component(
                                TripleBannersComponent.create(componentContext)
                                        .payload((TripleBannerSection) section)
                                        .key(((TripleBannerSection) section).title())
                                        .build()
                        );
            } else if (section instanceof ProductSlideSection) {

                final RecyclerBinder productSlideBinder = new RecyclerBinder(componentContext, 4.0f,
                        new LinearLayoutInfo(this, OrientationHelper.HORIZONTAL, false));

                for (Product product : ((ProductSlideSection) section).products()) {
                    componentInfoBuilder = ComponentInfo.create();
                    componentInfoBuilder
                            .component(
                                    ProductComponent.create(componentContext)
                                            .product(product)
                                            .key(product.id())
                                            .build()
                            );
                    productSlideBinder.insertItemAt(productSlideBinder.getItemCount(), componentInfoBuilder.build());
                }

                componentInfoBuilder = ComponentInfo.create();
                componentInfoBuilder
                        .component(
                                ProductSlideComponent.create(componentContext)
                                        .title(((ProductSlideSection) section).title())
                                        .recyclerBinder(productSlideBinder)
                                        .key(((ProductSlideSection) section).title())
                                        .build()
                        );
            }
            recyclerBinder.insertItemAt(recyclerBinder.getItemCount(), componentInfoBuilder.build());
        }

        ltView.setComponent(
                HomeListComponent
                        .create(componentContext)
                        .binder(recyclerBinder)
                        .build()
        );
    }

    private void renderLoadError(Throwable error) {
        sRefresh.setRefreshing(false);
        errorSnackbar = Snackbar.make(ltView, error.getMessage(),
                BaseTransientBottomBar.LENGTH_INDEFINITE);
        errorSnackbar.show();
    }

    private void renderLoading() {
        sRefresh.setRefreshing(true);
        if (errorSnackbar != null) {
            errorSnackbar.dismiss();
        }
    }
}
