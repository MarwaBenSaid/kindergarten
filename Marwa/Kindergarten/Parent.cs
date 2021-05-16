using System;

public class Parent
{
	public Parent()
	{
	}

    public class Parent
    {
        public int idparent { get; set; }
        public String firstname { get; set; }
        public String lastname { get; set; }
        public String address { get; set; }
        public String email { get; set; }
        public String login { get; set; }
        public String password { get; set; }
        public int phone { get; set; }
        public Parent()
        {

        }

        public Parent(int idparent, string firstname, string lastname, string address, string email, string login, string password, int phone)
        {
            this.idparent = idparent;
            this.firstname = firstname;
            this.lastname = lastname;
            this.address = address;
            this.email = email;
            this.login = login;
            this.password = password;
            this.phone = phone;
        }

        public override bool Equals(object obj)
        {
            return obj is Parent parent &&
                   idparent == parent.idparent &&
                   firstname == parent.firstname &&
                   lastname == parent.lastname &&
                   address == parent.address &&
                   email == parent.email &&
                   login == parent.login &&
                   password == parent.password &&
                   phone == parent.phone;
        }

        public override int GetHashCode()
        {
            int hashCode = -1620939561;
            hashCode = hashCode * -1521134295 + idparent.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(firstname);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(lastname);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(address);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(email);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(login);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(password);
            hashCode = hashCode * -1521134295 + phone.GetHashCode();
            return hashCode;
        }


        public override string ToString()
        {
            return base.ToString();
        }
    }
}
