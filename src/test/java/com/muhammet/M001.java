package com.muhammet;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class M001 {
    /**
     * Mock kavramı bir nesnenin arayüzünü kopyalamak anlamına geliyor. Böylelikle
     * bir nesne içerisindeki tüm methodların kontrollü bir şekilde çalışması takip
     * edilebiliyor ve yönlendirillebiliyor.
     * Mock nesneler bağımlılıkların aksi durumlarını kontrollü bir şekilde
     * kontrol etmek için kullanılır. Böylece bağımlıklar test i manipüle
     * edemezler.
     */
    @Test
    void mockKavrami(){
        // gerçek ve nesne oluşturur ve methodlar çalışır.
        Islemler islemler = new Islemler();
        islemler.ekranaYaz();
        //System.out.println(islemler.topla(15,9));
        // bir mock nesnesi üretir ve methodlar gövdeye sahip değildir.
        Islemler mockIslemler = Mockito.mock(Islemler.class);
        mockIslemler.ekranaYaz();
        Mockito.when(mockIslemler.topla(Mockito.anyInt(), Mockito.anyInt())).thenReturn(24);
        System.out.println(mockIslemler.topla(15,9));
    }
    
}
