using BusinessLogic.Model.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.shifts
{
    public class ShiftModel : IShiftModel
    {
        private BusinessSocketHandler socketHandler;
        private Random random = new Random();

        public ShiftModel()
        {
            socketHandler = BusinessSocketHandler.getInstance();
        }

        public Task<string> GetShift(int id)
        {
            int serial = random.Next();
            Console.WriteLine(serial);
            socketHandler.SendToDatabaseStringOnly("GetShift;" + id, serial);
            return socketHandler.GetResponse(serial);
        }

        public async Task<string> GetAllShifts(string UserId, string AccessLevel, string date)
        {
            int serial = random.Next();
            socketHandler.SendToDatabaseStringOnly("CalendarMonth;" + UserId + ";" + date + ";" + AccessLevel, serial);
            string shifts = await socketHandler.GetResponse(serial);
            return shifts;
        }

        public async Task<string> PostShift(Shift shift)
        {
            int serial = random.Next();
            //Due to c# having no interoperability between DateTime or plugin class Localdate and java Date
            //and localDate we decided to just skip deserialization in the c# client
            socketHandler.SendToDatabase("PostShift", shift, serial);
            string result = await socketHandler.GetResponse(serial);
            if (result.Equals("OK"))
            {
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("PostShift;Confirmed", shift, serial);
                result = await socketHandler.GetResponse(serial);
                if (result.Equals("OK"))
                {
                    return "Success";
                }
                else
                {
                    return "Failed";
                }
            }
            else
            {
                return "Database already has this shift in it";
            }
        }

        public async Task<string> UpdateShift(Shift shift)
        {
            int serial = random.Next();
            //Due to c# having no interoperability between DateTime or plugin class Localdate and java Date
            //and localDate we decided to just skip deserialization in the c# client
            socketHandler.SendToDatabase("updateShift", shift, serial);
            string result = await socketHandler.GetResponse(serial);
            if (result.Equals("OK"))
            {
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("updateShift;Confirmed", shift, serial);
                result = await socketHandler.GetResponse(serial);
                if (result.Equals("OK"))
                {
                    return "Success";
                }
                else
                {
                    return "Failed";
                }
            }
            else
            {
                return "Database already has this shift in it";
            }
        }
    }
}
