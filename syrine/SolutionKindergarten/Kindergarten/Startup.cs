using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Kindergarten.Startup))]
namespace Kindergarten
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
