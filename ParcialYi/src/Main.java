import accidentes.*;

import java.util.Date;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carro c1 = new Carro("ABC123", "A", 2025);
        Carro c2 = new Carro("DEF123", "B", 2006);
        Carro c3 = new Carro("HIJ123", "A", 2014);
        Carro c4 = new Carro("KLM123", "A", 2018);
        Carro c5 = new Carro("NOP123", "B", 2022);
        Carro c6 = new Carro("QRS123", "C", 2009);

        Comentario com1 = new Comentario("Muy buen carro, corre mucho", "2025-09-25");
        Comentario com2 = new Comentario("Muy mal carro, no corre nada", "2023-03-26");
        Comentario com4 = new Comentario("Muy buen carro, no se queda sin gasolina", "2024-08-13");
        Comentario com3 = new Comentario("Muy mal carro, no frena nada", "2025-04-09");
        Comentario com5 = new Comentario("Muy buen carro, muy comodo", "2024-12-04");
        Comentario com6 = new Comentario("Muy buen carro, el volante pulla con un palito", "2023-06-17");

        Date d1 = new Date(2023, 8, 3);
        Date d2 = new Date(2024, 4, 23);
        Date d3 = new Date(2025, 9, 18);
        Incidente i1 = new Incidente(123L, "Falla de la transmision", d1, "124");
        Incidente i2 = new Incidente(456L, "Choque", d2, "126");
        Incidente i3 = new Incidente(789L, "Defecto de fabrica", d3, "128");

        Marca m1 = new Marca(11L, "Subaru", "Japon");
        Marca m2 = new Marca(22L, "Mercedes", "Alemania");
        Marca m3 = new Marca(33L, "BMW", "Alemmania");

        Dueno D1 = new Dueno(1l, "Oswald", "Disney", "123");
        Dueno D2 = new Dueno(2l, "Hortencia", "Goofy", "124");
        Dueno D3 = new Dueno(3l, "Pete", "Big", "125");
        Dueno D4 = new Dueno(4l, "Goofy", "Goofy", "126");
        Dueno D5 = new Dueno(5l, "Horace", "Gremlin", "127");
        Dueno D6 = new Dueno(6l, "Presciott", "Gremnlin", "128");

        ArrayList<Marca> Marcas = new ArrayList<>();
        Marcas.add(m1);
        Marcas.add(m2);
        Marcas.add(m3);

        ArrayList<Dueno> Duenos = new ArrayList<>();
        Duenos.add(D1);
        Duenos.add(D2);
        Duenos.add(D3);
        Duenos.add(D4);
        Duenos.add(D5);
        Duenos.add(D6);

        ArrayList<Incidente> Incidentes = new ArrayList<>();
        Incidentes.add(i1);
        Incidentes.add(i2);
        Incidentes.add(i3);

        c1.setMarca(m1);
        c2.setMarca(m2);
        c3.setMarca(m1);
        c4.setMarca(m1);
        c5.setMarca(m2);
        c6.setMarca(m3);

        Marca masV = null;
        int maxCarros = 0;

        for (Marca marca : Marcas) {
            int cantidad = marca.getCarros().size();
            if (cantidad > maxCarros) {
                maxCarros = cantidad;
                masV = marca;
            }
        }

        if (masV != null) {
            System.out.println("Marca más vendida: " + masV.getNombre() +
                    " (" + maxCarros + " carros)");
        } else {
            System.out.println("No hay marcas registradas.");
        }

        D2.agregarIncidente(i1);
        D4.agregarIncidente(i2);
        D6.agregarIncidente(i3);

        c1.vincularDueno(D1);
        c2.vincularDueno(D4);
        c3.vincularDueno(D3);
        c4.vincularDueno(D1);
        c5.vincularDueno(D5);
        c6.vincularDueno(D6);


        Marca marcaIncidentes = null;
        int maxIncidentes = 0;

        for (Marca marca : Marcas) {
            int totalIncidentes = 0;

            for (Carro carro : marca.getCarros()) {
                for (Dueno dueno : carro.getDuenos()) {
                    totalIncidentes += dueno.getIncidentes().size();
                }
            }

            if (totalIncidentes > maxIncidentes) {
                maxIncidentes = totalIncidentes;
                marcaIncidentes = marca;
            }
        }

        if (marcaIncidentes != null) {
            System.out.println("Marca con más incidentes: " + marcaIncidentes.getNombre() +
                    " (" + maxIncidentes + " incidentes)");
        } else {
            System.out.println("No hay incidentes registrados.");
        }

        ArrayList<String> paises = new ArrayList<>();
        ArrayList<Integer> Indx = new ArrayList<>();

        for (Marca marca : Marcas) {
            String pais = marca.getPais();
            int cantidadCarros = marca.getCarros().size();

            if (paises.contains(pais)) {
                int index = paises.indexOf(pais);
                Indx.set(index, Indx.get(index) + cantidadCarros);
            } else {
                paises.add(pais);
                Indx.add(cantidadCarros);
            }
        }

        String paisMasComun = null;
        int max = 0;

        for (int i = 0; i < paises.size(); i++) {
            if (Indx.get(i) > max) {
                max = Indx.get(i);
                paisMasComun = paises.get(i);
            }
        }

        if (paisMasComun != null) {
            System.out.println("País de origen más común: " + paisMasComun +
                    " (" + max + " carros)");
        } else {
            System.out.println("No hay países registrados.");
        }

        for (Dueno Dueno: Duenos){
            Dueno.mostrarIncidentes();
        }

        //todo menu y las consultas
    }
}


