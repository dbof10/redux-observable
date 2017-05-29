package vn.tale.architecture.model.api;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.tale.architecture.model.api.reponse.SearchRepoResponse;

/**
 * Created by Giang Nguyen on 3/27/17.
 */
public interface GithubApi {

  @GET("/search/repositories") Single<SearchRepoResponse> searchRepos(
      @Query("q") String query,
      @Query("sort") String sort,
      @Query("order") String order,
      @Query("page") int page,
      @Query("per_page") int perPage);
}
