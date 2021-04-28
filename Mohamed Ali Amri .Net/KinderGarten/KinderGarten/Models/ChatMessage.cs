using System;
using System.Collections.Generic;
using System.Linq;
using System.Messaging;
using System.Web;

namespace KinderGarten.Models
{
    public class ChatMessage
    {
        public String content { get; set; }

        public String Sender { get; set; }

        public MessageType type { get; set; }
    }
}