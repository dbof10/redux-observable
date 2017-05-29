package vn.tale.architecture.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Banner {

    public abstract String id();

    public abstract String imageUrl();

    public abstract String link();

    public abstract float ratio();

    public static Builder builder() {
        return new AutoValue_Banner.Builder();
    }

    @com.google.auto.value.AutoValue.Builder
    public static abstract class Builder {
        public abstract Banner.Builder id(String id);

        public abstract Banner.Builder imageUrl(String imageUrl);

        public abstract Banner.Builder link(String link);

        public abstract Banner.Builder ratio(float ratio);

        public abstract Banner make();
    }
}
