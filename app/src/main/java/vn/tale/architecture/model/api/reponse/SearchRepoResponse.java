package vn.tale.architecture.model.api.reponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchRepoResponse {

  @SerializedName("total_count")
  @Expose
  private int totalCount;

  @SerializedName("incomplete_results")
  @Expose
  private boolean incompleteResults;

  @SerializedName("items")
  @Expose
  private List<RepoResponse> items;

  public int getTotalCount() {
    return totalCount;
  }

  public boolean isIncompleteResults() {
    return incompleteResults;
  }

  public List<RepoResponse> getItems() {
    return items;
  }
}