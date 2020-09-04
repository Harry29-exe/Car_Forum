package com.harry.Audio_Forum.backend.repositories;

import com.harry.Audio_Forum.backend.pojo.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PostRepository {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate1");

    public static void addPost(String content, String author) {
        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Post post = new Post(content, author);
            entityManager.persist(post);
            entityTransaction.commit();
        } catch (Exception ex) {
            if(entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public static void deletePost(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            if(em.find(Post.class, id) != null) {

            }
        } catch (Exception ex) {

        }
    }

    public static void main(String[] args) {
        PostRepository.addPost("testing hibernate", "main function");
        System.out.println("finished");
    }
}
