using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model;
using BusinessLogic.Model.Shared;
using BusinessLogic.Model.user;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IUserModel _context;

        public UserController()
        {
            _context = new UserModel();
        }


        // POST: api/Employee
        [HttpPost]
        public async Task<ActionResult<string>> PostUser(User user)
        {
            return _context.PostUser(user);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<string>> GetUser(int id)
        {
            return  _context.GetUser(id);
        }


        [HttpGet("id-name")]
        public async Task<ActionResult<string>> GetUsersIdName([FromQuery(Name = "managerId")] int managerId)
        {
            return _context.GetUsersIdName(managerId);
        }


        [HttpGet]
        public async Task<ActionResult<string>> GetUsers([FromQuery(Name = "managerId")] int managerId)
        {
            return _context.GetUsersByManager(managerId);
        }


        [HttpDelete("{id}")]
        public async Task<ActionResult<String>> RemoveUser(int id)
        {
            Console.WriteLine(id);
            return _context.RemoveUser(id);
        }
    }
}
