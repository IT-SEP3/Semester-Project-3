using BusinessLogic.Model.Shared;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.user
{
    interface IUserModel
    {
        Task<string> GetUsers(object id);
        Task<string> PostUser(User user);
        Task<string> GetUser(int id);
        Task<string> GetUsersIdName(int managerId);
        Task<string> GetUsersByManager(int managerId);
        Task<string> RemoveUser(int id);
    }
}
