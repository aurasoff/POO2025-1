package org.uniquindio.edu.co.poo.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class SoldadoTest {
    private static final Logger LOG = Logger.getLogger(SoldadoTest.class.getName());

    @Test
    public void creacionSoldadoTest() {

        Batallon batallon = new Batallon("hgh");

        Soldado soldado = new Soldado("56", "Aura", "Mesa", new ArrayList<>());
        Soldado soldado1 = new Soldado("57", "Ara", "Msa",new ArrayList<>());
        batallon.registrarSoldado(soldado1);
        assertThrows(Throwable.class, () -> batallon.registrarSoldado(soldado));
    }

    }