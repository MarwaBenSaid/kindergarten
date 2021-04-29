using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KindergartenEmplois.Models
{
    public class InfoPostuler
    {
     public int numpost { get; set; }

        public DateTime datepost { get; set; }

        public Offer offer { get; set; }

        public Candidate candidate { get; set; }
    }
}