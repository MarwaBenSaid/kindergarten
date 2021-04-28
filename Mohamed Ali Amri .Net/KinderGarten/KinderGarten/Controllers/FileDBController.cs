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
    public class FileDBController : Controller
    {
        HttpClient httpClient;
        string baseAddress;

        public FileDBController()
        {
            baseAddress = "http://localhost:8083/";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            //  var _AccessToken = Session[" AccessToken "];
            // httpClient.DefaultRequestHeaders.Add(" Authorization ", String.Format(" Bearer {0} ", _AccessToken));
        }

        // GET: FileDB
        public ActionResult Index()
        {
            var tokenResponse = httpClient.GetAsync(baseAddress + "/files").Result;
            if (tokenResponse.IsSuccessStatusCode)
            {
                var reclamations = tokenResponse.Content.ReadAsAsync<IEnumerable<FileDB>>().Result;
                return View("~/Views/FileDB/Index.cshtml", reclamations);
            }
            else
            {
                return View("~/Views/FileDB/Index.cshtml", new List<FileDB>());

            }
        }

        // GET: FileDB/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: FileDB/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: FileDB/Create
        [HttpPost]
        public ActionResult Create(FileDB filedb)
        {
            Console.WriteLine(filedb);
            HttpClient client = new HttpClient();
            try
            {
                client.BaseAddress = new Uri("http://localhost:8083");
                client.PostAsJsonAsync<FileDB>("/upload", filedb).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Create");
            }
            catch
            {
                return View("~/Views/Reclamation/Create.cshtml");
            }
        }

        // GET: FileDB/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: FileDB/Edit/5
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

        // GET: FileDB/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: FileDB/Delete/5
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
