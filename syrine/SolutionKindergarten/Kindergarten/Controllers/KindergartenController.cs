using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;
using Kindergarten.Models;

namespace Kindergarten.Controllers
{
    public class KindergartenController : Controller
    {
        
            HttpClient httpClient;
            string baseAddress;
            public KindergartenController()
            {
            baseAddress = "http://localhost:8083/";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }




       

        // GET: Product
        public ActionResult Index()
        {

            var tokenResponse = httpClient.GetAsync(baseAddress + "getAllkindergartens").Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var kindergartens = tokenResponse.Content.ReadAsAsync<IEnumerable<Models.Kindergarten>>().Result;
                return View("~/Views/Kindergarten/Index.cshtml", kindergartens);
            }
            else
            {
                return View("~/Views/Kindergarten/Index.cshtml", new List<Models.Kindergarten>());

            }
        }


        // GET: Kindergarten/Details/5
        public ActionResult Details(int id)
            {
                return View();
            }

            // GET: Kindergarten/Create
            public ActionResult Create()
            {
                return View();
            }

            // POST: Kindergarten/Create
            [HttpPost]
            public ActionResult Create(Kindergarten.Models.Kindergarten kindergarten)
            {





                Console.WriteLine(kindergarten);
                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://localhost:8083");
            try
            {
                //Task<HttpResponseMessage> c = client.PostAsJsonAsync<Parent>("/addParent",parent);
                client.PostAsJsonAsync<Kindergarten.Models.Kindergarten>("addkindergarten", kindergarten).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());

                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Kindergarten/Index.cshtml");
            }
            }


            // GET: Kindergarten/Edit/5
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

            // POST: Kindergarten/Edit/5
            [HttpPost]
            public ActionResult Edit(int id, Models.Kindergarten kindergarten)
                        {
            try
            {
                var APIResponse = httpClient.PutAsJsonAsync<Models.Kindergarten>(baseAddress +"modify-kindergarten/"+id,
             kindergarten).ContinueWith(postTask => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Kindergarten/Index.cshtml");
            }

        }
        

            // GET: Kindergarten/Delete/5
            public ActionResult Delete(int id)
        {
            System.Diagnostics.Debug.WriteLine(id);
            var tokenResponse = httpClient.DeleteAsync(baseAddress + "deletekindergartenById/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Index");
        }

            // POST: Kindergarten/Delete/5
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
