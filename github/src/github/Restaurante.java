package github;

import java.util.*;

/**
 * 10/02/2021
 *
 * @author Gonzalo Salmerón Robles
 */

public class Restaurante {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] mesa = new int[10];
		int[] ocupacionMaxima = {4, 4, 4, 2, 2, 4, 4, 6, 6, 8};
		int[] ocupacion = new int[mesa.length];

		for (int i = 0; i < mesa.length; i++) {
			mesa[i] = i + 1;
			int ocupacionInicial = ocupacionMaxima[i] + 1;
			ocupacion[i] = (int) (Math.random()*ocupacionInicial);
		}
		int personas = 0;
		System.out.println("╔═════════════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╗");
		System.out.print("║ Mesa nº     ║");
		for (int j = 0; j < mesa.length; j++) {
			System.out.printf("   %2d  ║", mesa[j]);
		}
		System.out.println("\n╠═════════════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣");
		System.out.print("║ Ocupación   ║");
		for (int j = 0; j < ocupacion.length; j++) {
			System.out.printf("   %1d/%1d ║", ocupacion[j], ocupacionMaxima[j]);
		}
		System.out.println("\n╚═════════════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╝");
		while (personas != -1) {
			System.out.print("¿Cuántos son? (Introduzca -1 para salir del programa): ");
			personas = in.nextInt();
			if (personas == -1) {
				System.out.println("Gracias, hasta luego.");
				System.exit(0);
			}
			if (personas > 8 || personas < -1) {
				System.out.println("Lo siento, no admitimos grupos de " + personas + ", haga grupos de 8 personas como máximo e intente de nuevo.");
			} else {
				boolean comprobador = false;
				boolean comprobador2 = false;
				for (int i = 0; i < ocupacion.length; i++) {
					if (ocupacion[i] == 0 && personas == ocupacionMaxima[i]) {
						System.out.println("Por favor, siéntese en la mesa número " + mesa[i] + ".");
						ocupacion[i] = personas;
						i = ocupacion.length;
						comprobador = true;
					}
				}
				if (comprobador != true) {
					for (int i = 0; i < ocupacion.length; i++) {
						int total = personas + ocupacion[i];
						if (total <= ocupacionMaxima[i]) {
							System.out.println("Tendrán que compartir mesa. Por favor, siéntese en la mesa número " + mesa[i] + ".");
							ocupacion[i] = total;
							i = ocupacion.length;
							comprobador2 = false;
						} else {
							comprobador2 = true;
						}
					}
				}
				if (comprobador2) {
					System.out.println("No hay sitio");
				}
			}
			System.out.println("╔═════════════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╦═══════╗");
			System.out.print("║ Mesa nº     ║");
			for (int j = 0; j < mesa.length; j++) {
				System.out.printf("   %2d  ║", mesa[j]);
			}
			System.out.println("\n╠═════════════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╬═══════╣");
			System.out.print("║ Ocupación   ║");
			for (int j = 0; j < ocupacion.length; j++) {
				System.out.printf("   %1d/%1d ║", ocupacion[j], ocupacionMaxima[j]);
			}
			System.out.println("\n╚═════════════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╩═══════╝");
		}
	}
}