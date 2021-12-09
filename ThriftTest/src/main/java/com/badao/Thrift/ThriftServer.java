package com.badao.Thrift;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
//import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @author sunkai
 * @date 2021/10/14 23:24
 * @mood happy
 */
public class ThriftServer {
    public static void main(String[] args) throws Exception
    {
        //0、传输方式：设置服务器端口  TNonblockingServerSocket-非堵塞服务模型
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8899);

        //2-1服务类型：参数设置
        THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(4);

        //1、处理器
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        //3、传输协议
        //arg.protocolFactory(new TCompactProtocol.Factory());
        arg.protocolFactory(new TBinaryProtocol.Factory());
        //2、transport层
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));


        //4、启动服务
        TServer server = new THsHaServer(arg);
        System.out.println("Thrift 服务端启动成功");
        server.serve();
    }
}
