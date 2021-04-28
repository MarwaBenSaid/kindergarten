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
    public class JwtAuthenticationController : Controller
    {
        HttpClient httpClient;
        string baseAddress;

        public JwtAuthenticationController()
        {
            baseAddress = "http://localhost:8083";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            //  var _AccessToken = Session[" AccessToken "];
            // httpClient.DefaultRequestHeaders.Add(" Authorization ", String.Format(" Bearer {0} ", _AccessToken));
        }
        // GET: JwtAuthentication
        public ActionResult Index()
        {
            return View();
        }

        // GET: JwtAuthentication/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: JwtAuthentication/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: JwtAuthentication/Create
        [HttpPost]
        public ActionResult Create(JwtRequest jwtAuthentication)
        {
            Console.WriteLine(jwtAuthentication);
            HttpClient client = new HttpClient();
            try
            {
                client.BaseAddress = new Uri("http://localhost:8083");
                client.PostAsJsonAsync<JwtRequest>("/authenticate", jwtAuthentication).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
                return RedirectToAction("Index");
            }
            catch
            {
                return View("~/Views/Shared/_Constra.cshtml");
            }
        }

        // GET: JwtAuthentication/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: JwtAuthentication/Edit/5
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

        // GET: JwtAuthentication/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: JwtAuthentication/Delete/5
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
