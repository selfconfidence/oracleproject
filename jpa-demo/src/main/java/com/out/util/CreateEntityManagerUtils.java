package com.out.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author misterWei
 * @create 2018年09月20号:19点23分
 * @mailbox weiyan980522@outlook.com
 */
public class CreateEntityManagerUtils {
    private static EntityManager entityManager;
    static {
        EntityManagerFactory jpa = Persistence.createEntityManagerFactory("Jpa");
         entityManager = jpa.createEntityManager();
    }
    public static EntityManager createEntityManager(){
        return entityManager;
    }
}
