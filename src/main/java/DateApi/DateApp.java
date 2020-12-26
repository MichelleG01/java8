package DateApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateApp {

    public static void main(String[] args) {
        DateApp app = new DateApp();

        try {
            // app.verificar(8);
            // app.medirTiempo(8);
            // app.periodoEntreFechas(8);
            app.convertir(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verificar(int version) {
        //Para la version 1.7
        if (version == 7) {
            //Verificar si una fecha esta antes o despues de otra
            Calendar fecha1 = Calendar.getInstance();
            Calendar fecha2 = Calendar.getInstance();
            fecha1.set(1991, 0, 21);
            System.out.println(fecha1.after(fecha2));
        } else if (version == 8) { //Para la version 1.8
            //Ver si una fecha esta antes o despues de otra
            LocalDate fecha1 = LocalDate.of(1991, 01, 21);
            LocalDate fecha2 = LocalDate.now();

            System.out.println(fecha1.isAfter(fecha2));
            System.out.println(fecha1.isBefore(fecha2));

            //Ver si una hora esta antes o despues de otra
            LocalTime tiempo1 = LocalTime.of(22, 30, 50);
            LocalTime tiempo2 = LocalTime.now();

            System.out.println(tiempo1.isAfter(tiempo2));
            System.out.println(tiempo1.isBefore(tiempo2));

            //Ver si una fecha y hora esta antes o despues de otra
            LocalDateTime fechaTiempo1 = LocalDateTime.of(1991, 1, 21, 22, 30, 50);
            LocalDateTime fechaTiempo2 = LocalDateTime.now();

            System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
            System.out.println(fechaTiempo1.isBefore(fechaTiempo2));

        }
    }

    // currentTimeMillis
    public void medirTiempo(int version) throws InterruptedException {
        if (version == 7) {
            long ini = System.currentTimeMillis();
            Thread.sleep(1000);
            long fin = System.currentTimeMillis();
            System.out.println(fin - ini);
        } else if (version == 8) {
            Instant ini = Instant.now();
            Thread.sleep(1000); //dormir el hilo 1 segundo
            Instant fin = Instant.now();
            //Esta diferencia podemos convertirlas a dias, horas, minutos, etc. de acuerdo a la duracion
            System.out.println(Duration.between(ini, fin).toMillis());
        }
    }

    // Calendar
    public void periodoEntreFechas(int version) {
        if (version == 7) {
            //Calcular cuantos años, dias o minutos puede haber entre una fecha y otra
            Calendar nacimiento = Calendar.getInstance();
            Calendar actual = Calendar.getInstance();

            nacimiento.set(1995, 6, 21);
            actual.set(2020, 9, 04);

            int anios = 0;

            while (nacimiento.before(actual)) {
                nacimiento.add(Calendar.YEAR, 1);
                if (nacimiento.before(actual)) {
                    anios++;
                }
            }
            System.out.println(anios); //Cuantos años pasaron
        } else if (version == 8) {
            LocalDate nacimiento = LocalDate.of(1991, 1, 21);
            LocalDate actual = LocalDate.now();

            Period periodo = Period.between(nacimiento, actual);
            System.out.println("Han transcurrido " + periodo.getYears() + " años y " + periodo.getMonths() + " meses y "
                    + periodo.getDays() + " dias, desde " + nacimiento + " hasta " + actual);
        }
    }

    // Conversion
    public void convertir(int version) throws ParseException {
        if (version == 7) {
            String fecha = "21/01/1991";
            DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaConvertida = formateador.parse(fecha);
            System.out.println(fechaConvertida);

            Date fechaActual = Calendar.getInstance().getTime();
            formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
            String fechaCadena = formateador.format(fechaActual);
            System.out.println(fechaCadena);
        } else if (version == 8) {
            String fecha = "21/01/1991";
            DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //Obtener la fecha local
            LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
            System.out.println(fechaLocal);

            formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
            System.out.println(formateador.format(fechaLocal));
        }
    }

}
