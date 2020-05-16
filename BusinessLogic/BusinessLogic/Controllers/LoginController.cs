﻿using BusinessLogic.Model.Login;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

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


        [HttpGet("{id}")]
        public String Get(String id)
        {
            Console.WriteLine("IN get");
            Console.WriteLine(id);
            return id;
        }
        /*
        [HttpGet("{username}/{date}")]
        public String Get(String username, string date)
        {
            Console.WriteLine("IN get");
            Console.WriteLine(username);
            return "got it";
        }
        */

        // POST: api/Login
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<string>> ValidateUser(User user)
        {
            BusinessSocketHandler socket = BusinessSocketHandler.getInstance();

            socket.SendToDatabase("Login", user);

            return socket.GetResponse();
        }
    }
}