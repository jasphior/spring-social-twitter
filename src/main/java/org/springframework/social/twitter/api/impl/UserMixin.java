/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Mixin class for adding Jackson annotations to Tweet. Relies on
 * TweetDeserializer to do actual deserialization, as Tweet JSON structures
 * differ slightly between timeline lists and search results.
 * 
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserMixin {
	// @JsonCreator
	// UserMixin(
	@JsonProperty("id")
	long id;
	@JsonProperty("screen_name")
	String screenName;
	@JsonProperty("protected")
	boolean isProtected;
	@JsonProperty("followers_count")
	int followersCount;
	@JsonProperty("friends_count")
	int friendsCount;
	@JsonProperty("listed_count")
	int listedCount;
	@JsonProperty("created_at")
	@JsonDeserialize(using = CustomDateDeserializer.class)
	Date createdAt;
	@JsonProperty("favourites_count")
	int favouritesCount;
	@JsonProperty("utc_offset")
	int utcOffset;
	@JsonProperty("time_zone")
	int timeZone;
	@JsonProperty("geo_enabled")
	int geoEnabled;

	@JsonProperty("statuses_count")
	long statusesCount;
	@JsonProperty("contributors_enabled")
	boolean contributorsEnabled;

	@JsonProperty("follow_request_sent")
	boolean followRequestSent;

	@JsonProperty("profile_image_url")
	String profileImageUrl;

	@JsonProperty("from_user")
	public void setFromUser(String fromUser) {
		screenName = fromUser;
	}

	@JsonProperty("from_user_id")
	public void setFromUserId(long fromUserId) {
		id = fromUserId;
	}

	// )
	{
	}

	private static final String TIMELINE_DATE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";

	public static final class CustomDateDeserializer extends JsonDeserializer<Date> {
		@Override
		public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			return toDate(jp.getText(), new SimpleDateFormat(TIMELINE_DATE_FORMAT, Locale.ENGLISH));
		}

		private Date toDate(String dateString, DateFormat dateFormat) {
			if (dateString == null) {
				return null;
			}

			try {
				return dateFormat.parse(dateString);
			} catch (ParseException e) {
				return null;
			}
		}
	}
}
