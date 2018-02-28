package com.infotech.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

@Embeddable
public class Tweet
{   
	
    @Column(name = "tweet_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long tweetId;

    @Column(name = "tweet_body")
    private String body;

    @Column(name = "tweeted_from")
    private String device;
    
    public Tweet()
    {
    } 
    
    public Tweet(Long tweetId, String body, String device) {
		super();
		this.tweetId = tweetId;
		this.body = body;
		this.device = device;
	}

	
	public Long getTweetId() {
		return tweetId;
	}
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", body=" + body + ", device=" + device + "]";
	}           
    
    
}
