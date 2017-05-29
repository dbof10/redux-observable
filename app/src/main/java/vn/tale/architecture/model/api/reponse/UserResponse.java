package vn.tale.architecture.model.api.reponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

  @SerializedName("gists_url")
  @Expose
  private String gistsUrl;

  @SerializedName("repos_url")
  @Expose
  private String reposUrl;

  @SerializedName("following_url")
  @Expose
  private String followingUrl;

  @SerializedName("starred_url")
  @Expose
  private String starredUrl;

  @SerializedName("login")
  @Expose
  private String login;

  @SerializedName("followers_url")
  @Expose
  private String followersUrl;

  @SerializedName("type")
  @Expose
  private String type;

  @SerializedName("url")
  @Expose
  private String url;

  @SerializedName("subscriptions_url")
  @Expose
  private String subscriptionsUrl;

  @SerializedName("received_events_url")
  @Expose
  private String receivedEventsUrl;

  @SerializedName("avatar_url")
  @Expose
  private String avatarUrl;

  @SerializedName("events_url")
  @Expose
  private String eventsUrl;

  @SerializedName("html_url")
  @Expose
  private String htmlUrl;

  @SerializedName("site_admin")
  @Expose
  private boolean siteAdmin;

  @SerializedName("id")
  @Expose
  private int id;

  @SerializedName("gravatar_id")
  @Expose
  private String gravatarId;

  @SerializedName("organizations_url")
  @Expose
  private String organizationsUrl;

  public String getGistsUrl() {
    return gistsUrl;
  }

  public String getReposUrl() {
    return reposUrl;
  }

  public String getFollowingUrl() {
    return followingUrl;
  }

  public String getStarredUrl() {
    return starredUrl;
  }

  public String getLogin() {
    return login;
  }

  public String getFollowersUrl() {
    return followersUrl;
  }

  public String getType() {
    return type;
  }

  public String getUrl() {
    return url;
  }

  public String getSubscriptionsUrl() {
    return subscriptionsUrl;
  }

  public String getReceivedEventsUrl() {
    return receivedEventsUrl;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public boolean isSiteAdmin() {
    return siteAdmin;
  }

  public int getId() {
    return id;
  }

  public String getGravatarId() {
    return gravatarId;
  }

  public String getOrganizationsUrl() {
    return organizationsUrl;
  }
}