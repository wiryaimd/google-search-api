# google-search-api

a special scraper that bypass recaptcha for search any website by any keyword using REST API (JSON produces)

## Prerequisites
* Java 17
* require google-services.json that soon will published

## Sample request
```bash
curl -X GET "http://localhost:8080/api/search?query=adnya%20sutha"
-H "Accept: application/json" 
-H "Authorization: Bearer <token>"
```

## Sample response
```bash
{
  "uid": "13a10553",
  "query": "adnya sutha",
  "statusCode": 200,
  "pageList": [
    {
      "title": "Adnya Sutha Wirya - Bali, Indonesia | Profil Profesional",
      "url": "https://id.linkedin.com/in/adnya-sutha-wirya-7a76101a0?trk=people_directory",
      "paragraph": "Adnya Sutha Wirya · Software & Mobile Developer using Java & Spring · Laporkan · Laporkan"
    },
    {
      "title": "Adnya Sutha Wirya wiryaimd - GitHub",
      "url": "https://github.com/wiryaimd",
      "paragraph": "Hmueheheh. wiryaimd has 11 repositories available. Follow their code on GitHub."
    },
    {
      "title": "02 November 2022 - Website SMK Negeri 1 Denpasar",
      "url": "https://www.smkn1denpasar.sch.id/berita-131",
      "paragraph": "2 Nov 2022 — ... Informasi Piranti Lunak untuk Bisnis diraih oleh I Made Adnya Sutha Wirya dengan guru pembimbing Pande Made Mahendri Pramadewi, S.Pd ..."
    },
    {
      "title": "Android Apps by Adnya Sutha Wirya on Google Play",
      "url": "https://play.google.com/store/apps/dev?id=4937206883372049468&hl=en_CA&gl=US",
      "paragraph": "Adnya Sutha Wirya. Messing pieces of my skull, ill sew on patches of my own soul. More by Adnya Sutha Wirya. Icon image Text Censorer. Text Censorer."
    },
    {
      "title": "Adnya Sutha Wirya | Facebook",
      "url": "https://www.facebook.com/adnya.wirya/",
      "paragraph": "Adnya Sutha Wirya is on Facebook. Join Facebook to connect with Adnya Sutha Wirya and others you may know. Facebook gives people the power to share and..."
    }
  ]
}
```
# 
This spring app will only send the requested query to private server and will listen the response for specific interval time. 

Theres no contains scraping process in this code because they are implemented in another code projects

The endpoint also need jwt to get accessed via ``localhost:8080/api/auth``

for more configuration will updated soon

```bash
mvn spring-boot:run 
./gradlew bootRun
java -jar target/google-search-api.jar
```
