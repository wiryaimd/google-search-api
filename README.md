# google-search-api

a special scraper that bypass recaptcha for search any website by any keyword using REST API (JSON produces)

## Prerequisites
* Java 17
* require google-services.json that soon will published

## Sample request
```bash
curl -X GET "http://localhost:8080/api/search?query=adnya%20sutha%20wirya"
-H "Accept: application/json" 
-H "Authorization: Bearer <token>"
```

## Sample response
```bash
{
  "uid": "1e2a8241",
  "query": "adnya sutha wirya",
  "statusCode": 200,
  "pageList": [
    {
      "title": "Adnya Sutha Wirya wiryaimd - GitHub",
      "url": "https://github.com/wiryaimd",
      "paragraph": "manga-translator · Automatically translate Manga/Manhwa/Manhua or other Comics to any languages (Android). Java ; Mc-Server-Connector · android app for allow mcpe ..."
    },
    {
      "title": "Adnya Sutha Wirya - Bali, Indonesia | Profil Profesional",
      "url": "https://id.linkedin.com/in/adnya-sutha-wirya-7a76101a0?trk=people_directory",
      "paragraph": "Adnya Sutha Wirya · Software & Mobile Developer using Java & Spring · Laporkan · Laporkan · Lisensi dan Sertifikasi · Website · Lihat profil lengkap Adnya · Login ..."
    },
    {
      "title": "Android-apper av Adnya Sutha Wirya på Google Play",
      "url": "https://play.google.com/store/apps/dev?id=4937206883372049468&hl=no&gl=US",
      "paragraph": "Adnya Sutha Wirya. Messing pieces of my skull, ill sew on patches of my own soul. Mer fra Adnya Sutha Wirya. Ikonbilde Text Censorer. Text Censorer."
    },
    {
      "title": "Apps para Android de Adnya Sutha Wirya en Google Play",
      "url": "https://play.google.com/store/apps/dev?id=4937206883372049468&hl=es_PE&gl=US",
      "paragraph": "Adnya Sutha Wirya. Visit Wiryaimd for main developer account. Más de Adnya Sutha Wirya. Imagen de ícono de Text Censorer. Text Censorer."
    },
    {
      "title": "Adnya Sutha Wirya - Quora",
      "url": "https://id.quora.com/profile/Adnya-Sutha-Wirya",
      "paragraph": "Adnya Sutha Wirya, Fullstack Web & Mobile Developer."
    },
    {
      "title": "02 November 2022 - Website SMK Negeri 1 Denpasar",
      "url": "https://www.smkn1denpasar.sch.id/berita-131",
      "paragraph": "2 Nov 2022 — ... Informasi Piranti Lunak untuk Bisnis diraih oleh I Made Adnya Sutha Wirya dengan guru pembimbing Pande Made Mahendri Pramadewi, S.Pd ..."
    },
    {
      "title": "Text Censorer APK for Android Download",
      "url": "https://m.apkpure.com/text-censorer/com.wiryaimd.textcensorer",
      "paragraph": "Adnya Sutha Wirya · Verification passed · Download APK. The XAPK (Base APK + Split APKs) File. How to install XAPK / APK file. 0.0. 0 Reviews."
    },
    {
      "title": "Text Censorer APK للاندرويد تنزيل - APK Pure",
      "url": "https://apkpure.com/ar/text-censorer/com.wiryaimd.textcensorer",
      "paragraph": "8 Aug 2022 — Adnya Sutha Wirya · تم التحقق منه · تحميل APK. The XAPK (Base APK + Split APKs) File. كيفية تثبيت XAPK / ملف APK."
    }
  ]
}
```
# 

Note this spring app will only send the requested query to private server and will listen the response for specific interval time. Theres no contains scraping process in this code because they are implemented in another code projects

The endpoint also need jwt to get accessed via ``localhost:8080/api/auth`` and for more configuration will updated soon

```bash
mvn spring-boot:run 
./gradlew bootRun
java -jar target/google-search-api.jar
```
#

## Test the API
![https://rapidapi.com/wiryaimdx/api/google-search-engine1](https://img.shields.io/badge/API-Try%20request%20from%20RapidAPI-blue)

```bash
https://rapidapi.com/wiryaimdx/api/google-search-engine1
```
You can subscribe for free and copy the key ``X-RapidAPI-Key`` to add in your request header
and use your preferred languages to request the API
### Example request using Java
```bash
OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://google-search-engine1.p.rapidapi.com/api/search?query=<your query>")
	.get()
	.addHeader("X-RapidAPI-Key", "<RapidAPI Key>")
	.addHeader("X-RapidAPI-Host", "google-search-engine1.p.rapidapi.com")
	.build();

Response response = client.newCall(request).execute();
```
