using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text.Json;
using System.Threading.Tasks;

namespace BusinessLogic
{
    class BusinessSocketHandler
    {
        private Socket businessSocket;

        private BusinessSocketHandler()
        {
        }

        private static BusinessSocketHandler _instance;

        public void setSocket(Socket businessSocket)
        {
            this.businessSocket = businessSocket;
        }

        public static BusinessSocketHandler getInstance()
        {
            if (_instance == null)
            {
                _instance = new BusinessSocketHandler();
            }
            return _instance;
        }
        public async void Run()
        {
            try
            {
                while (true)
                {
                    //String fromDatabase = await businessSocket.AcceptAsync();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }


        public void sendToDatabase(Object obj)
        {
            String objJson = JsonSerializer.Serialize(obj);
            int toSendLen = System.Text.Encoding.ASCII.GetByteCount(objJson);
            byte[] toSendBytes = System.Text.Encoding.ASCII.GetBytes(objJson);
            byte[] toSendLenBytes = System.BitConverter.GetBytes(toSendLen);
            Console.WriteLine(objJson);
            businessSocket.Send(toSendLenBytes);
            businessSocket.Send(toSendBytes);
        }
    }
}
