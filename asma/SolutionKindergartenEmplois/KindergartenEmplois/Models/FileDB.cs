using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;

namespace KindergartenEmplois.Models
{
    public class FileDB
    {
        public String id { get; set; }

        public String name { get; set; }

        public String type { get; set; }

        public byte[] data { get; set; }

       
    }
}