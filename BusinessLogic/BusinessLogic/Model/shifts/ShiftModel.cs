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

        public ShiftModel()
        {
            socketHandler = BusinessSocketHandler.getInstance();
        }

        public string GetShift(int id)
        {
            socketHandler.SendToDatabaseStringOnly("GetShift;" + id);
            return socketHandler.GetResponse();
        }

        public string GetAllShifts(string UserId, string AccessLevel, string date)
        {
            socketHandler.SendToDatabaseStringOnly("CalendarMonth;" + UserId + ";" + date + ";" + AccessLevel);
            string shifts = socketHandler.GetResponse();
            return shifts;
        }

        public string PostShift(Shift shift)
        {
            //Due to c# having no interoperability between DateTime or plugin class Localdate and java Date
            //and localDate we decided to just skip deserialization in the c# client
            socketHandler.SendToDatabase("PostShift", shift);
            string result = socketHandler.GetResponse();
            if (result.Equals("OK"))
            {
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("PostShift;Confirmed", shift);
                result = socketHandler.GetResponse();
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

        public string UpdateShift(Shift shift)
        {
            //Due to c# having no interoperability between DateTime or plugin class Localdate and java Date
            //and localDate we decided to just skip deserialization in the c# client
            socketHandler.SendToDatabase("updateShift", shift);
            string result = socketHandler.GetResponse();
            if (result.Equals("OK"))
            {
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("updateShift;Confirmed", shift);
                result = socketHandler.GetResponse();
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

        public void RemoveShift(int shiftId)
        {
        socketHandler.SendToDatabase("deleteShift", shiftId);
        }
    }
}
