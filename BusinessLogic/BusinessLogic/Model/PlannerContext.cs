using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Model.Calendar;
using BusinessLogic.Model.Shared;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;

namespace BusinessLogic.Model
{
    public class PlannerContext : DbContext
    {
        private BusinessSocketHandler socketHandler = BusinessSocketHandler.getInstance();

        public PlannerContext(DbContextOptions<PlannerContext> options) : base(options)
        { }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {   
        }

        public string ValidateLogin(User user)
        {
            socketHandler.SendToDatabase("Login", user);
            string result = socketHandler.GetResponse();
            string[] resultSlpit = result.Split(";");
            if (resultSlpit[0].Equals("OK"))
            {
                return "Login successful;"+ resultSlpit[1];
            }
            else
            {
                return "Wrong username or password";
            }
        }

        internal string GetShift(int id)
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

        public string PostUser(User user)
        {
            //Check if there is one in database 
            socketHandler.SendToDatabase("PostUser", user);
            string result = socketHandler.GetResponse();
            if (result.Equals("OK")){
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("PostUser;Confirmed", user);
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
                return "Database already has this user in it";
            }
            
        }

        public string PostShift(Shift shift)
        {

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

        public string GetUser(int id)
        {
            socketHandler.SendToDatabaseStringOnly("GetUser;" + id);
            return socketHandler.GetResponse();
        }

        public string GetUsersIdName()
        {
            socketHandler.SendToDatabaseStringOnly("GetUsersIDName;");
            return socketHandler.GetResponse();
        }
    }
}