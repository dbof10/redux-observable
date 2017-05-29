package vn.tale.architecture.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SingleBannerSection implements HomeSection {

    public abstract String title();

    public abstract Banner banner();

    public static Builder builder() {
        return new AutoValue_SingleBannerSection.Builder();
    }

    @com.google.auto.value.AutoValue.Builder
    public static abstract class Builder {

        public abstract SingleBannerSection.Builder title(String title);

        public abstract SingleBannerSection.Builder banner(Banner banner);

        public abstract SingleBannerSection build();
    }
}
