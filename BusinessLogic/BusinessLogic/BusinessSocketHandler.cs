using System;
using System.Net.Sockets;
using System.Text.Json;

namespace BusinessLogic
{
    internal class BusinessSocketHandler
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

        public async void Run()//May be removed.
        { }

        public void SendToDatabase(String command, Object obj)
        {
            String objJson = JsonSerializer.Serialize(obj);
            objJson = command + ";" + objJson;
            int toSendLen = System.Text.Encoding.ASCII.GetByteCount(objJson);
            byte[] toSendBytes = System.Text.Encoding.ASCII.GetBytes(objJson);
            byte[] toSendLenBytes = System.BitConverter.GetBytes(toSendLen);
            Console.WriteLine(objJson);
            businessSocket.Send(toSendLenBytes);
            businessSocket.Send(toSendBytes);
        }

        public void SendToDatabaseStringOnly(String statement)
        {
            int toSendLen = System.Text.Encoding.ASCII.GetByteCount(statement);
            byte[] toSendBytes = System.Text.Encoding.ASCII.GetBytes(statement);
            byte[] toSendLenBytes = System.BitConverter.GetBytes(toSendLen);
            Console.WriteLine(statement);
            businessSocket.Send(toSendLenBytes);
            businessSocket.Send(toSendBytes);
        }

        // Because the database will only give you things when you ask for them
        // there is no need for a loop in the thread. You ask for response yourself
        // . THER
        public String GetResponse()
        {
            byte[] rcvLenBytes = new byte[4];
            businessSocket.Receive(rcvLenBytes);
            int rcvLen = System.BitConverter.ToInt32(rcvLenBytes, 0);
            byte[] rcvBytes = new byte[rcvLen];
            businessSocket.Receive(rcvBytes);
            String received = System.Text.Encoding.ASCII.GetString(rcvBytes);

            return received;
        }
    }
}