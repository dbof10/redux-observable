package vn.tale.architecture.home.component;

import android.graphics.Color;
import android.text.Layout;
import android.text.TextUtils;
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
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

import vn.tale.architecture.model.Product;
import vn.tale.architecture.util.FormatUtil;

import static com.facebook.yoga.YogaEdge.ALL;
import static com.facebook.yoga.YogaEdge.BOTTOM;
import static com.facebook.yoga.YogaEdge.TOP;

@LayoutSpec
public class ProductComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop Product product) {
        final DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(product.imageUrl())
                .build();
        return Column.create(c)
                .backgroundColor(Color.WHITE)
                .child(
                        FrescoImage.create(c)
                                .controller(controller)
                                .actualImageScaleType(
                                        ScalingUtils
                                                .ScaleType
                                                .CENTER_CROP
                                )
                                .withLayout()
                                .heightDip(96)
                                .widthDip(96)
                                .alignSelf(YogaAlign.CENTER)
                ).child(
                        Text.create(c)
                                .text(product.name())
                                .maxLines(2)
                                .minLines(2)
                                .ellipsize(TextUtils.TruncateAt.MIDDLE)
                                .glyphWarming(true)
                                .textAlignment(Layout.Alignment.ALIGN_CENTER)
                                .textSizeSp(14)
                                .withLayout()
                                .widthDip(128)
                                .paddingDip(TOP, 8)
                )
                .child(
                        Text.create(c)
                                .text(FormatUtil.getFormattedCurrency(product.price()))
                                .glyphWarming(true)
                                .textSizeSp(14)
                                .withLayout()
                                .paddingDip(TOP, 8)
                ).child(
                        Text.create(c)
                                .text(FormatUtil.getFormattedCurrency(product.originalPrice()))
                                .glyphWarming(true)
                                .textSizeSp(12)
                                .withLayout()
                                .paddingDip(BOTTOM, 8)
                ).clickHandler(ProductComponent.onClick(c))
                .paddingDip(ALL, 8)
                .build();
    }

    @OnEvent(ClickEvent.class)
    static void onClick(
            ComponentContext c,
            @FromEvent View view,
            @Prop final Product product) {

    }
}
