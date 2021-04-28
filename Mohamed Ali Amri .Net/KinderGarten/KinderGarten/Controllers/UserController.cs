using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net.Http;
using System.Net.Http.Headers;
using KinderGarten.Models;

namespace KinderGarten.Controllers
{
    public class UserController : Controller
    {
        HttpClient httpClient;
        string baseAddress;

        public UserController()
        {
            baseAddress = "http://localhost:8083";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            //  var _AccessToken = Session[" AccessToken "];
            // httpClient.DefaultRequestHeaders.Add(" Authorization ", String.Format(" Bearer {0} ", _AccessToken));
        }
        // GET: User
        public ActionResult Index()
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "/Users/getAllUser/").Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var users = tokenResponse.Content.ReadAsAsync<IEnumerable<User>>().Result;
                return View("~/Views/User/Index.cshtml", users);
            }
            else
            {
                return View("~/Views/User/Index.cshtml", new List<User>());

            }
        }

        // GET: User
        public ActionResult Reset(String email)
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "/Users/resetPassword" + email).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var users = tokenResponse.Content.ReadAsAsync<IEnumerable<User>>().Result;
                return View("~/Views/User/Index.cshtml", users);
            }
            else
            {
                return View("~/Views/User/Index.cshtml", new List<User>());

            }
        }

        // GET: User/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: User/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: User/Create
        [HttpPost]
        public ActionResult Create(User user)
        {
            Console.WriteLine(user);
            HttpClient client = new HttpClient();
            try
            {
                client.BaseAddress = new Uri("http://localhost:8083");
                client.PostAsJsonAsync<User>("/Users/addUser", user).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/User/Index.cshtml");
            }
        }

       // GET: User/Edit/5
        public ActionResult Edit(int id)
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "/get/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var sub = tokenResponse.Content.ReadAsAsync<User>().Result;
                return View(sub);
            }
            else
            {
                return View(new User());
            }
        }

       

        // POST: User/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, User user)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<User>(baseAddress + "/Users/modifyu/" + id,
                user).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");

            }
            catch
            {
                return View("~/Views/User/Index.cshtml");
            }
        }

        // GET: User/Delete/5
        public ActionResult Delete(int id)
        {
            System.Diagnostics.Debug.WriteLine(id);
            var tokenResponse = httpClient.DeleteAsync(baseAddress + "/Users/suppression/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Index");
        }

        // POST: User/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
