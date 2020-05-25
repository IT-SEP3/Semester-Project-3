using BusinessLogic.Model;
using BusinessLogic.Model.Calendar;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ShiftsController : ControllerBase
    {
        private readonly PlannerContext _context;

        public ShiftsController(PlannerContext context)
        {
            _context = context;
        }

        // GET: api/Shifts
        [HttpGet]
        public async Task<ActionResult<String>> GetShifts([FromQuery (Name = "username")] string username, [FromQuery(Name = "accessLevel")] string accessLevel, [FromQuery (Name = "date")] string date)
        {
            return _context.GetAllShifts(username, accessLevel, date);
        }


        // GET: api/Shifts/5
        [HttpGet("{id}")]
        public async Task<ActionResult<String>> GetShift(int id)
        {
            return _context.GetShift(id);
        }


        // POST: api/Shifts
        // To protect from overposting attacks, enable the specific properties you want to bind to, for
        // more details, see https://go.microsoft.com/fwlink/?linkid=2123754.
        [HttpPost]
        public async Task<ActionResult<String>> PostShift(Shift shift)
        {
            return _context.PostShift(shift);
        }
    }
}
