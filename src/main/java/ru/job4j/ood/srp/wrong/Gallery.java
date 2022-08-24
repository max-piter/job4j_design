package ru.job4j.ood.srp.wrong;

import java.util.Date;
import java.util.List;

/**
 * The interface Gallery.
 *В интерфейсе Gallery помимо  методов getPhoto и setPhoto
 * находятся методы writeComment(), setDate(), editPhoto(List<T> listOfFotos, T foto),
 * что  я вляется нарушением принципа sr
 * они должны быть выделены в отдельные интерфейсы
 */
public interface Gallery {
     <T> T getPhoto(List<T> listOfFotos, T foto);
     <T> T setPhoto(T foto, List<T> listOfFotos);
     void writeComment();
     void setDate(Date date);
     <T> T editPhoto(List<T> listOfFotos, T foto);
}
