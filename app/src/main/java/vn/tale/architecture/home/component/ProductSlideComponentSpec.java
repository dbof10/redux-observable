package vn.tale.architecture.home.component;

import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;
import com.facebook.litho.widget.Text;

import static com.facebook.yoga.YogaEdge.BOTTOM;
import static com.facebook.yoga.YogaEdge.LEFT;
import static com.facebook.yoga.YogaEdge.RIGHT;
import static com.facebook.yoga.YogaEdge.TOP;

@LayoutSpec
public class ProductSlideComponentSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop String title,
                                          @Prop RecyclerBinder recyclerBinder) {

        return Column.create(c)
                .child(
                        Text.create(c)
                                .text(title)
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
                        Recycler.create(c)
                                .hasFixedSize(true)
                                .binder(recyclerBinder)
                )
                .build();
    }
}
