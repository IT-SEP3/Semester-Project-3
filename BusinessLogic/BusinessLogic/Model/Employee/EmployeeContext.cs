using BusinessLogic.Model.Login;

namespace BusinessLogic.Controllers
{
    internal class EmployeeContext
    {
        private BusinessSocketHandler socketHandler = BusinessSocketHandler.getInstance();

        public EmployeeContext()
        { }

        public string postUser(User user)
        {
            socketHandler.SendToDatabase("Login", user);
            string result = socketHandler.GetResponse();
            return result;
        }

    }
}