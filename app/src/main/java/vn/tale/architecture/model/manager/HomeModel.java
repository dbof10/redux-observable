package vn.tale.architecture.model.manager;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import vn.tale.architecture.model.Banner;
import vn.tale.architecture.model.HomeSection;
import vn.tale.architecture.model.Product;
import vn.tale.architecture.model.ProductSlideSection;
import vn.tale.architecture.model.SingleBannerSection;
import vn.tale.architecture.model.TripleBannerSection;

public class HomeModel {

    public Observable<List<HomeSection>> getHome(int page) {
        return Observable.just(getStaticData());
    }

    private List<HomeSection> getStaticData() {
        return Arrays.asList(SingleBannerSection.builder().title("ABC")
                        .banner(Banner.builder().id("1")
                                .imageUrl("https://vcdn.tikicdn.com/ts/banner/bd/4e/98/bd4e98d11e2a094d8981191ce594e766.jpg")
                                .link("/home-app-module/product_group_sale")
                                .ratio(3.34615385F)
                                .make()).build(),
                TripleBannerSection.builder().title("Thẻ cào cực hot")
                        .banners(Arrays.asList(
                                Banner.builder().id("1")
                                        .imageUrl("https://vcdn.tikicdn.com/ts/banner/87/b5/35/87b5350cb9e1a7c8f1601ee1ea7bc20d.jpg")
                                        .link("/home-app-module/product_group_sale")
                                        .ratio(1.3333333333333F)
                                        .make(),
                                Banner.builder().id("2")
                                        .imageUrl("https://vcdn.tikicdn.com/ts/banner/02/1a/81/021a8138486635ae4c1bc78192265197.jpg")
                                        .link("https://tiki.vn/dich-vu-tien-ich")
                                        .ratio(1.3333333333333F)
                                        .make(),
                                Banner.builder().id("3")
                                        .imageUrl("https://vcdn.tikicdn.com/ts/banner/ea/15/c1/ea15c112a4899e2dadbcc54905dd8227.jpg")
                                        .link("https://tiki.vn/lp/samsung-galaxy-s8")
                                        .ratio(0.66666666666667F)
                                        .make()
                        )).build(),
                ProductSlideSection.builder().title("Siêu phẩm Galaxy S8/S8 Plus")
                        .products(Arrays.asList(
                                Product.builder()
                                        .id("1")
                                        .imageUrl(
                                                "https://vcdn.tikicdn.com/cache/w250/media/catalog/product/g/i/gift-tang-kem.u2769.d20170407.t150619.932685.jpg")
                                        .name("Samsung Galaxy S8")
                                        .price(18490000)
                                        .originalPrice(20490000)
                                        .build()
                                ,
                                Product.builder()
                                        .id("2")
                                        .imageUrl(
                                                "https://vcdn.tikicdn.com/cache/w250/media/catalog/product/g/i/gift-tang-kem.u2769.d20170407.t150619.932685.jpg")
                                        .name("Samsung Galaxy S8+")
                                        .price(18490000)
                                        .originalPrice(20490000)
                                        .build(),
                                Product.builder()
                                        .id("3")
                                        .imageUrl(
                                                "https://vcdn.tikicdn.com/cache/w250/media/catalog/product/g/i/gift-tang-kem.u2566.d20170321.t153838.40965.jpg")
                                        .name("Bột Giặt SURF Ngát Hương Chanh 6kg - 32012953")
                                        .price(18490000)
                                        .originalPrice(20490000)
                                        .build(),
                                Product.builder()
                                        .id("4")
                                        .imageUrl(
                                                "https://vcdn.tikicdn.com/cache/w250/media/catalog/product/z/c/zc553klgold_1.u504.d20161125.t163659.671549.jpg")
                                        .name("Asus ZenFone 3 Max ZC553KL 32GB RAM 3GB - Vàng")
                                        .price(4150000)
                                        .originalPrice(4990000)
                                        .build())).build()
        );
    }
}
