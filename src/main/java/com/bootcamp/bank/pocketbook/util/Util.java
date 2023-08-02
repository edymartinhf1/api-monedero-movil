package com.bootcamp.bank.pocketbook.util;

import com.bootcamp.bank.pocketbook.model.MonederoMovilDto;
import com.bootcamp.bank.pocketbook.model.MonederoMovilPost;
import com.bootcamp.bank.pocketbook.model.MonederoOperacionPost;
import com.bootcamp.bank.pocketbook.model.dao.MonederoMovilDao;
import com.bootcamp.bank.pocketbook.model.dao.MonederoOperacionDao;
import org.springframework.beans.BeanUtils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

    private static SecureRandom random = new SecureRandom ();
    public Util(){
        throw new IllegalStateException("Util is a utility class");
    }
    public static MonederoMovilDto fromMonederoMovilDaoToMonederoMovilDto(MonederoMovilDao monederoMovilDao) {
        MonederoMovilDto monederoMovilDto = new MonederoMovilDto();
        BeanUtils.copyProperties(monederoMovilDao,monederoMovilDto);
        return monederoMovilDto;
    }

    public static MonederoMovilDao fromMonederoMovilPostToMonederoMovilDao(MonederoMovilPost monederoMovilPost) {
        MonederoMovilDao monederoMovilDao = new MonederoMovilDao();
        BeanUtils.copyProperties(monederoMovilPost,monederoMovilDao);
        return monederoMovilDao;
    }

    public static MonederoOperacionDao fromMonederoOperacionPostToMonederoOperacionDao(MonederoOperacionPost monederoOperacionPost) {
        MonederoOperacionDao monederoOperacionDao = new MonederoOperacionDao();
        BeanUtils.copyProperties(monederoOperacionPost,monederoOperacionDao);
        return monederoOperacionDao;
    }

    public static LocalDateTime getCurrentDate(){
        return LocalDateTime.now();
    }

    public static String getCurrentDateAsString(String format) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return currentDate.format(formatter);
    }

    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static LocalDateTime getLocalDatefromString(String fecha) {
        String format="yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(fecha, formatter);
    }
}
