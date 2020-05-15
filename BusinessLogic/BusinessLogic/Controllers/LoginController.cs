using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using BusinessLogic.Model.Login;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private readonly LoginContext _context;

        public LoginController(LoginContext context)
        {
            _context = context;
        }

        // GET: api/Login
        // Just a test for now - to be deleted
        [HttpGet]
        public async Task<ActionResult<IEnumerable<User>>> GetUsers()
        {
            return await _context.Users.ToListAsync();
        }

        // POST: api/Login
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<User>> ValidateUser(User user)
        {
            BusinessSocketHandler socket = BusinessSocketHandler.getInstance();
            
            socket.sendToDatabase(user);

        }

    }
}
