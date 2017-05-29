package vn.tale.architecture.home.component;

import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnBind;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;
import com.facebook.litho.widget.Text;

import vn.tale.architecture.model.SingleBannerSection;
import vn.tale.architecture.util.DisplayUtil;

import static com.facebook.yoga.YogaEdge.BOTTOM;
import static com.facebook.yoga.YogaEdge.LEFT;
import static com.facebook.yoga.YogaEdge.RIGHT;
import static com.facebook.yoga.YogaEdge.TOP;

@LayoutSpec
public class SingleBannerComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop SingleBannerSection payload) {
        final DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(payload.banner().imageUrl())
                .build();
        return Column.create(c)
                .child(
                        Text.create(c)
                                .text(payload.title())
                                .glyphWarming(true)
                                .textSizeSp(16)
                                .withLayout()
                                .paddingDip(TOP,8)
                                .paddingDip(BOTTOM,4)
                                .heightDip(44)
                )
                .paddingDip(LEFT, 8)
                .paddingDip(RIGHT, 8)
                .child(
                        FrescoImage.create(c)
                                .controller(controller)
                                .actualImageScaleType(
                                        ScalingUtils
                                                .ScaleType
                                                .CENTER_CROP
                                )
                                .withLayout()
                                .heightPx((int) (DisplayUtil.getScreenWidth(c) / payload.banner().ratio()))

                )
                .clickHandler(SingleBannerComponent.onClick(c))
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(
            ComponentContext c,
            @FromEvent View view,
            @Prop final SingleBannerSection payload) {

    }
}
