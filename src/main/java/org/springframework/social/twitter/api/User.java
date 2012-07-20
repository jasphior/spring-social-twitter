package org.springframework.social.twitter.api;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private long id;
	private String name;
	private String screenName;
	private String location;
	private String description;
	private String url;
	private boolean isProtected;
	private int followersCount;

	private int friendsCount;
	private int listedCount;
	private Date createdAt;
	private int favouritesCount;
	private int utcOffset;
	private String timeZone;
	private boolean geoEnabled;
	private boolean verified;
	private long statusesCount;
	private String lang;
	private boolean contributorsEnabled;
	private boolean following;
	private boolean followRequestSent;
	private String profileImageUrl;

	// private boolean isTranslator;

	// profile_background_color":"FFFFFF","profile_background_image_url":"http://a0.twimg.com/profile_background_images/571083158/l7tnxw8xy058c4rm6e4f.jpeg","profile_background_image_url_https":"https://si0.twimg.com/profile_background_images/571083158/l7tnxw8xy058c4rm6e4f.jpeg","profile_background_tile":false,"profile_image_url":"http://a0.twimg.com/profile_images/2186831845/128x128_twitter_bbc_uk_normal.jpg","profile_image_url_https":"https://si0.twimg.com/profile_images/2186831845/128x128_twitter_bbc_uk_normal.jpg","profile_link_color":"1F527B","profile_sidebar_border_color":"CCCCCC","profile_sidebar_fill_color":"FFFFFF","profile_text_color":"5A5A5A","profile_use_background_image":true,"show_all_inline_media":false,"default_profile":false,"default_profile_image":false,"following":true,"follow_request_sent":null,"notifications":null
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public int getListedCount() {
		return listedCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}

	public int getUtcOffset() {
		return utcOffset;
	}

	public void setUtcOffset(int utcOffset) {
		this.utcOffset = utcOffset;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public boolean isGeoEnabled() {
		return geoEnabled;
	}

	public void setGeoEnabled(boolean geoEnabled) {
		this.geoEnabled = geoEnabled;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public long getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(long statusesCount) {
		this.statusesCount = statusesCount;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public boolean isContributorsEnabled() {
		return contributorsEnabled;
	}

	public void setContributorsEnabled(boolean contributorsEnabled) {
		this.contributorsEnabled = contributorsEnabled;
	}

	public boolean isFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}

	public boolean isFollowRequestSent() {
		return followRequestSent;
	}

	public void setFollowRequestSent(boolean followRequestSent) {
		this.followRequestSent = followRequestSent;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

}
