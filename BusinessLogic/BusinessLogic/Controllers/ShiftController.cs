using BusinessLogic.Model.Shared;
using BusinessLogic.Model.shifts;
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
    public class ShiftController : ControllerBase
    {
        private IShiftModel _context;

        public ShiftController()
        {
            _context = new ShiftModel();
        }

        // GET: api/Shifts
        [HttpGet]
        public async Task<ActionResult<String>> GetShifts([FromQuery (Name = "username")] string username, [FromQuery(Name = "accessLevel")] string accessLevel, [FromQuery (Name = "date")] string date)
        {
            return  _context.GetAllShifts(username, accessLevel, date);
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
            Console.WriteLine(shift);
            return _context.PostShift(shift);
        }
        /*
        [HttpPost]
        public async Task<ActionResult<String>> updateShift(Shift shift)
        {
            Console.WriteLine(shift);
            return _context.UpdateShift(shift);
        } 
        */
    }
}
