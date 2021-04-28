using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace KinderGarten.Models
{
    public class Reclamation
    {
    
        public int idreclamation { get; set; }
        public string titre { get; set; }
        public string description { get; set; }

        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime? datereclamation { get; set; }
        public int nbreclamation { get; set; }


                     
    }

   
}