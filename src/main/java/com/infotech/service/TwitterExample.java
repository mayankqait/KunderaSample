package com.infotech.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

import com.infotech.entity.ExternalLink;
import com.infotech.entity.PersonalDetail;
import com.infotech.entity.Preference;
import com.infotech.entity.Tweet;
import com.infotech.entity.User;

//@Configuration
public class TwitterExample
{    
    public static void main(String[] args)
    {
        TwitterService service = new TwitterService("mysqlPU");
        
            //Add two users
             User user1 = new User();    
             user1.setUserId(1l);
             PersonalDetail pd=new PersonalDetail("10","Rohit","password","single");
             user1.setPersonalDetail(pd);
             user1.setPreference(new Preference(1l,"Motif", "2"));
             ExternalLink el=new ExternalLink(1l,"Facebook", "http://facebook.com/coolnerd");
       	     ExternalLink el1=new ExternalLink(2l,"LinkedIn", "http://linkedin.com/in/devilmate");
       	     Set<ExternalLink> s=new HashSet<ExternalLink>();
       	     s.add(el);
       	     s.add(el1);
	         user1.setExternalLinks(s);
	         List<Tweet> l=new ArrayList<Tweet>();
	         Tweet t= new Tweet(1l,"Here is my first tweet", "Web");
	         Tweet t2= new Tweet(2l,"Second Tweet from me", "Mobile");
	         l.add(t);
	         l.add(t2);
	         user1.setTweets(l);
	         
	        
	       
	         System.out.println("*********** "+user1+"  $$$$$$$$$$$ ");
	
	        service.addUser(user1);
	        //service.addUser(user2);
        
           //Print all users
            List<User> users = service.getAllUsers();
        	System.out.println(users);
      
          //Print all tweets from user 1
       // List<Tweet> tweetsUser1 = service.getAllTweets("1");
       // System.out.println("Tweets of user = "+tweetsUser1);
        
        //Search tweets by body
       /* List<Tweet> user1Tweet = service.findTweetByBody("first tweet");
        List<Tweet> user2Tweet = service.findTweetByBody("first one from me");        
        System.out.println(user1Tweet);
        System.out.println(user2Tweet);
        
        //Search tweets by device
        List<Tweet> webTweets = service.findTweetByDevice("Web");
        List<Tweet> mobileTweets = service.findTweetByDevice("Mobile");
        System.out.println(webTweets);
        System.out.println(mobileTweets); */  
        
    }
}
