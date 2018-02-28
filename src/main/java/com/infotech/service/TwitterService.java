package com.infotech.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;	
//Other imports omitted	

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.infotech.entity.Tweet;
import com.infotech.entity.User;

@Service
public class TwitterService
{
private EntityManager em;
private EntityManagerFactory emf;
    
public TwitterService(String persistenceUnitName)
{
    if (emf == null)
        {
            try
            {
                emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }    
}

private EntityManager getEntityManager(String persistenceUnitName)
{
    //Configuration conf = new Configuration();
    return  emf.createEntityManager();//conf.getEntityManager(persistenceUnitName);
}

public void close()
    {       
        if(emf != null) {
           emf.close();
        }
    }	


    public void addUser(User user)
    {
        em = emf.createEntityManager(); 
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        System.out.println("$$$$$$$$$$$$$$$$$ entity created ."+em.getDelegate());
        em.persist(user);
        //System.out.println("$$$$$$$$$$$$$$$$$ entity persisted .="+ em.find(User.class, 1));
        transaction.commit();
        em.close();
    }
    
    public List<User> getAllUsers() {
        em = emf.createEntityManager();
        Query q = em.createQuery("select u.name,u.password,u.USER_ID from User u");
        //q.getSingleResult();
        List<User> users = q.getResultList();
        em.close();

        return users;
}

    public List<Tweet> getAllTweets(String userId)
    {
        em = emf.createEntityManager();
        Query q = em.createQuery("select u from User u where u.userId =:userId");
        q.setParameter("userId", userId);
        List<User> users = q.getResultList();
        em.close();
        if (users == null || users.isEmpty())
        {
            return null;
        }
        else
        {
             return users.get(0).getTweets();
        }
    }

   /* public List<Tweet> findTweetByBody(String tweetBody)
    {
        em = emf.createEntityManager();
        Query q = em.createQuery("select u.body from User u where u.body like :body");
        q.setParameter("body", tweetBody);
        List<Tweet> tweets = q.getResultList();
        em.close();
        return tweets;
    }

    public List<Tweet> findTweetByDevice(String deviceName)
    {
        em = emf.createEntityManager();
        Query q = em.createQuery("select u.device from User u where u.device like :device");
        q.setParameter("device", deviceName);
        List<Tweet> tweets = q.getResultList();
        em.close();
        return tweets;
    }    */         

}
