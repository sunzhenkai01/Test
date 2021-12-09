package com.badao.Thrift;
import org.apache.thrift.TException;
/**
 * @author sunkai
 * @date 2021/10/14 23:23
 * @mood happy
 */
public class PersonServiceImpl implements PersonService.Iface{
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("getPersonByUsername被调用并收到参数:" + username);
        Person person = new Person();
        person.setUsername("收到客户端参数");
        person.setAge(100);
        person.setMarried(true);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("savePerson方法被调用，接收到的参数为:");
        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }

}
