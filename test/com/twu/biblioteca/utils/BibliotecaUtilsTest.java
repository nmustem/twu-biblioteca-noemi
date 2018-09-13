package com.twu.biblioteca.utils;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaUtilsTest {
    private BibliotecaUtils bibliotecaUtils = new BibliotecaUtils();

    @Test
    public void fillAvailableBooksListTest() {
        assertFalse(bibliotecaUtils.fillAvailableBooksList().isEmpty());
    }

}