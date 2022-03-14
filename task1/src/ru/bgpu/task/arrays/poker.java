/*Задача 1
        Напишите программу, которая должна имитировать раздачу карт для игры в покер. Программа получает число n,
        задаваемое с консоли пользователем, и раздает карты на n игроков (по 5 карт каждому) из рассортированной колоды.
        Разделяйте пять карт, выданных каждому игроку, пустой строкой. Объект карты реализуется классом PlayingCard.
        Комментарии
        Для инициализации колоды карт задействуются статические поля SUITS_LIST и RANK_LIST класса PlayingCard.
        Перед раздачей колоду необходимо перемешать. Задействуйте класс Random.
        Программа должна валидировать вводимое количество игроков и при необходимости выводить сообщение об ошибке.

        выполнил: Мягокв Андрей
        */
package ru.bgpu.task.arrays;
import java.util.Scanner;

public class poker {
    public static void main(String[] args) {
        int mapPlayers = 5, fullMap = PlayingCard.RANK_LIST.length*PlayingCard.SUITS_LIST.length;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество игроков: ");
        if (sc.hasNext()) {
            int n = sc.nextInt();
            if ((n <= 10) && (n != 0)) {
                String[] coloda = new String[fullMap];
                for (int i = 0; i < PlayingCard.RANK_LIST.length; i++) {
                    for (int j = 0; j < PlayingCard.SUITS_LIST.length; j++) {
                        coloda[PlayingCard.SUITS_LIST.length * i + j] = PlayingCard.RANK_LIST[i]+ " " + PlayingCard.SUITS_LIST[j];
                    }
                }
                for (int i = 0; i < fullMap; i++) {
                    int r = i + (int) (Math.random() * (fullMap - i)); // случайная карта в колоде
                    String temp = coloda[r];
                    coloda[r] = coloda[i];
                    coloda[i] = temp;
                }
                for (int i = 0; i < n * mapPlayers; i++) {
                    System.out.println(coloda[i]);
                    if (i % mapPlayers == mapPlayers - 1)
                        System.out.println();
                }
            } else if (n >= 10) System.out.println("игроков должно быть от 0 до 10");
        } else System.out.println("Вы ввели символ");
    }
    }