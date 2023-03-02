package com.cursoceat.main;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

import javax.print.attribute.standard.Chromaticity;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("Dime tu fecha de nacimiento (dd-mm-aaaa");
		String fechaN=scanner.nextLine();
		String[] fechaNde=fechaN.split("-");
		String diaN=fechaNde[0];
		String mesN=fechaNde[1];
		String anioN=fechaNde[2];
		//La fecha de nacimiento la quiero convertir en un objeto tipo LocalDate
		// parse -> convierte
		fechaN=anioN+"-"+mesN+"-"+diaN;
		
		LocalDate fechaNN=LocalDate.parse(fechaN);
		
		System.out.println(fechaNN.getDayOfWeek()); //Muestro que dia de la semana naciste
		//plus + minus - //dias - mes - año
		LocalDate mas70=fechaNN.plus(70,ChronoUnit.YEARS);
		System.out.println("Te jubilarás en el año: "+mas70);
		System.out.println("Te jubilarás en el año: "+fechaNN.plus(70,ChronoUnit.YEARS));
		//ChronoUnit.YEARS * ChronoUnit.DAYS * ChronoUnit.MONTHS
		
		System.out.println("*********************");
				
		//guardar en BBDD -> aaaa-mm-dd <-
		//**Utilizando LocalDate**/
		LocalDate hoy= LocalDate.now();
		System.out.println("Fecha de Nacimiento ->" +fechaN);
		System.out.println("Hoy es ->" +hoy);
		System.out.println(hoy.getDayOfWeek()); //Monday... Sunday
		System.out.println(hoy.getMonth()); //January --- December
		System.out.println(hoy.getYear());
		System.out.println(hoy.getDayOfMonth()); //1...31
		System.out.println(hoy.getMonthValue()); //1...12
		Period aniosXJubilar=Period.between(mas70, hoy);
		System.out.println("Te faltan para jubilarte"+aniosXJubilar);
		System.out.println("Dime la fecha de nacimiento de tu madre [yyyy-mm-dd]");
		LocalDate fechaMama=LocalDate.parse(scanner.nextLine());
		Period xPeriod=Period.between(fechaNN, fechaMama);
		System.out.println("Mi madre tenia " +xPeriod);
		
		//Años bisiestos
		System.out.println("Dime una fecha cualquiera y compruebo si es bisiesto -> [yyyy-mm-dd]");
		LocalDate bisiesto=LocalDate.parse(scanner.nextLine());
		boolean bisiestoR=bisiesto.isLeapYear();
		if (bisiestoR) {
			System.out.println("Es un año bisiesto");
		}else {
			System.out.println("No es bisiesto");
		
		
		}
		
		//Formatear segun nuestra forma local -> patter --- patron 
		DateTimeFormatter formato=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());
		System.out.println(hoy.format(formato));
		DateTimeFormatter formato1=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());
		System.out.println(hoy.format(formato1));
		DateTimeFormatter formato2=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());
		System.out.println(hoy.format(formato2));
		DateTimeFormatter formato3=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.getDefault());
		System.out.println(hoy.format(formato3));
		DateTimeFormatter formato0=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(hoy.format(formato0));
		
		
		
	}

}
