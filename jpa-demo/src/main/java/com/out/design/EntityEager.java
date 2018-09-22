package com.out.design;

/**
 * @author misterWei
 * @create 2018年09月20号:20点05分
 * @mailbox weiyan980522@outlook.com
 */
public class EntityEager {
    //饿汉模式的创建 总体思路担心被饿死每次加载类就会创建
    private static final  EntityEager ENTITY_EAGER = new EntityEager();

    //无需构建默认有无参构造
    public static EntityEager getEntityEager(){
        return ENTITY_EAGER;
    }
}
