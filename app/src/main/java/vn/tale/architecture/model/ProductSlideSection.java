package vn.tale.architecture.model;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class ProductSlideSection implements HomeSection{

    public abstract String title();

    public abstract List<Product> products();

    public static Builder builder() {return new AutoValue_ProductSlideSection.Builder();}

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder title(String title);

        public abstract Builder products(List<Product> products);

        public abstract ProductSlideSection build();
    }
}
