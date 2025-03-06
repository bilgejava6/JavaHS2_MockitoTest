package com.muhammet;

public class Islemler {

    public void ekranaYaz(){
        System.out.println("Selamar JAVA");
    }

    public int topla(int a, int b){
        if(a>b) throw new RuntimeException("Hata");
        return a+b;
    }
}
