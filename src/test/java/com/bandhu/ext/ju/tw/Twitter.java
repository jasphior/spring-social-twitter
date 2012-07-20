package com.bandhu.ext.ju.tw;

import java.util.List;
import java.util.Scanner;

import org.springframework.social.connect.Connection;
import org.springframework.social.oauth1.AuthorizedRequestToken;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

public class Twitter {
	private static Scanner scanner = new Scanner(System.in);

	private static String consumerKey = "y2RKzfpcGnCl2JCkxe4yA";
	private static String consumerSecret = "qWUzBU9LnnuukZwZfEasO9Kf9GMq3IG4pbIeeYnEo";

	public static void main(String[] args) {
		quick();
	}

	private static void quick() {
		TwitterConnectionFactory factory = new TwitterConnectionFactory(consumerKey, consumerSecret);
		// final OAuthToken accessTokenJasp = new
		// OAuthToken("276483722-zM7JzeMqCnjdYich7tZK3pN0WiZqQkuenpkuivap",
		// "jNiZC9x0bKqoWFJg9aNsf3ZlEh0G9p37g63y6Ym3Ig");
		final OAuthToken accessToken = new OAuthToken("613856812-dE9D03C2YYL1VR6mL5gNflqqUTRDlcmcJrVb4gTc",
		        "Gt3xMucJbYx5emRykw8NmgaVSKd05wUuhTRi1qC4w");
		Connection<org.springframework.social.twitter.api.Twitter> conn = factory.createConnection(accessToken);
		org.springframework.social.twitter.api.Twitter twitter = conn.getApi();
		// postTweet(twitter);
		retweet(twitter);
		getTweets(twitter);
	}

	private static void retweet(org.springframework.social.twitter.api.Twitter twitter) {
		Tweet retweet = twitter.timelineOperations().retweet(226305033761861634L);
		displayTweet(retweet);
	}

	private static void postTweet(org.springframework.social.twitter.api.Twitter twitter) {
		Tweet tweet = twitter.timelineOperations().updateStatus("Thank you 'babumoshai'! RIP");
		displayTweet(tweet);
	}

	private static void getTweets(org.springframework.social.twitter.api.Twitter twitter) {
		// List<Tweet> home =
		// twitter.timelineOperations().getUserTimeline("PRIYA28mani");
		List<Tweet> home = twitter.timelineOperations().getHomeTimeline(0, 25);
		System.out.println(twitter.userOperations().getProfileId() + " - " + twitter.userOperations().getScreenName());
		for (Tweet tweet : home) {
			displayTweet(tweet);
			System.out.println();
		}
	}

	private static void displayTweet(Tweet tweet) {
		System.out.println(tweet.getId());
		System.out.println(tweet.getUser().getName() + " @ " + tweet.getCreatedAt());
		System.out.println(tweet.getText());
		System.out.println("retweeted: " + tweet.isRetweeted());
		System.out.println("Reply:");
		System.out.println(tweet.getInReplyToScreenName() + " - " + tweet.getInReplyToStatusId());
		if (tweet.getRetweetId() != null) {
			System.out.println("MyRetweet Info" + tweet.getRetweetId());
		}
		if (tweet.getRetweet() != null) {
			Tweet retweet = tweet.getRetweet();
			System.out.println("RT Source:");
			displayTweet(retweet);
			System.out.println("Retweeted by " + tweet.getUser().getName() + " @ " + tweet.getCreatedAt());
		}
		System.out.println(tweet.isFavorited());

	}

	public static void initFull() {
		TwitterConnectionFactory factory = new TwitterConnectionFactory(consumerKey, consumerSecret);
		final OAuth1Operations oAuthOperations = factory.getOAuthOperations();
		OAuthToken reqToken = factory.getOAuthOperations().fetchRequestToken("google.com", null);
		System.out.println(reqToken.getSecret());
		System.out.println(reqToken.getValue());
		final String url = oAuthOperations.buildAuthenticateUrl(reqToken.getValue(), null);
		System.out.println(url);
		System.out.println("Verifier:");
		String verifier = scanner.nextLine();
		AuthorizedRequestToken requestToken = new AuthorizedRequestToken(reqToken, verifier);
		final OAuthToken accessToken = oAuthOperations.exchangeForAccessToken(requestToken, null);
		System.out.println(accessToken.getValue() + " - " + accessToken.getSecret());
		Connection<org.springframework.social.twitter.api.Twitter> conn = factory.createConnection(accessToken);
		org.springframework.social.twitter.api.Twitter twitter = conn.getApi();
	}
}
