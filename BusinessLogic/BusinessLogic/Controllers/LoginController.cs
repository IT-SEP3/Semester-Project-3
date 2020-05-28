using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Model;
using BusinessLogic.Model.Shared;
using BusinessLogic.Model.login;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {
        private ILoginModel _context;

        public LoginController()
        {
            _context = new LoginModel();
        }


        // POST: api/Login
        [HttpPost]
        public async Task<string> ValidateUser(User user)
        {
            return await _context.ValidateLogin(user);
        }
    }
}