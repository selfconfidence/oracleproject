package com.jpa.test;

import com.out.pojo.Order;
import com.out.util.CreateEntityManagerUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author misterWei
 * @create 2018年09月20号:17点39分
 * @mailbox weiyan980522@outlook.com
 */
public class JpaTest {
    //测试保存操作
    @Test
    public void jpaSaveTest() {
        /**
         * 创建实体管理类工厂，借助Persistence的静态方法获取
         * 		其中传递的参数为持久化单元名称，需要jpa配置文件中指定
         */

        //创建实体管理类
        EntityManager entityManager = CreateEntityManagerUtils.createEntityManager();
        //需要获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        for (int i=0;i<8;i++){
            //创建插入数据库数据
            Order order = new Order();
            order.setcId(10);
            order.setPrice(6.6);
            order.setMeths("666");
            //执行保存操作
            entityManager.persist(order);
        }

        //提交事务并关闭资源
        transaction.commit();
        entityManager.close();


    }

    //JQPL语句编写
    //查询所有


    @Test
    public void findAll() {


        //创建实体管理类
        EntityManager entityManager = CreateEntityManagerUtils.createEntityManager();
        //需要获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        //
        String jqpl="from Order";
        Query query = entityManager.createQuery(jqpl);
        List resultList = query.getResultList();
        System.out.println(resultList);
        //提交事务并关闭资源
        transaction.commit();
        entityManager.close();


    }

    @Test
    public void findlimit() {


        //创建实体管理类
        EntityManager entityManager = CreateEntityManagerUtils.createEntityManager();
        //需要获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        //
        String jqpl="from Order";
        Query query = entityManager.createQuery(jqpl);
        query.setFirstResult(1);
        query.setMaxResults(5);
        List resultList = query.getResultList();
        System.out.println(resultList);

        transaction.commit();
        entityManager.close();


    }
    @Test
    public void findCount() {


        //创建实体管理类
        EntityManager entityManager = CreateEntityManagerUtils.createEntityManager();
        //需要获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        //
        String jqpl="select count(*) from Order";
        Query query = entityManager.createQuery(jqpl);
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);

        transaction.commit();
        entityManager.close();


    }
    @Test
    public void findCondition() {


        //创建实体管理类
        EntityManager entityManager = CreateEntityManagerUtils.createEntityManager();
        //需要获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        //
        String jqpl="from Order where id in(?,?,?)";
        Query query = entityManager.createQuery(jqpl);
        query.setParameter(1,1);
        query.setParameter(2,2);
        query.setParameter(3,3);
        List resultList = query.getResultList();
        System.out.println(resultList);
        transaction.commit();
        entityManager.close();


    }
    @Test
    public void findOrderBy() {


        //创建实体管理类
        EntityManager entityManager = CreateEntityManagerUtils.createEntityManager();
        //需要获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        //
        String jqpl="from Order  group by meths order by id desc ";
        Query query = entityManager.createQuery(jqpl);
        List resultList = query.getResultList();
        System.out.println(resultList);
        transaction.commit();
        entityManager.close();


    }
}
