using System.Threading.Tasks;
using KinderGarten.Models;

namespace System.Net
{
    internal class HttpClient : Http.HttpClient
    {
        internal Task<object> PostAsJsonAsync<T>(string v, Admin admin)
        {
            throw new NotImplementedException();
        }
    }
}