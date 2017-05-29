package vn.tale.architecture.home.component;

import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;
import com.facebook.litho.widget.Text;

import vn.tale.architecture.model.TripleBannerSection;
import vn.tale.architecture.util.DisplayUtil;

import static com.facebook.yoga.YogaEdge.BOTTOM;
import static com.facebook.yoga.YogaEdge.LEFT;
import static com.facebook.yoga.YogaEdge.RIGHT;
import static com.facebook.yoga.YogaEdge.TOP;

@LayoutSpec
public class TripleBannersComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop TripleBannerSection payload) {
        final DraweeController controllerBanner1 = Fresco.newDraweeControllerBuilder()
                .setUri(payload.banners().get(0).imageUrl())
                .build();
        final DraweeController controllerBanner2 = Fresco.newDraweeControllerBuilder()
                .setUri(payload.banners().get(1).imageUrl())
                .build();

        final DraweeController controllerBanner3 = Fresco.newDraweeControllerBuilder()
                .setUri(payload.banners().get(2).imageUrl())
                .build();
        return Column.create(c)
                .child(
                        Text.create(c)
                                .text(payload.title())
                                .glyphWarming(true)
                                .textSizeSp(16)
                                .withLayout()
                                .paddingDip(TOP, 8)
                                .paddingDip(BOTTOM, 4)
                                .heightDip(44)
                )
                .paddingDip(LEFT, 8)
                .paddingDip(RIGHT, 8)
                .child(
                        Row.create(c)
                                .heightPx((int) (DisplayUtil.getScreenWidth(c) / payload.banners().get(0).ratio()))
                                .child(
                                        FrescoImage.create(c)
                                                .controller(controllerBanner1)
                                                .actualImageScaleType(ScalingUtils
                                                        .ScaleType.FIT_XY)
                                                .withLayout()
                                                .flex(1)
                                                .widthPercent(50)

                                )
                                .clickHandler(TripleBannersComponent.onClickFirstBanner(c))
                                .child(
                                        Column.create(c)
                                                .child(
                                                        FrescoImage.create(c)
                                                                .controller(controllerBanner2)
                                                                .actualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                                                                .withLayout()
                                                                .heightPercent(50)
                                                                .flex(1)
                                                )
                                                .clickHandler(TripleBannersComponent.onClickSecondBanner(c))
                                                .child(
                                                        FrescoImage.create(c)
                                                                .controller(controllerBanner3)
                                                                .actualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                                                                .withLayout()
                                                                .flex(1)
                                                                .heightPercent(50)
                                                )
                                                .widthPercent(100)
                                                .clickHandler(TripleBannersComponent.onClickThirdBanner(c)))
                )
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClickFirstBanner(
            ComponentContext c,
            @FromEvent View view,
            @Prop final TripleBannerSection payload) {

    }

    @OnEvent(ClickEvent.class)
    static void onClickSecondBanner(
            ComponentContext c,
            @FromEvent View view,
            @Prop final TripleBannerSection payload) {

    }

    @OnEvent(ClickEvent.class)
    static void onClickThirdBanner(
            ComponentContext c,
            @FromEvent View view,
            @Prop final TripleBannerSection payload) {

    }
}
