using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Sockets;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace BusinessLogic
{
    public class Program
    {
        public static void Main(string[] args)
        {
            try
            {
                IPEndPoint serverAddress = new IPEndPoint(IPAddress.Parse("192.168.1.5"), 4343);
                Socket BusinessSocket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
                BusinessSocket.Connect(serverAddress);
                BusinessSocketHandler socketHandler = BusinessSocketHandler.getInstance();
                socketHandler.setSocket(BusinessSocket);
                Thread t = new Thread(new ThreadStart(socketHandler.Run));
                Console.WriteLine("Connection to Database established");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}
