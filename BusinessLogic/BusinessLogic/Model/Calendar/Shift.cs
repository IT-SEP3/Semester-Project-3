using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model.Shared;

namespace BusinessLogic.Model.Calendar
{
    public class Shift
    {

        public int Id { get; set; }
        public DateTime CreatedTime { get; set; }
        public string Description { get; set; }
        public string Status { get; set; }
        public int AssigneeId { get; set; }
        public User Assignee { get; set; }
        public int ManagerId { get; set; }
        public User Manager { get; set; }
    }
}
