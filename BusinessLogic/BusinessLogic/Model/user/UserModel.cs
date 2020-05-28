using BusinessLogic.Model.Shared;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.user
{
    public class UserModel : IUserModel
    {
        private BusinessSocketHandler socketHandler; 
        private Random random = new Random();

        public UserModel()
        {
            socketHandler = BusinessSocketHandler.getInstance();
        }

        public Task<string> GetUsers(object id)
        {
            int serial = random.Next();
            throw new NotImplementedException();
        }

        public async Task<string> PostUser(User user)
        {
            int serial = random.Next();
            //Check if there is one in database
            socketHandler.SendToDatabase("PostUser", user, serial);
            string result = await socketHandler.GetResponse(serial);
            if (result.Equals("OK"))
            {
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("PostUser;Confirmed", user, serial);
                result = await socketHandler.GetResponse(serial);
                if (result.Equals("OK"))
                {
                    return "Success";
                }
                else
                {
                    return "User already exists";
                }
            }
            else
            {
                return "Database already has this user in it";
            }
        }

        public async Task<string> GetUser(int id)
        {
            int serial = random.Next();
            socketHandler.SendToDatabaseStringOnly("GetUser;" + id, serial);
            return await socketHandler.GetResponse(serial);
        }

        public async Task<string> GetUsersIdName(int managerId)
        {
            int serial = random.Next();
            socketHandler.SendToDatabaseStringOnly("GetUsersIDName;" + managerId, serial);
            return await socketHandler.GetResponse(serial);
        }

        public async Task<string> GetUsersByManager(int managerId)
        {
            int serial = random.Next();
            socketHandler.SendToDatabaseStringOnly("GetManagedUsers;" + managerId, serial);
            return await socketHandler.GetResponse(serial);

        }

        public async Task<string> RemoveUser(int id)
        {
            int serial = random.Next();
            socketHandler.SendToDatabaseStringOnly("DeleteUser;" + id, serial);
            return await socketHandler.GetResponse(serial);
        }
    }
}
