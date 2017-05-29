package vn.tale.architecture.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Product {

    public abstract String id();

    public abstract String name();

    public abstract int originalPrice();

    public abstract int price();

    public abstract String imageUrl();

    public static Builder builder() {return new AutoValue_Product.Builder();}

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(String id);

        public abstract Builder name(String name);

        public abstract Builder originalPrice(int originalPrice);

        public abstract Builder price(int price);

        public abstract Builder imageUrl(String imageUrl);

        public abstract Product build();
    }
}
