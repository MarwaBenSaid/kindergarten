using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace KinderGarten.Models
{
    public class User
    {
        public int idu { get; set; }
        public String username { get; set; }

        public String email { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "The {0} must be at least {2} characters long.", MinimumLength = 6)]
        [DataType(DataType.Password)]
        public String password { get; set; }

        public int telephone { get; set; }

        public String role { get; set; }

        public int zipCode { get; }

        

    }
}