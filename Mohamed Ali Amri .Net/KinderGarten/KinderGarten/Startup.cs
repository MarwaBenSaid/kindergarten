using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(KinderGarten.Startup))]
namespace KinderGarten
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
