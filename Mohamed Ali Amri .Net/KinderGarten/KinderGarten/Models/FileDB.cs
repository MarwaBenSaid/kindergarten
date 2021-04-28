using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KinderGarten.Models
{
    public class FileDB
    {
        public String id { get; }
        public String name { get;  }

        public String type { get;  }

        public byte [] data { get; set; }


    }
}