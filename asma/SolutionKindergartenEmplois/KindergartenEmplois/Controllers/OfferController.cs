using KindergartenEmplois.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;

namespace KindergartenEmplois.Controllers
{
    public class OfferController:Controller
    {
        public ActionResult Index1()
        {

            // GET: Publishes
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8083/SpringMVC/servlet/");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage responce = Client.GetAsync("getAllOffers").Result;

            if (responce.IsSuccessStatusCode)
            {

                IEnumerable<Offer> o = responce.Content.ReadAsAsync<IEnumerable<Offer>>().Result;
                ViewBag.result = o;
            }
            else
            {
                ViewBag.pub = "error";
            }
            return View();
        }
        
        public ActionResult Postuler(int id)
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8083/SpringMVC/servlet/");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage responce = Client.PostAsync("postuler/5/"+id, null).Result;
            return View();

        }

    }
}