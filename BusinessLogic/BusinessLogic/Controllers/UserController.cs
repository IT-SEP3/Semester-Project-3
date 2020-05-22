﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model;
using BusinessLogic.Model.Shared;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly PlannerContext _context;

        public UserController(PlannerContext context)
        {
            _context = context;
        }


        // POST: api/Employee
        [HttpPost]
        public async Task<ActionResult<string>> postUser(User user)
        {
            return _context.postUser(user);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<string>> getUser(int id)
        {
            return  _context.getUser(id);
        }
    }
}