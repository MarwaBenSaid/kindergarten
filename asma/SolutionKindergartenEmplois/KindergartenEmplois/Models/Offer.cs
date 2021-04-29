using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KindergartenEmplois.Models
{
    public class Offer
    {
		public int idoffer { get; set; }
		public String jobtitle { get; set; }

		public DateTime datedebut { get; set; }

		public DateTime datefin { get; set; }
		public String quality { get; set; }
		public String jobdescription { get; set; }
		public String functions { get; set; }

		public Kindergarten kindergarten { get; set; }
		public ICollection<InfoPostuler> infopostulers { get; set; }
	}
}