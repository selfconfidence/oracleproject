package com.out.design;

/**
 * @author misterWei
 * @create 2018年09月20号:20点08分
 * @mailbox weiyan980522@outlook.com
 */
public class EntityGurger {
    //饱汉设计模式思想:  想象为土豪类型 的,如果没有目标对象就直接 new出来一个

    private static EntityGurger entityGurger;

    public static EntityGurger getEntityGurger(){
        if (entityGurger==null){
            entityGurger = new EntityGurger();
        }
        return entityGurger;
    }
}
