using BusinessLogic.Model.Login;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Model;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private readonly PlannerContext _context;

        public LoginController(PlannerContext context)
        {
            _context = context;
        }


        // POST: api/Login
       [HttpPost]
        public async Task<ActionResult<string>> ValidateUser(User user)
        {
            return _context.validateLogin(user);
        }
    }
}