using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;
using KinderGarten.Models;

namespace KinderGarten.Controllers
{
    public class AdminController : Controller
    {
        HttpClient httpClient;
        string baseAddress;

        public AdminController()
        {
            baseAddress = "http://localhost:8083";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            //  var _AccessToken = Session[" AccessToken "];
            // httpClient.DefaultRequestHeaders.Add(" Authorization ", String.Format(" Bearer {0} ", _AccessToken));
        }
        // GET: Admin
        public ActionResult Index()
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "/Admin/getAllAdmin/").Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var admins = tokenResponse.Content.ReadAsAsync<IEnumerable<Admin>>().Result;
                return View("~/Views/Admin/Index.cshtml", admins);
            }
            else
            {
                return View("~/Views/Admin/Index.cshtml", new List<Admin>());

            }
        }

        // GET: Admin/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Admin/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Admin/Create
        [HttpPost]
        public ActionResult Create(Admin admin)
        {
            Console.WriteLine(admin);
            HttpClient client = new HttpClient();
            try
            {
                client.BaseAddress = new Uri("http://localhost:8083");
                client.PostAsJsonAsync<Admin>("/Admin/addAdmin/97246b36-a611-4671-81e8-e64977f7ec9d", admin).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Admin/Index.cshtml");
            }
        }

        // GET: Admin/Edit/5
        public ActionResult Edit(int id)
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "/get/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var sub = tokenResponse.Content.ReadAsAsync<Admin>().Result;
                return View(sub);
            }
            else
            {
                return View(new Admin());
            }
        }

        // POST: Admin/Edit/5
        [HttpPost]
        public ActionResult Edit( int id , Admin admin)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Admin>(baseAddress + "/Admin/modify/" + id,
                admin).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
                
            }
            catch
            {
                return View("~/Views/Admin/Index.cshtml");
            }
        }

        // GET: Admin/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Admin/Delete/5
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
