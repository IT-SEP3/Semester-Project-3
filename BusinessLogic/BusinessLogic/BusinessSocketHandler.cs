using BusinessLogic.Model.Shared;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Net.Sockets;
using System.Text.Json;
using System.Threading.Tasks;

namespace BusinessLogic
{
    internal class BusinessSocketHandler
    {
        private Socket businessSocket;
        private List<Packet> packetList;

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
        {
            packetList = new List<Packet>(); 
            while (true)
            {
                byte[] rcvLenBytes = new byte[4];
                businessSocket.Receive(rcvLenBytes);
                int rcvLen = System.BitConverter.ToInt32(rcvLenBytes, 0);
                byte[] rcvBytes = new byte[rcvLen];
                businessSocket.Receive(rcvBytes);
                String received = System.Text.Encoding.ASCII.GetString(rcvBytes);
                Console.WriteLine(received);

                String[] splitPacket = received.Split(";");
                Packet messagePacket = new Packet(int.Parse(splitPacket[1]), splitPacket[0]);
                packetList.Add(messagePacket);
            }
        }

        public void SendToDatabase(String command, Object obj, int serial)
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

        public void SendToDatabaseStringOnly(String statement, int serial)
        {
            statement = statement + ";" + serial;
            int toSendLen = System.Text.Encoding.ASCII.GetByteCount(statement);
            byte[] toSendBytes = System.Text.Encoding.ASCII.GetBytes(statement);
            byte[] toSendLenBytes = System.BitConverter.GetBytes(toSendLen);
            Console.WriteLine(statement);
            businessSocket.Send(toSendLenBytes);
            businessSocket.Send(toSendBytes);
        }

        public async Task<string> GetResponse(int serial)
        {
            string recieved = "Packet did not arrive";
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    int number = packetList.Count;
                    for (int u = 0; u < packetList.Count; u++)
                    {
                        if (packetList[u].serial == serial)
                        {
                            recieved = packetList[u].contentInStringForm;
                            packetList.RemoveAt(u);
                            break;
                        }
                        if (!recieved.Equals("Packet did not arrive"))
                        {
                            break;
                        }
                    }
                }
                catch (NullReferenceException e)
                {
                    await Task.Delay(300);
                }
                
            }

            return recieved;
        }
    }
}