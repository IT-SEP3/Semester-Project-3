using Microsoft.EntityFrameworkCore;

namespace BusinessLogic.Model.Login
{
    public class LoginContext : DbContext
    {
        private BusinessSocketHandler socketHandler = BusinessSocketHandler.getInstance();

        public LoginContext(DbContextOptions<LoginContext> options) : base(options)
        { }

        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>()
                .HasKey(c => c.username);
        }

        public string validateLogin(User user)
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
    }
}