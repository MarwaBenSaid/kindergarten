using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using KinderGarten.Models;


namespace KinderGarten.Controllers
{
    public class ReclamationController : Controller
    {
        HttpClient httpClient;
        string baseAddress;

        public ReclamationController()
        {
            baseAddress = "http://localhost:8083";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            //  var _AccessToken = Session[" AccessToken "];
            // httpClient.DefaultRequestHeaders.Add(" Authorization ", String.Format(" Bearer {0} ", _AccessToken));
        }
        // GET: Reclamation
        public ActionResult Index()
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "Admin/getAllReclamation").Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var reclamations = tokenResponse.Content.ReadAsAsync<IEnumerable<Reclamation>>().Result;
                return View("~/Views/Reclamation/Index.cshtml", reclamations);
            }
            else
            {
                return View("~/Views/Reclamation/Index.cshtml", new List<Reclamation>());

            }
        }

        // GET: Reclamation/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Reclamation/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Reclamation/Create
        [HttpPost]
        public ActionResult Create(Reclamation reclamation)
        {
            Console.WriteLine(reclamation);
            HttpClient client = new HttpClient();
            try
            {
                client.BaseAddress = new Uri("http://localhost:8083");
                client.PostAsJsonAsync<Reclamation>("/Users/save/1/1", reclamation).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Reclamation/Index.cshtml");
            }
        }

        

        // GET: Reclamation/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Reclamation/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Reclamation/Delete/5
        public ActionResult Delete(int id)
        {
            System.Diagnostics.Debug.WriteLine(id);
            var tokenResponse = httpClient.DeleteAsync(baseAddress + "Admin/deleteReclamationById/" + id).Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }
            return RedirectToAction("Index");
        }

        // POST: Reclamation/Delete/5
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
