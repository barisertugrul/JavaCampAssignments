# JavaCamp-GameCenterProject Assignment 5.1
## Yazılım Geliştirici Yetiştirme Kampı (JAVA &amp; REACT) - Game Store Project
### Bu çalışma saygıdeğer hocamız Engin Demiroğ'un Yazılım Geliştirici Yetiştirme Kampı (Java & React) eğitimi sırasında verilen 5. gün 1.ödev için hazırlanmıştır.

* Veritabanı simülasyonu hazırlandı. Uygulama çalışırken veriler bir veritabanı mantığına uygun olarak bellekte tutuluyor, uygulama sonunda sıfırlanıyor.

* Bu uygulamada da Kerem Varış hocamızın Linkedin'deki <a href="https://www.linkedin.com/pulse/yaz%C4%B1l%C4%B1mc%C4%B1n%C4%B1n-gizli-kabusu-constructor-injection-cehennemi-kerem-varis"/>Yazılımcının Gizli Kabusu Constructor Injection Cehennemi Nedir?</a> başlıklı yazısından esinlenerek bir ServiceFactory çalışması yapmaya çalıştım. Ancak Java'daki karşılığı konusunda bilgi eksiklikleri olduğu için eksik, hatta yanlış olabilir. (Özellikle injection sınıflarının örneğinin uygulama başlarken oluşturulması ciddi bir sorundu. İstekte bulunulduğu anda sınıf örneğinin oluşturulup, işi bitince bellekten kaldırılacağı bir sistem kurulmalı. Üzerinde çalışıyorum. Şu an bellek tasarrufu için, ancak FactoryManager içinde newleme gerçekleştirdim. Geç bağlama için sanırım özel eklentiler var.).
* Google girişinde, kullanıcının eposta ve şifre girişini google arayüzünde yapması nedeniyle, bu giriş yapıldıktan sonra, goggledan geriye password haricinde kullanıcı bilgilerinin döndüğünü varsaydım ve işlemleri ona göre devam ettirdim. Bu durumda gerekli doğrulama kontrolleri, sadece site üzerinden girişlerde anlamlı olacağı için ona göre kod yazdım. Google login ve register işlemleri için, goggle adapter sınıfı hazırlayıp, auth sınıfına metod parametresi olarak verdim. Login ve Register metotları için overloading ile site içi ve external servis metotlarını ayırdım.
* Activasyon maili gönderimini, bir loglama türü olarak düşündüm ve auth sınıfına injection yöntemiyle dahil ettim. Farklı aktivasyon kodu gönderimlerine açık bir sistem oldu diye düşünüyorum (Örneğin SMS doğrulaması).
* Kullanıcını verilerini kontrol işlemlerini de UserValidationManager içerisinde hazırladığım metotlarla gerçekleştirdim ve bu sınıfı da gerekli sınıflara constructor injection ile dahil ettim..




<a href="https://github.com/barisertugrul/JavaCampAssignments/tree/main/assignment5.1">
  <img align="center" src="https://github-readme-stats.vercel.app/api/pin/?username=barisertugrul&show_owner=true&custom_title=Odevler&theme=vision-friendly-dark&repo=https://github.com/barisertugrul/JavaCampAssignments" />
</a>
