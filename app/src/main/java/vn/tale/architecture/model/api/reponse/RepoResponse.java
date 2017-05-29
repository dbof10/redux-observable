package vn.tale.architecture.model.api.reponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RepoResponse {

  @SerializedName("stargazers_count")
  @Expose
  private int stargazersCount;

  @SerializedName("pushed_at")
  @Expose
  private String pushedAt;

  @SerializedName("subscription_url")
  @Expose
  private String subscriptionUrl;

  @SerializedName("language")
  @Expose
  private String language;

  @SerializedName("branches_url")
  @Expose
  private String branchesUrl;

  @SerializedName("issue_comment_url")
  @Expose
  private String issueCommentUrl;

  @SerializedName("labels_url")
  @Expose
  private String labelsUrl;

  @SerializedName("score")
  @Expose
  private int score;

  @SerializedName("subscribers_url")
  @Expose
  private String subscribersUrl;

  @SerializedName("releases_url")
  @Expose
  private String releasesUrl;

  @SerializedName("svn_url")
  @Expose
  private String svnUrl;

  @SerializedName("id")
  @Expose
  private int id;

  @SerializedName("forks")
  @Expose
  private int forks;

  @SerializedName("archive_url")
  @Expose
  private String archiveUrl;

  @SerializedName("git_refs_url")
  @Expose
  private String gitRefsUrl;

  @SerializedName("forks_url")
  @Expose
  private String forksUrl;

  @SerializedName("statuses_url")
  @Expose
  private String statusesUrl;

  @SerializedName("ssh_url")
  @Expose
  private String sshUrl;

  @SerializedName("full_name")
  @Expose
  private String fullName;

  @SerializedName("size")
  @Expose
  private int size;

  @SerializedName("languages_url")
  @Expose
  private String languagesUrl;

  @SerializedName("html_url")
  @Expose
  private String htmlUrl;

  @SerializedName("collaborators_url")
  @Expose
  private String collaboratorsUrl;

  @SerializedName("clone_url")
  @Expose
  private String cloneUrl;

  @SerializedName("name")
  @Expose
  private String name;

  @SerializedName("pulls_url")
  @Expose
  private String pullsUrl;

  @SerializedName("default_branch")
  @Expose
  private String defaultBranch;

  @SerializedName("hooks_url")
  @Expose
  private String hooksUrl;

  @SerializedName("trees_url")
  @Expose
  private String treesUrl;

  @SerializedName("tags_url")
  @Expose
  private String tagsUrl;

  @SerializedName("private")
  @Expose
  private boolean jsonMemberPrivate;

  @SerializedName("contributors_url")
  @Expose
  private String contributorsUrl;

  @SerializedName("has_downloads")
  @Expose
  private boolean hasDownloads;

  @SerializedName("notifications_url")
  @Expose
  private String notificationsUrl;

  @SerializedName("open_issues_count")
  @Expose
  private int openIssuesCount;

  @SerializedName("description")
  @Expose
  private String description;

  @SerializedName("created_at")
  @Expose
  private String createdAt;

  @SerializedName("watchers")
  @Expose
  private int watchers;

  @SerializedName("keys_url")
  @Expose
  private String keysUrl;

  @SerializedName("deployments_url")
  @Expose
  private String deploymentsUrl;

  @SerializedName("has_wiki")
  @Expose
  private boolean hasWiki;

  @SerializedName("updated_at")
  @Expose
  private String updatedAt;

  @SerializedName("comments_url")
  @Expose
  private String commentsUrl;

  @SerializedName("stargazers_url")
  @Expose
  private String stargazersUrl;

  @SerializedName("git_url")
  @Expose
  private String gitUrl;

  @SerializedName("has_pages")
  @Expose
  private boolean hasPages;

  @SerializedName("owner")
  @Expose
  private UserResponse userResponse;

  @SerializedName("commits_url")
  @Expose
  private String commitsUrl;

  @SerializedName("compare_url")
  @Expose
  private String compareUrl;

  @SerializedName("git_commits_url")
  @Expose
  private String gitCommitsUrl;

  @SerializedName("blobs_url")
  @Expose
  private String blobsUrl;

  @SerializedName("git_tags_url")
  @Expose
  private String gitTagsUrl;

  @SerializedName("merges_url")
  @Expose
  private String mergesUrl;

  @SerializedName("downloads_url")
  @Expose
  private String downloadsUrl;

  @SerializedName("has_issues")
  @Expose
  private boolean hasIssues;

  @SerializedName("url")
  @Expose
  private String url;

  @SerializedName("contents_url")
  @Expose
  private String contentsUrl;

  @SerializedName("mirror_url")
  @Expose
  private Object mirrorUrl;

  @SerializedName("milestones_url")
  @Expose
  private String milestonesUrl;

  @SerializedName("teams_url")
  @Expose
  private String teamsUrl;

  @SerializedName("fork")
  @Expose
  private boolean fork;

  @SerializedName("issues_url")
  @Expose
  private String issuesUrl;

  @SerializedName("events_url")
  @Expose
  private String eventsUrl;

  @SerializedName("issue_events_url")
  @Expose
  private String issueEventsUrl;

  @SerializedName("assignees_url")
  @Expose
  private String assigneesUrl;

  @SerializedName("open_issues")
  @Expose
  private int openIssues;

  @SerializedName("watchers_count")
  @Expose
  private int watchersCount;

  @SerializedName("homepage")
  @Expose
  private String homepage;

  @SerializedName("forks_count")
  @Expose
  private int forksCount;

  public int getStargazersCount() {
    return stargazersCount;
  }

  public String getPushedAt() {
    return pushedAt;
  }

  public String getSubscriptionUrl() {
    return subscriptionUrl;
  }

  public String getLanguage() {
    return language;
  }

  public String getBranchesUrl() {
    return branchesUrl;
  }

  public String getIssueCommentUrl() {
    return issueCommentUrl;
  }

  public String getLabelsUrl() {
    return labelsUrl;
  }

  public int getScore() {
    return score;
  }

  public String getSubscribersUrl() {
    return subscribersUrl;
  }

  public String getReleasesUrl() {
    return releasesUrl;
  }

  public String getSvnUrl() {
    return svnUrl;
  }

  public int getId() {
    return id;
  }

  public int getForks() {
    return forks;
  }

  public String getArchiveUrl() {
    return archiveUrl;
  }

  public String getGitRefsUrl() {
    return gitRefsUrl;
  }

  public String getForksUrl() {
    return forksUrl;
  }

  public String getStatusesUrl() {
    return statusesUrl;
  }

  public String getSshUrl() {
    return sshUrl;
  }

  public String getFullName() {
    return fullName;
  }

  public int getSize() {
    return size;
  }

  public String getLanguagesUrl() {
    return languagesUrl;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public String getCollaboratorsUrl() {
    return collaboratorsUrl;
  }

  public String getCloneUrl() {
    return cloneUrl;
  }

  public String getName() {
    return name;
  }

  public String getPullsUrl() {
    return pullsUrl;
  }

  public String getDefaultBranch() {
    return defaultBranch;
  }

  public String getHooksUrl() {
    return hooksUrl;
  }

  public String getTreesUrl() {
    return treesUrl;
  }

  public String getTagsUrl() {
    return tagsUrl;
  }

  public boolean isJsonMemberPrivate() {
    return jsonMemberPrivate;
  }

  public String getContributorsUrl() {
    return contributorsUrl;
  }

  public boolean isHasDownloads() {
    return hasDownloads;
  }

  public String getNotificationsUrl() {
    return notificationsUrl;
  }

  public int getOpenIssuesCount() {
    return openIssuesCount;
  }

  public String getDescription() {
    return description;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public int getWatchers() {
    return watchers;
  }

  public String getKeysUrl() {
    return keysUrl;
  }

  public String getDeploymentsUrl() {
    return deploymentsUrl;
  }

  public boolean isHasWiki() {
    return hasWiki;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public String getCommentsUrl() {
    return commentsUrl;
  }

  public String getStargazersUrl() {
    return stargazersUrl;
  }

  public String getGitUrl() {
    return gitUrl;
  }

  public boolean isHasPages() {
    return hasPages;
  }

  public UserResponse getUserResponse() {
    return userResponse;
  }

  public String getCommitsUrl() {
    return commitsUrl;
  }

  public String getCompareUrl() {
    return compareUrl;
  }

  public String getGitCommitsUrl() {
    return gitCommitsUrl;
  }

  public String getBlobsUrl() {
    return blobsUrl;
  }

  public String getGitTagsUrl() {
    return gitTagsUrl;
  }

  public String getMergesUrl() {
    return mergesUrl;
  }

  public String getDownloadsUrl() {
    return downloadsUrl;
  }

  public boolean isHasIssues() {
    return hasIssues;
  }

  public String getUrl() {
    return url;
  }

  public String getContentsUrl() {
    return contentsUrl;
  }

  public Object getMirrorUrl() {
    return mirrorUrl;
  }

  public String getMilestonesUrl() {
    return milestonesUrl;
  }

  public String getTeamsUrl() {
    return teamsUrl;
  }

  public boolean isFork() {
    return fork;
  }

  public String getIssuesUrl() {
    return issuesUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  public String getIssueEventsUrl() {
    return issueEventsUrl;
  }

  public String getAssigneesUrl() {
    return assigneesUrl;
  }

  public int getOpenIssues() {
    return openIssues;
  }

  public int getWatchersCount() {
    return watchersCount;
  }

  public String getHomepage() {
    return homepage;
  }

  public int getForksCount() {
    return forksCount;
  }
}