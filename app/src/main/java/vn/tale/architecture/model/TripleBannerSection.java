package vn.tale.architecture.model;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class TripleBannerSection implements HomeSection {

    public abstract String title();

    public abstract List<Banner> banners();

    public static TripleBannerSection.Builder builder() {
        return new AutoValue_TripleBannerSection.Builder();
    }

    @com.google.auto.value.AutoValue.Builder
    public static abstract class Builder {

        public abstract TripleBannerSection.Builder title(String title);

        public abstract TripleBannerSection.Builder banners(List<Banner> banners);

        public abstract TripleBannerSection build();
    }
}
