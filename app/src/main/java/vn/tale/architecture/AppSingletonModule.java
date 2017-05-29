package vn.tale.architecture;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;
import vn.tale.architecture.common.AppRouter;
import vn.tale.architecture.model.api.GithubApi;
import vn.tale.architecture.model.manager.HomeModel;
import vn.tale.architecture.model.manager.UserModel;

@Module
class AppSingletonModule {

    @Provides
    @Singleton
    public UserModel provideUserModel() {
        return new UserModel();
    }

    @Provides
    @Singleton
    HomeModel provideHomeModel() {
        return new HomeModel();
    }

    @Provides
    @Singleton
    AppRouter provideAppRouter() {
        return new AppRouter();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(chain -> {
            final Request originalRequest = chain.request();
            final Request request = originalRequest.newBuilder()
                    .header("Accept", "application/vnd.github.v3.full+json")
                    .build();
            return chain.proceed(request);
        });
        if (BuildConfig.DEBUG) {
            final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").d(message));
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder
                .followRedirects(false)
                .build();
    }

    @Singleton
    @Provides
    GithubApi provideGithubApi(OkHttpClient okHttpClient) {
        return createRestServices(okHttpClient, "https://api.github.com", GithubApi.class);
    }

    private <T> T createRestServices(OkHttpClient okHttpClient, String baseUrl,
                                     Class<T> servicesClass) {
        final Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(servicesClass);
    }
}