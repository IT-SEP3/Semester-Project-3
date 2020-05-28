using BusinessLogic.Model.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.login
{
    public class LoginModel : ILoginModel
    {
        private BusinessSocketHandler socketHandler;
        private Random random = new Random();

        public LoginModel()
        {
            socketHandler = BusinessSocketHandler.getInstance();
        }


        public async Task<string> ValidateLogin(User user)
        {
            int serial = random.Next();
            socketHandler.SendToDatabase("Login", user, serial);
            string result = await socketHandler.GetResponse(serial);
            string[] resultSlpit = result.Split(";");
            if (resultSlpit[0].Equals("OK"))
            {
                return "Login successful;" + resultSlpit[1];
            }
            else
            {
                return "Wrong username or password";
            }
        }
    }
}
