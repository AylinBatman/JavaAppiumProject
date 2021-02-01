package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Methods;

import java.net.MalformedURLException;


public class MyStepdefs {
    Methods nesne = new Methods();

    @Given("^Login \"([^\"]*)\" \"([^\"]*)\"$")
    public void logins(String u, String p) throws Throwable {
        nesne.setup();
        nesne.loginAccount(u,p);
    }
    @Given("^Login$")
    public void login(String u, String p) throws InterruptedException, MalformedURLException {
        nesne.setup();
        nesne.loginAccount(u,p);
    }

    @Then("^Sepete yönlenerek sepetin boş olup olmadığının kontrolünü yapar ve anasayfaya geri döner.$")
    public void sepeteYönlenerekSepetinBoşOlupOlmadığınınKontrolünüYaparVeAnasayfayaGeriDöner() {
        nesne.sepeteGit();
        nesne.sepeteEmptyControl();
        nesne.BackGit();
    }

    @Then("^‘Atıştırmalık’ kategorisini açarak iki farklı ürün ekler\\.$")
    public void atıştırmalıkKategorisiniAçarakIkiFarklıÜrünEkler() {
        nesne.KategoriGit(2);
        nesne.urunEkle(1);
        nesne.urunEkle(2);
    }

    @Then("^Anasayfaya geri döner\\.$")
    public void anasayfayaGeriDöner() {
        nesne.BackGit();
    }

    @Then("^‘İçecek’ kategorisinden bir ürün ekler\\.$")
    public void içecekKategorisindenBirÜrünEkler() {
        nesne.KategoriGit(5);
        nesne.urunEkle(1);
    }

    @Then("^Sepete giderek sepetteki ürünleri siler\\.$")
    public void sepeteGiderekSepettekiÜrünleriSiler() {
        nesne.sepeteGit();
        nesne.urunSil();
    }

    @Then("^Anasayfadaki görülen kategori sayısını konsola bastırır\\.$")
    public void anasayfadakiGörülenKategoriSayısınıKonsolaBastırır() {
        nesne.categorySayısı();
    }

    @Then("^‘Atıştırmalık’ kategorisini açarak iki farklı üründen ikişer tane ekler\\.$")
    public void atıştırmalıkKategorisiniAçarakIkiFarklıÜründenIkişerTaneEkler() {
        nesne.KategoriGit(2);
        nesne.urunEkle(1);
        nesne.urunEkle(2);
    }

    @Then("^‘Yiyecek’ kategorisinden bir üründen uc adet ekler\\.$")
    public void yiyecekKategorisindenBirÜründenAdetEkler() {
        nesne.KategoriGit(4);
        nesne.urunEkle(1);
        nesne.urunEkle(2);
        nesne.urunEkleCoklu(1, 2);
        nesne.urunEkleCoklu(1, 2);
        nesne.urunEkleCoklu(2, 2);
        nesne.urunEkleCoklu(2, 2);
    }

    @Then("^Sepete giderek sepetteki ürünleri her birini birer adet daha arttırır\\.$")
    public void sepeteGiderekSepettekiÜrünleriHerBiriniBirerAdetDahaArttırır() {
        nesne.sepeteGit();
        nesne.urunEkleCoklu(1, 2);
        nesne.urunEkleCoklu(2, 2);
        nesne.scroll();
        nesne.urunEkleCoklu(3, 2);
        nesne.urunEkleCoklu(4, 2);
    }

    @Then("^Ürün sayılarının artıp artmadığını kontrol ettikten sonra sepetteki tüm ürünleri siler\\.$")
    public void ürünSayılarınınArtıpArtmadığınıKontrolEttiktenSonraSepettekiTümÜrünleriSiler() {
        nesne.sepetArtıControl();
        nesne.SepetiBosalt();

    }

    @Then("^Logout$")
    public void logout() {
        nesne.BackGit();
        nesne.logout();
    }


}
