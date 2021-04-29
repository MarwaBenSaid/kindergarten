using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KindergartenEmplois.Models
{
    public class Kindergarten
    {
		public int idkindergarten { get; set; }
		public String name { get; set; }
		public String description { get; set; }
		public String email { get; set; }
		public String logo { get; set; }
		public DateTime date { get; set; }

		public int nbremployes { get; set; }
	    public float cost { get; set; }
	    public ICollection<Offer> offer { get; set; }
	    public ICollection<Candidate> employees { get; set; }
}
}