using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(KindergartenEmplois.Startup))]
namespace KindergartenEmplois
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
