package com.infotech.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.impetus.kundera.index.Index;
import com.impetus.kundera.index.IndexCollection;

@Entity
@Table(name = "USER", schema = "employeecombo@mysqlPU")
//@IndexCollection(columns = { @Index(name = "body"),@Index(name = "device")})
public class User 
{
    @Id    
    @Column(name="USER_ID")
    private Long userId;

    // Embedded object, will persist co-located
    @Embedded
    private PersonalDetail personalDetail;

    // Element collection, will persist co-located
    @ElementCollection
    @CollectionTable(name = "tweeted", joinColumns = @JoinColumn(name = "userId"))
    private List<Tweet> tweets;

    // One to many, will be persisted separately
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name="FRIEND_ID")
    private List<User> friends; // List of users whom I follow

    // One to many, will be persisted separately
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinColumn(name="FOLLOWER_ID")
    private List<User> followers; // List of users who are following me

    // One-to-one, will be persisted separately
    @OneToOne(cascade = { CascadeType.ALL })//, fetch = FetchType.LAZY)
    @JoinColumn(name="PREFERENCE_ID")
    private Preference preference;

    // One to many, will be persisted separately
    @OneToMany(cascade = { CascadeType.ALL })//, fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private Set<ExternalLink> externalLinks;

    public User()
    {
    }
    
	
	public User(Long userId, PersonalDetail personalDetail, List<Tweet> tweets, List<User> friends,
			List<User> followers, Preference preference, Set<ExternalLink> externalLinks) {
		super();
		this.userId = userId;
		this.personalDetail = personalDetail;
		this.tweets = tweets;
		this.friends = friends;
		this.followers = followers;
		this.preference = preference;
		this.externalLinks = externalLinks;
	}


	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}
	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	public List<User> getFollowers() {
		return followers;
	}
	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	public Set<ExternalLink> getExternalLinks() {
		return externalLinks;
	}
	public void setExternalLinks(Set<ExternalLink> externalLinks) {
		this.externalLinks = externalLinks;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", personalDetail=" + personalDetail + ", tweets=" + tweets + ", friends="
				+ friends + ", followers=" + followers + ", preference=" + preference + ", externalLinks="
				+ externalLinks + "]";
	}
	
	
	
	
    
}