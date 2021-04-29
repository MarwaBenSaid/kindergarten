using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KindergartenEmplois.Models
{
    public class Candidate
    { 
		public int idcandiate { get; set; }
		public String firstname { get; set; }
		public String lastname { get; set; }
		public String address { get; set; }
		public int phone { get; set; }
		public int age { get; set; }
		public String email { get; set; }
		public String login { get; set; }
		public String password { get; set; }
		public String description { get; set; }
		public String job { get; set; }

		public FileDB filedb { get; set; }

		public ICollection<InfoPostuler> infopostulers { get; set; }
	}
}