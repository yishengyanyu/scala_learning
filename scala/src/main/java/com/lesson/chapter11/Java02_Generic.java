package com.lesson.chapter11;


import scala.collection.script.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuJing
 * @create 2020-06-01 9:12
 */
public class Java02_Generic {
    public static void main(String[] args) {
        //TODO 泛型

        //TODO 泛型不可变
//        AAAM<UserM> a1 = new AAAM<ParentM>();
//        AAAM<UserM> a2 = new AAAM<SubUserM>();
        AAAM<UserM> a3 = new AAAM<UserM>();
//        AAAM<UserM> a4 = new AAAM<EmpM>();

        //TODO 泛型的上限和下限
        BBBM b = new BBBM();

        List<ParentM> parentList = new ArrayList();
        List<UserM> userList = new ArrayList();
        List<SubUserM> subUsertList = new ArrayList();
        List<EmpM> empList = new ArrayList();

//        b.extendsTest(parentList);  //error
        b.extendsTest(userList);    //ok
        b.extendsTest(subUsertList);    //ok
//        b.extendsTest(empList); //error

        b.superTest(parentList);//ok
        b.superTest(userList);//ok
//        b.superTest(subUsertList);//error
//        b.superTest(empList);//error

        //TODO 上限,下限的使用场景

        //TODO 上限一般用于对获取的数据进行限定
        CCCM<UserM> ccc1 = new CCCM<UserM>();
        MessageM<? extends UserM> consume = ccc1.consume();
        // subUser, subsubUser.
        UserM t = consume.t;

        //TODO 下限一般用于插入数据的类型的限定
        DDDM<UserM> d = new DDDM<UserM>();
        d.produce(new MessageM<UserM>());
        d.produce(new MessageM<ParentM>());

    }
}
class MessageM<T> {
    public T t;
}
class AAAM<T> {

}
class BBBM<T> {
    //TODO 泛型的上限
    public void extendsTest(List<? extends UserM> list){

    }

    //TODO 泛型的下限
    public void superTest(List<? super UserM> list){

    }
}
class CCCM<T> {
    public MessageM<? extends T> consume() {
        return null;
    }
}
class DDDM<T> {
    public void produce(  MessageM< ? super T > m ) {

    }
}
class ParentM {

}

class UserM extends ParentM{

}

class SubUserM extends UserM {

}
class EmpM{

}
