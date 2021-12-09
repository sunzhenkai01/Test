package com.badao.Thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunkai
 * @date 2021/10/14 23:25
 * @mood happy
 */
public class ThriftClient {
    public static void main(String[] args) throws TTransportException {
        byte[] lmk = {1, 2, 3, 1, 5, 6};
        byte[] iv = {0, 5};
        byte[] z=new byte[10];
        for(int i=0;i<z.length;i++){
            System.out.print(z[i]);
        }
        byte2string(z);
       /* String bb = byte2string(lmk);
        System.out.println(bb);*/
        Map<String, String> map = new HashMap<>();
        map.put("一", "123456");
      //  map.put("lmk2", bb);
        map.put("iv", iv.toString());
       /* System.out.println(map.get("lmk2"));
        System.out.println(map.get("iv"));*/
        String DD = new String(iv);
        System.out.println(DD);
      /*  String s="hyhyhy";
        byte[]a=s.getBytes();
        String s2=new String(a);
        //System.out.println(s2);*/

        byte[] b = {0, 5, 1, 4, 7};



       /* String s = new String(lmk);
        System.out.println(s);


        System.out.println("s" + s);*/
       /* for(int i=0;i<lmk.length;i++){
            System.out.print(lmk[i]);
        }
        System.out.println(" ");

        Map<String, String> map = new HashMap<>();
        map.put("一", "123456");
        map.put("lmk2", lmk.toString());
        map.put("iv", iv.toString());
*/

        /*System.out.println("==================================================================");
        String str="hello";
        byte[] b=str.getBytes();
        String str1=new String(b);
        System.out.println(str1);*/

 /*     TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
       // TProtocol protocol = new TCompactProtocol(transport);
        TProtocol protocol = new TBinaryProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUsername("客户端");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("------------------------");

            Person person1 = new Person();
            person1.setUsername("客户端");
            person1.setAge(50);
            person1.setMarried(true);

            client.savePerson(person1);

        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage(),ex);
        }finally {
            transport.close();
        }*/
    }

    private static String byte2string(byte[] b) {
        String hh = "";
        for (int i = 0; i < b.length; i++) {
            hh += b[i];
        }
        return hh;
    }
}
