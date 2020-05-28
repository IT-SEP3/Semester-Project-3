using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BusinessLogic.Model.Shared
{
    public class Packet
    {
        public int serial { get; set; }
        public string contentInStringForm { get; set; }
        
        public Packet(int serial, string content){
            this.serial = serial;
            this.contentInStringForm = content;
        }
    }
}
