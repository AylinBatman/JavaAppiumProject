Feature:  Senaryolar

  Scenario: Senaryo 1
    Given Login "hello@getir.com" "hello"
    And Sepete yönlenerek sepetin boş olup olmadığının kontrolünü yapar ve anasayfaya geri döner.
    And ‘Atıştırmalık’ kategorisini açarak iki farklı ürün ekler.
    And Anasayfaya geri döner.
    And ‘İçecek’ kategorisinden bir ürün ekler.
    Then Sepete giderek sepetteki ürünleri siler.

  Scenario: Senaryo 2
    Given Login "hello@getir.com" "hello"
    And Sepete yönlenerek sepetin boş olup olmadığının kontrolünü yapar ve anasayfaya geri döner.
    And Anasayfadaki görülen kategori sayısını konsola bastırır.
    And ‘Atıştırmalık’ kategorisini açarak iki farklı üründen ikişer tane ekler.
    And Anasayfaya geri döner.
    And ‘Yiyecek’ kategorisinden bir üründen uc adet ekler.
    And Sepete giderek sepetteki ürünleri her birini birer adet daha arttırır.
    Then Ürün sayılarının artıp artmadığını kontrol ettikten sonra sepetteki tüm ürünleri siler.


