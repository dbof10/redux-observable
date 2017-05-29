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
public abstract class LoadResult implements Result {

    public static Builder builder(LoadResult source) {
        return new AutoValue_LoadResult.Builder(source);
    }

    public static Builder builder() {
        return new AutoValue_LoadResult.Builder()
                .loading(false)
                .content(Collections.emptyList())
                .error(null);
    }

    public static LoadResult inProgress() {
        return builder()
                .loading(true)
                .make();
    }

    public static LoadResult success(List<HomeSection> content) {
        return builder()
                .content(content)
                .make();
    }

    public static LoadResult failure(Throwable throwable) {
        return builder()
                .error(throwable)
                .make();
    }

    public abstract boolean loading();

    @Nullable
    public abstract Throwable error();

    public abstract List<HomeSection> content();

    @com.google.auto.value.AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder loading(boolean loading);

        public abstract Builder error(Throwable error);

        public abstract Builder content(List<HomeSection> content);

        public abstract LoadResult make();
    }
}
