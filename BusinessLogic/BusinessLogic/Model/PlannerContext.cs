﻿using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Model.Calendar;
using BusinessLogic.Model.Shared;
using Microsoft.EntityFrameworkCore;
using Newtonsoft.Json;

namespace BusinessLogic.Model
{
    public class PlannerContext : DbContext
    {
        private BusinessSocketHandler socketHandler = BusinessSocketHandler.getInstance();

        public PlannerContext(DbContextOptions<PlannerContext> options) : base(options)
        { }

        // Unused for now
        public DbSet<User> Users { get; set; }
        public DbSet<Shift> Shifts { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // User
            modelBuilder.Entity<User>()
                .HasKey(c => c.username);

            // Shift
            modelBuilder.Entity<Shift>()
                .HasKey(s => s.Id);
            
        }

        public string ValidateLogin(User user)
        {
            socketHandler.SendToDatabase("Login", user);
            string result = socketHandler.GetResponse();
            if (result.Equals("OK"))
            {
                return "Login successful";
            }
            else
            {
                return "Wrong username or password";
            }
        }

        public async Task GetAllShifts(string username, string date)
        {
            socketHandler.SendToDatabaseStringOnly("CalendarMonth;" + username + ";" + date);
            List<Shift> shifts = JsonConvert.DeserializeObject<List<Shift>>(socketHandler.GetResponse());
            await Shifts.AddRangeAsync(shifts);
        }

        public string postUser(User user)
        {
            socketHandler.SendToDatabase("Login", user);
            string result = socketHandler.GetResponse();
            return result;
        }
    }
}