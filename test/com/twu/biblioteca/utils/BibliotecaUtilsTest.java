package com.twu.biblioteca.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaUtilsTest {
    private BibliotecaUtils bibliotecaUtils = new BibliotecaUtils();

    @Test
    public void fillBooksListTest() {
        assertFalse(bibliotecaUtils.fillBooksList().isEmpty());
    }

}