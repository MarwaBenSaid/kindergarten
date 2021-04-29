using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Kindergarten.Models
{
    public class Appointment { 
        public int Id { get; set; }
        public DateTime Date { get; set; }
        
        public virtual Kindergarten kindergarten { get; set; }



    }
}