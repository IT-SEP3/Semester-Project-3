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

        public UserModel()
        {
            socketHandler = BusinessSocketHandler.getInstance();
        }

        public string GetUsers(object id)
        {
            throw new NotImplementedException();
        }

        public string PostUser(User user)
        {
            //Check if there is one in database
            socketHandler.SendToDatabase("PostUser", user);
            string result = socketHandler.GetResponse();
            if (result.Equals("OK"))
            {
                //If ok it post and returns if post was succesful
                socketHandler.SendToDatabase("PostUser;Confirmed", user);
                result = socketHandler.GetResponse();
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

        public string GetUser(int id)
        {
            socketHandler.SendToDatabaseStringOnly("GetUser;" + id);
            return socketHandler.GetResponse();
        }

        public string GetUsersIdName(int managerId)
        {
            socketHandler.SendToDatabaseStringOnly("GetUsersIDName;" + managerId);
            return socketHandler.GetResponse();
        }

        public string GetUsersByManager(int managerId)
        {
            socketHandler.SendToDatabaseStringOnly("GetManagedUsers;" + managerId);
            return socketHandler.GetResponse();

        }

        public string RemoveUser(int id)
        {
            socketHandler.SendToDatabaseStringOnly("DeleteUser;" + id);
            return socketHandler.GetResponse();
        }
    }
}
