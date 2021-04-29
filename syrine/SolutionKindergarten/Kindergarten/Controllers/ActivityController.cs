using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;

namespace Kindergarten.Controllers
{
    public class ActivityController : Controller
    {
        
            HttpClient httpClient;
            string baseAddress;
        public ActivityController()
        {
            baseAddress = "http://localhost:8083/";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }
            // GET: Activity
            public ActionResult Index()
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "getAll").Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var activity = tokenResponse.Content.ReadAsAsync<IEnumerable<Models.Activity>>().Result;
                return View("~/Views/Activity/Index.cshtml", activity);
            }
            else
            {
                return View("~/Views/Activity/Index.cshtml", new List<Models.Activity>());

            }
        }

        // GET: Activity/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Activity/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Activity/Create
        [HttpPost]
        public ActionResult Create(Models.Activity activity)
        {
            Console.WriteLine(activity);
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8083");
            try
            {
                //Task<HttpResponseMessage> c = client.PostAsJsonAsync<Parent>("/addParent",parent);
                client.PostAsJsonAsync<Models.Activity>("addkActivity", activity).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());

                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Activity/Index.cshtml");
            }

        }

        // GET: Activity/Edit/5
        public ActionResult Edit(int id)
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "get/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var sub = tokenResponse.Content.ReadAsAsync<Models.Kindergarten>().Result;
                return View(sub);
            }
            else
            {
                return View(new Models.Kindergarten());
            }
        }

        // POST: Activity/Edit/5
        [HttpPost]
        public ActionResult Edit( int id,Models.Activity activity)
        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Models.Activity>(baseAddress + "modify-activity/"+id ,
             activity).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Activity/Index.cshtml");
            }
        }

        // GET: Activity/Delete/5
        public ActionResult Delete(int id)
        {
            System.Diagnostics.Debug.WriteLine(id);
            var tokenResponse = httpClient.DeleteAsync(baseAddress + "deleteActivityById/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Index");
        }

        // POST: Activity/Delete/5
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
