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
import java.util.Date;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.UserMixin.CustomDateDeserializer;

/**
 * Mixin class for adding Jackson annotations to Tweet. 
 * Relies on TweetDeserializer to do actual deserialization, as Tweet JSON structures differ slightly between timeline lists and search results.
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown = true)
// @JsonDeserialize(using = TweetDeserializer.class)
abstract class TweetMixin {

	@JsonProperty("created_at")
	@JsonDeserialize(using = CustomDateDeserializer.class)
	Date createdAt;

	@JsonProperty("in_reply_to_status_id")
	long inReplyToStatusId;

	@JsonProperty("in_reply_to_screen_name")
	String inReplyToScreenName;

	@JsonProperty("in_reply_to_user_id")
	String inReplyToUserId;

	@JsonProperty("retweeted_status")
	Tweet retweet;

	@JsonProperty("current_user_retweet")
	@JsonDeserialize(using = MyRetweetDes.class)
	Long retweetId;


	public static class MyRetweetDes extends JsonDeserializer<Long> {
		@Override
		public Long deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			JsonNode tree = jp.readValueAsTree();
			// jp.skipChildren();
			return tree.get("id").asLong();
		}
	}
}
