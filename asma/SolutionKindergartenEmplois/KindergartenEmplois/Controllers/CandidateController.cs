using KindergartenEmplois.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Script.Serialization;

namespace KindergartenEmplois.Controllers
{
    public class CandidateController:Controller
    {
        public ActionResult Index()
        {

            // GET: Publishes
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8083/SpringMVC/servlet/");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage responce = Client.GetAsync("getAllCandidates").Result;

            if (responce.IsSuccessStatusCode)
            {

                IEnumerable<Candidate> c = responce.Content.ReadAsAsync<IEnumerable<Candidate>>().Result;
                ViewBag.result = c;
            }
            else
            {
                ViewBag.pub = "error";
            }
            return View();
        }





        public ActionResult Create()
        {

            return View();
        }
        // POST: Publication/Create
        [HttpPost]
        public ActionResult Create(Candidate c)
        {

            HttpClient client = new HttpClient();

            HttpRequestMessage requestMessage = new HttpRequestMessage(HttpMethod.Post, "http://localhost:8083/SpringMVC/servlet/addCandidate");
            string json = new JavaScriptSerializer().Serialize(new
            {
                firstname= c.firstname,
                lastname = c.lastname,
                address= c.address,
                phone= c.phone,
                age= c.age,
                email=c.email,
                description= c.description,
                job = c.job
            });

            requestMessage.Content = new StringContent(json, Encoding.UTF8, "application/json");

            HttpResponseMessage response = client.SendAsync(requestMessage).GetAwaiter().GetResult();
            return View("Download");
        }


        [HttpPost]
        public ActionResult Download(HttpPostedFileBase file, Candidate c)
        {
            if (file != null && file.ContentLength > 0)
            {
                HttpClient client = new HttpClient();

                HttpRequestMessage requestMessage = new HttpRequestMessage(HttpMethod.Post, "http://localhost:8083/SpringMVC/servlet/upload");

                FileDB fileTest = new FileDB();
                MemoryStream target = new MemoryStream();

                file.InputStream.CopyTo(target); 
                byte[] da = target.ToArray();
                fileTest.data = da;
                fileTest.name = file.FileName;
                



            string json = new JavaScriptSerializer().Serialize(new
                {

                    fileTest = c.filedb

                }) ; 
                requestMessage.Content = new StringContent(json, Encoding.UTF8, "application/json");

                HttpResponseMessage response = client.SendAsync(requestMessage).GetAwaiter().GetResult();


            }

            else
            {
                ViewBag.Message = "You have not specified a file.";
            }
            return View();
        }

            [HttpPost]
        public ActionResult Delete(int idcandiate)
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8083/SpringMVC/servlet/");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage responce = Client.DeleteAsync("deleteCandidateById/4").Result;
            return RedirectToAction("Index");

        }






    }



  
}