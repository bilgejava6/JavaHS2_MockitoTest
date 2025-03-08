package com.muhammet;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
        Islemler mockIslemler = mock(Islemler.class);
        mockIslemler.ekranaYaz();
        when(mockIslemler.topla(anyInt(), anyInt())).thenReturn(24);
        System.out.println(mockIslemler.topla(15,9));
    }
    @Test
    void firstMock(){
        // List<String> list = new ArrayList<>(); // gerçek bir nesne
        List<String> list = mock(ArrayList.class); // sanal bir nesne
        list.add("Muhammet");
        list.add("Deniz");
        System.out.println("1. kişi...: "+ list.get(0));
        System.out.println("Listenin boyutu...: "+ list.size());
        list.forEach(System.out::println);
    }
    @Test
    void returnMock(){
        //List<String> list = new ArrayList();
        List<String> list = mock(ArrayList.class);
        /**
         * Methodların istediğimiz gibi davranmasını sağlayabiliriz.
         * when(METHOD_ÇAĞRIMI): bu işlem eğer içerdeki method çağırılırsa demektir.
         * thenReturn(DATA): verilecek cevabı giriniz.
         * anyInt(): Herhangi bir integer değer girilir ise.
         * 1- Kuralları tanımlarken sıralama önemlidir.
         * 2- method çağrımlarından önce yazılmalıdırlar
         */
        when(list.get(anyInt())).thenReturn("Default Değer");
        when(list.get(1)).thenReturn("Muhammet HOCA");
        when(list.get(2)).thenThrow(new RuntimeException("Beklenmeyen hata"));
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(98598));
        System.out.println(list.get(2));

    }
    /**
     * Controller dan gönderilen parametreler ile USerService ve UserRespository işlem yapıyor olsun.
     * burada gönderilen bilgiler ile userService.save ve userRepository.save merhodlarının çalıştırılması gereklidir.
     * bunların kullanılıp kullanılmadığı doğru parametreleri kullanıp kullanmadıkları test edilebilir.
     * User user = User.builder.name("").password("").build();
     * very(userService).save(user);
     */
    @Test
    void methodControl(){
        List<String> list = mock(ArrayList.class);
        list.add("Muhammet");
        list.add("Deniz");
        list.add("Ayşe");
        // mock nesnesinin add metodu "Deniz" değer ile çağırım yapmış mı?
        verify(list).add("Deniz");
        verify(list).add(anyString());
    }

    @Test
    void methodCagrimSayilari(){
        List<String> list = mock(ArrayList.class);

        list.add("Muhammet");

        list.add("Deniz");
        list.add("Deniz");

        list.add("Bahar");
        list.add("Bahar");
        list.add("Bahar");
        // muhammet bir kere çağılmış mıdır
        verify(list).add("Muhammet");
        verify(list, times(1)).add("Muhammet");
        verify(list, times(3)).add("Bahar");
        // hiç çağrım yaılmamış olmalı
        verify(list, never()).add("Hakkı");
        // en fazla 1 kere çağrım yapılmış olmak
        verify(list, atMostOnce()).add("Muhammet");
        verify(list, atMostOnce()).add("Demet");
        // en az bir kere çağırım
        verify(list,atLeastOnce()).add("Muhammet");
        verify(list,atLeastOnce()).add("Bahar");
        // en az 2 kere yada 5 kere  v.s.
        verify(list,atLeast(2)).add("Bahar");
        // en fazla 3 defa yada n defa v.s.
        verify(list,atMost(3)).add("TekinTAŞ");

    }

}
