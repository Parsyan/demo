package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Currency;
import java.util.Locale;


public class tests {
    public static void main(String[] args) {

        System.out.println(Currency.getAvailableCurrencies());
        System.out.println(Locale.ENGLISH.getUnicodeLocaleType("cu"));
        System.out.println(Currency.getInstance(Locale.ENGLISH).getDisplayName());
//        System.out.println(Currency.getInstance("ARM"));
    }

}