package com.out.design;

/**
 * @author misterWei
 * @create 2018年09月20号:20点11分
 * @mailbox weiyan980522@outlook.com
 */
public class EntitySynchronized {
    private static EntitySynchronized entitySynchronized;

    public static EntitySynchronized getEntitySynchronized(){
        if (entitySynchronized==null){
            //参数意思为,锁定指定参数为锁对象
            synchronized (EntitySynchronized.class){
                entitySynchronized = new EntitySynchronized();
            }
        }
        return entitySynchronized;
    }
}
