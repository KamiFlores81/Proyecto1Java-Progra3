package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.simple.JSONObject;

import Objeto.Equipo;

public class Main {

	private static Scanner sc;

	public static void main(String[] args) throws IOException {

		boolean salir = false;
		int opcion;
		sc = new Scanner(System.in);
		Equipo[] arrayEquipos = new Equipo[2]; //cambiar dependiendo la cantidad de equipos
		JSONObject jsonObject = new JSONObject();

		while (!salir) {
			System.out.println("Menusito");

			System.out.println("1. Ingreso de equipos");
			System.out.println("2. Listar equipos");
			System.out.println("3. Leer JSON");
			System.out.println("4. Generar JSON");
			System.out.println("5. Salir");

			try {

				System.out.println("Escribe una de las opciones");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					String equipo = "";
					int pj = 0;
					int pg = 0;
					int pe = 0;
					int pp = 0;
					int gf = 0;
					int gc = 0;
					int dfg = 0;
					int pts = 0;

					for (int x = 0; x < arrayEquipos.length; x++) {
						sc = new Scanner(System.in);
						System.out.println("Ingrese Equipo:");
						equipo = sc.nextLine();
						System.out.println("Ingrese partidos jugados:");
						pj = sc.nextInt();
						System.out.println("Ingrese partidos ganados:");
						pg = sc.nextInt();
						System.out.println("Ingrese partidos empatados:");
						pe = sc.nextInt();
						System.out.println("Ingrese partidos perdidos:");
						pp = sc.nextInt();
						System.out.println("Ingrese goles a favor:");
						gf = sc.nextInt();
						System.out.println("Ingrese goles en contra:");
						gc = sc.nextInt();
						System.out.println("Ingrese diferencia de goles:");
						dfg = sc.nextInt();
						System.out.println("Ingrese puntos totales:");
						pts = sc.nextInt();

						JSONObject subdata = new JSONObject();

						subdata.put("PJ", pj);
						subdata.put("PG", pg);
						subdata.put("PE", pe);
						subdata.put("PP", pp);
						subdata.put("GF", gf);
						subdata.put("GC", gc);
						subdata.put("DFG", dfg);
						subdata.put("PTS", pts);

						jsonObject.put(equipo, subdata);

						arrayEquipos[x] = new Equipo(equipo, pj, pg, pe, pp, gf, gc, dfg, pts);

					}
					break;
				case 2:

					try {
						Arrays.sort(arrayEquipos);
						System.out.println("POS|    EQUIPO  |PJ|PG|PE|PP|GF|GC|DFG|PTS");
						imprimirArrayEquipos(arrayEquipos);
					} catch (NullPointerException e) {
						System.out.println("No se han ingresado equipos:");
					}

					break;
				case 3:
					System.out.println("Tabla de posiciones: ");
					System.out.println(jsonObject);
					break;
				case 4:
					File json =new File("C:/tarea/output.json");
					FileWriter file = new FileWriter(json);
					file.write(jsonObject.toJSONString());
					file.close();
					System.out.println("Archivo JSON generado...");
					System.out.println("Tabla de posiciones: ");
					System.out.println(jsonObject);

					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Solo números entre 1 y 5");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sc.next();
			}
		}

	}

	static void imprimirArrayEquipos(Equipo[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println((i + 1) + ".| " + array[i].equipo + " | " + array[i].pj + " | " + array[i].pg + " | "
					+ array[i].pe + " | " + array[i].pp + " | " + array[i].gf + " | " + array[i].gc + " | "
					+ array[i].dfg + " | " + array[i].pts);
		}
	}

}