package vn.tale.architecture.home.component;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;

@LayoutSpec
public class HomeListComponentSpec {

    private static final String MAIN_SCREEN = "main_screen";

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop RecyclerBinder binder) {
        return Recycler.create(c)
                .binder(binder)
                .withLayout().flexShrink(0)
                .testKey(MAIN_SCREEN)
                .build();
    }

}