package com.harry.Car_Forum.backend.persistance;

import javax.persistence.*;
import java.util.List;

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

    public static void deletePost(long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            Post post;
            if( (post = em.find(Post.class, id)) != null) {
                em.remove(post);
            }
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void editPost(long id, String updatedContent) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        try {
            et = em.getTransaction();
            et.begin();
            Post post;
            if( (post = em.find(Post.class, id)) != null ) {
                post.setContent(updatedContent);
            }
            et.commit();
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static Post findPost(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;

        Post post = null;
        try {
            et = em.getTransaction();
            et.begin();
            post = em.find(Post.class, id);
        } catch (Exception ex) {
            if(et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return post;
    }

    public static List<Post> findPosts(String partOfContent) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT p FROM Post p WHERE p.content LIKE :partOfContent";
        TypedQuery<Post> tq = em.createQuery(query, Post.class);

        List<Post> posts = null;
        try {
            tq.setParameter("partOfContent", ("%" +partOfContent + "%"));
            posts = tq.getResultList();
        } catch (Exception ex) {
            if(ex instanceof NoResultException) {
                return null;
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return posts;
    }

    public static List<Post> findPost(String Author) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT p FROM Post p WHERE p.author = :author";
        TypedQuery<Post> tq = em.createQuery(query, Post.class);

        List<Post> posts = null;
        try {
            tq.setParameter("author", Author);
            posts = tq.getResultList();
        } catch (Exception ex) {
            if(ex instanceof NoResultException) {
                return null;
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return posts;
    }



    public static void main(String[] args) {
        List<Post> post  = findPosts("main");
        if(post != null) {
            System.out.println(post.size());
        }

        System.out.println("finished") ;
    }
}
