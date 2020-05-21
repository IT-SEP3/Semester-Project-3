using BusinessLogic.Model.Calendar;
using BusinessLogic.Model.Login;
using Microsoft.EntityFrameworkCore;

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

        public string validateLogin(User user)
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

        public void GetAllShifts()
        {
            socketHandler.SendToDatabaseStringOnly("GetShifts; OR WHICHEVER COMMAND FROM JAVA SERVER");
            socketHandler.GetResponse();
        }
    }
}