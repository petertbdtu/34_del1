package cdio1;

import java.util.Scanner;
import desktop_resources.GUI;
import desktop_fields.Field;
import desktop_fields.Street;

public class Terningespil {

	public static void main(String[] args) {

		// GUI indstillinger sættes til en plade med ét felt
		Field[] fields = new Field[1];
		fields[0] = new Street.Builder()
				.setTitle("Start")
				.setSubText("")
				.setDescription("")
				.build();
		GUI.create(fields);


		// spillerne oprettes
		Scanner sc = new Scanner(System.in);
		System.out.println("Indtast spiller 1's navn");
		Spiller s1 = new Spiller(sc.nextLine());
		System.out.println("Indtast spiller 2's navn");
		Spiller s2 = new Spiller(sc.nextLine());
		
		GUI.addPlayer(s1.toString(),0);
		GUI.addPlayer(s2.toString(),0);

		boolean done = false;
		boolean spiller1stur = true;
		Spiller nutidigSpiller = s1;

		// løkken kører indtil den samlede scorer rammer 40 eller derover.
		while(!done) {
			
			nutidigSpiller = (spiller1stur ? s1 : s2);
			
			System.out.print("Din tur, " + nutidigSpiller.getSpiller() + "! ");
			System.out.println("Kast terningen på \"ENTER\"");
			promptEnter(sc);
			
			Terning t1 = new Terning();
			Terning t2 = new Terning();
			GUI.setDice(t1.kast(), t2.kast());
			System.out.println(t1);
			System.out.println(t2);
			nutidigSpiller.addPoint(t1.getVærdi() + t2.getVærdi());
			if (t1.getVærdi() == t2.getVærdi())
			{
				switch (t1.getVærdi())
				{
				case 1:
					System.out.println("Snake eyes! Dine point bliver nulstillet.");
					nutidigSpiller.nulstilPoint();
					spiller1stur = !spiller1stur;
					break;
				case 2:
				case 3:
				case 4:
				case 5:
					System.out.println("To ens!");
					if (nutidigSpiller.getPoint() > 40)
						done = true;
					break;
				case 6:
					System.out.println("Boxcars!");
					done = true;
					break;
				}
			}
			else
				spiller1stur = !spiller1stur;
			
			GUI.setBalance(s1.toString(),s1.getPoint());
			GUI.setBalance(s2.toString(),s2.getPoint());
			System.out.println(s1.getSpiller() + " har " + s1.getPoint() + " point.");
			System.out.println(s2.getSpiller() + " har " + s2.getPoint() + " point.");

		}
		System.out.println(nutidigSpiller.getSpiller() + " er vinderen!");
		sc.close();
	}
/*
 * Der oprettes en metode til Enter-funktionen
 * så denne er let at tilgå i den store programkode.
 */
public static void promptEnter(Scanner scanner) {
	scanner.nextLine();
}
}
