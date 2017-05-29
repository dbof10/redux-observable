package vn.tale.architecture.home.result;

import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.model.HomeSection;

/**
 Created by Giang Nguyen on 3/27/17.
 */
@com.google.auto.value.AutoValue
public abstract class LoadMoreResult implements Result {

    public static Builder builder(LoadMoreResult source) {
        return new AutoValue_LoadMoreResult.Builder(source);
    }

    public static Builder builder() {
        return new AutoValue_LoadMoreResult.Builder()
                .loading(false)
                .content(Collections.emptyList())
                .page(1)
                .error(null);
    }

    public static LoadMoreResult inProgress() {
        return builder()
                .loading(true)
                .make();
    }

    public static LoadMoreResult success(int page, List<HomeSection> content) {
        return builder()
                .page(page)
                .content(content)
                .make();
    }

    public static LoadMoreResult failure(Throwable throwable) {
        return builder()
                .error(throwable)
                .make();
    }

    public abstract boolean loading();

    @Nullable
    public abstract Throwable error();

    public abstract List<HomeSection> content();

    public abstract int page();

    @com.google.auto.value.AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder loading(boolean loading);

        public abstract Builder error(Throwable error);

        public abstract Builder content(List<HomeSection> content);

        public abstract Builder page(int page);

        public abstract LoadMoreResult make();
    }
}
